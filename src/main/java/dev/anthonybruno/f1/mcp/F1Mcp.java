package dev.anthonybruno.f1.mcp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.anthonybruno.f1.api.client.CircuitsClient;
import dev.anthonybruno.f1.api.client.F1ApiClient;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpSyncServer;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerTransportProvider;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class F1Mcp {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public McpSyncServer attach(McpServerTransportProvider transportProvider) {
        var f1ApiClient = new F1ApiClient();

        var circuitsClient = f1ApiClient.circuitsClient();
        var circuitsResource = new McpServerFeatures.SyncResourceSpecification(
                new McpSchema.Resource(
                        "f1://circuits",
                        "F1 Circuits",
                        "All F1 circuits as a resource",
                        "application/json",
                        null
                ),
                (exchange, request) -> {
                    try {
                        return new McpSchema.ReadResourceResult(
                                toJsonContents((circuit) -> "f1://circuits/" + circuit.circuitId(), circuitsClient.getAllCircuits())
                        );
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        var driversClient = f1ApiClient.driversClient();
        var driversResource = new McpServerFeatures.SyncResourceSpecification(
                new McpSchema.Resource(
                        "f1://drivers",
                        "F1 Drivers",
                        "All F1 drivers as a resource",
                        "application/json",
                        null
                ),
                (exchange, request) -> {
                    try {
                        return new McpSchema.ReadResourceResult(
                                toJsonContents((driver) -> "f1://drivers/" + driver.driverId(), driversClient.getAllDrivers())
                        );
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        Map<String, McpServerFeatures.SyncResourceSpecification> resources = Map.of(
                "f1://circuits", circuitsResource,
                "f1://drivers", driversResource
        );

        return McpServer.sync(transportProvider)
                .serverInfo("f1-server", "1.0.0")
                .capabilities(McpSchema.ServerCapabilities.builder()
                        .resources(true, true)
                        .prompts(true)       // Enable prompt support
                        .logging()           // Enable logging support
                        .completions()      // Enable completions support
                        .build())
                .resources(resources)
                .build();
    }

    private <T> List<McpSchema.ResourceContents> toJsonContents(Function<T, String> uriFunction, List<T> objects) {
        return objects.stream().map(object -> ((McpSchema.ResourceContents) new McpSchema.TextResourceContents(uriFunction.apply(object), "application/json", toJson(object)))).toList();
    }

    private String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
