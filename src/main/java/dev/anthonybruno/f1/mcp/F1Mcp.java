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
        var noArgsSchema = new McpSchema.JsonSchema("object", Map.of(), List.of(), false, Map.of(), Map.of());
        var circuitTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 circuits", "f1 circuits", noArgsSchema),
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

        // Circuits by season
        var circuitsBySeasonSchema = objectSchema(Map.of("season", stringSchema()), List.of("season"));
        var circuitsBySeasonTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 circuits by season", "Get circuits for a specific season", circuitsBySeasonSchema),
                (exchange, arguments) -> {
                    try {
                        String season = (String) arguments.get("season");
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(circuitsClient.getCircuitsBySeason(season).toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(circuitsBySeasonTool);

        // Circuits by round
        var circuitsByRoundSchema = objectSchema(Map.of(
                "season", stringSchema(),
                "round", stringSchema()),
                List.of("season", "round"));
        var circuitsByRoundTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 circuits by round", "Get circuits for a specific round of a season", circuitsByRoundSchema),
                (exchange, arguments) -> {
                    try {
                        String season = (String) arguments.get("season");
                        String round = (String) arguments.get("round");
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(circuitsClient.getCircuitsByRound(season, round).toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(circuitsByRoundTool);

        // Circuit by ID
        var circuitByIdSchema = objectSchema(Map.of("circuitId", stringSchema()), List.of("circuitId"));
        var circuitByIdTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 circuit by id", "Get a circuit by its ID", circuitByIdSchema),
                (exchange, arguments) -> {
                    try {
                        String circuitId = (String) arguments.get("circuitId");
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(String.valueOf(circuitsClient.getCircuitById(circuitId)))
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(circuitByIdTool);

        // Drivers by season
        var driversBySeasonSchema = objectSchema(Map.of("season", stringSchema()), List.of("season"));
        var driversBySeasonTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 drivers by season", "Get drivers for a specific season", driversBySeasonSchema),
                (exchange, arguments) -> {
                    try {
                        String season = (String) arguments.get("season");
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(driversClient.getDriversBySeason(season).toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(driversBySeasonTool);

        // Drivers by round
        var driversByRoundSchema = objectSchema(Map.of(
                "season", stringSchema(),
                "round", stringSchema()),
                List.of("season", "round"));
        var driversByRoundTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 drivers by round", "Get drivers for a specific round of a season", driversByRoundSchema),
                (exchange, arguments) -> {
                    try {
                        String season = (String) arguments.get("season");
                        String round = (String) arguments.get("round");
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(driversClient.getDriversByRound(season, round).toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(driversByRoundTool);

        var constructorsClient = f1ApiClient.constructorsClient();
        var constructorsTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 constructors", "Retrieve all F1 constructors in the database.", noArgsSchema),
                (exchange, arguments) -> {
                    try {
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(constructorsClient.getAllConstructors().toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(constructorsTool);

        var lapsClient = f1ApiClient.lapsClient();
        var lapsTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 laps", "Retrieve all laps for the current F1 season.", noArgsSchema),
                (exchange, arguments) -> {
                    try {
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(lapsClient.getLapsBySeason("current").toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(lapsTool);

        var pitstopsClient = f1ApiClient.pitstopsClient();
        var pitstopsTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 pitstops", "Retrieve all pitstops for the current F1 season.", noArgsSchema),
                (exchange, arguments) -> {
                    try {
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(pitstopsClient.getPitstopsBySeason("current").toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(pitstopsTool);

        var qualifyingClient = f1ApiClient.qualifyingClient();
        var qualifyingTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 qualifying", "Retrieve all qualifying results for the current F1 season.", noArgsSchema),
                (exchange, arguments) -> {
                    try {
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(qualifyingClient.getQualifyingBySeason("current").toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(qualifyingTool);

        var racesClient = f1ApiClient.racesClient();
        var racesTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 races", "Retrieve all F1 races in the database.", noArgsSchema),
                (exchange, arguments) -> {
                    try {
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(racesClient.getAllRaces().toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(racesTool);

        var resultsClient = f1ApiClient.resultsClient();
        var resultsTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 results", "Retrieve all race results for the current F1 season.", noArgsSchema),
                (exchange, arguments) -> {
                    try {
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(resultsClient.getResultsBySeason("current").toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(resultsTool);

        var resultsBySeasonRoundSchema = objectSchema(Map.of(
                "season", stringSchema(),
                "round", stringSchema()),
                List.of("season", "round"));
        var resultsBySeasonRoundTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 results by season and round", "Retrieve all race results for a specific F1 season and round.", resultsBySeasonRoundSchema),
                (exchange, arguments) -> {
                    try {
                        String season = (String) arguments.get("season");
                        String round = (String) arguments.get("round");
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(resultsClient.getResultsByRound(season, round).toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(resultsBySeasonRoundTool);

        var seasonsClient = f1ApiClient.seasonsClient();
        var seasonsTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 seasons", "Retrieve all F1 seasons available in the database.", noArgsSchema),
                (exchange, arguments) -> {
                    try {
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(seasonsClient.getAllSeasons().toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(seasonsTool);

        var sprintClient = f1ApiClient.sprintClient();
        var sprintTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 sprint", "Retrieve all sprint race results for the current F1 season.", noArgsSchema),
                (exchange, arguments) -> {
                    try {
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(sprintClient.getSprintBySeason("current").toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(sprintTool);

        var statusClient = f1ApiClient.statusClient();
        var statusTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 status", "Retrieve all possible driver finishing statuses in F1 races.", noArgsSchema),
                (exchange, arguments) -> {
                    try {
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(statusClient.getAllStatus().toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(statusTool);

        var driverStandingsClient = f1ApiClient.driverStandingsClient();
        var driverStandingsBySeasonSchema = objectSchema(Map.of("season", stringSchema()), List.of("season"));
        var driverStandingsBySeasonTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 driver standings by season", "Retrieve all driver standings for a specific F1 season.", driverStandingsBySeasonSchema),
                (exchange, arguments) -> {
                    try {
                        String season = (String) arguments.get("season");
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(driverStandingsClient.getDriverStandingsBySeason(season).toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(driverStandingsBySeasonTool);

        var constructorStandingsClient = f1ApiClient.constructorStandingsClient();
        var constructorStandingsBySeasonSchema = objectSchema(Map.of("season", stringSchema()), List.of("season"));
        var constructorStandingsBySeasonTool = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("f1 constructor standings by season", "Retrieve all constructor standings for a specific F1 season.", constructorStandingsBySeasonSchema),
                (exchange, arguments) -> {
                    try {
                        String season = (String) arguments.get("season");
                        return McpSchema.CallToolResult.builder()
                                .addTextContent(constructorStandingsClient.getConstructorStandingsBySeason(season).toString())
                                .build();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        syncServer.addTool(constructorStandingsBySeasonTool);

        return syncServer;
    }

    // --- Helper methods for schema construction ---
    private static McpSchema.JsonSchema stringSchema() {
        return new McpSchema.JsonSchema("string", Map.of(), List.of(), false, Map.of(), Map.of());
    }

    private static McpSchema.JsonSchema objectSchema(Map<String, Object> properties, List<String> required) {
        return new McpSchema.JsonSchema("object", properties, required, false, Map.of(), Map.of());
    }
}
