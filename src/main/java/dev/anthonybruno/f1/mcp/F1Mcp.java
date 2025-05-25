package dev.anthonybruno.f1.mcp;

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

public class F1Mcp {

    public McpSyncServer attach(McpServerTransportProvider transportProvider) {
        // Create a server with custom configuration
        McpSyncServer syncServer = McpServer.sync(transportProvider)
                .serverInfo("f1-server", "1.0.0")
                .capabilities(McpSchema.ServerCapabilities.builder()
                        .tools(true)         // Enable tool support
                        .prompts(true)       // Enable prompt support
                        .logging()           // Enable logging support
                        .completions()      // Enable completions support
                        .build()).build();

        var f1ApiClient = new F1ApiClient();

        var circuitsClient = f1ApiClient.circuitsClient();
        var jsonSchema = new McpSchema.JsonSchema("object", Map.of(), List.of(), false, Map.of(), Map.of());
        var circuitTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 circuits", "f1 circuits", jsonSchema),
                (exchange, arguments) -> {
                    try {
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(circuitsClient.getAllCircuits().toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(circuitTool);


        var driversClient = f1ApiClient.driversClient();
        var driversJsonSchema = new McpSchema.JsonSchema("object", Map.of(), List.of(), false, Map.of(), Map.of());
        var driversTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 drivers", "f1 drivers", driversJsonSchema),
                (exchange, arguments) -> {
                    try {
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(driversClient.getAllDrivers().toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(driversTool);

        return syncServer;
    }
}
