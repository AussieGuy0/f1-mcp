# F1 API Client

A Java client for the jolpica-f1 API, which provides Formula 1 data, and an optional MCP server exposing F1 data as Model Context Protocol tools.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Installation & Build](#installation--build)
- [Usage](#usage)
  - [Creating a Client](#creating-a-client)
  - [Circuits API](#circuits-api)
  - [Drivers API](#drivers-api)
  - [Driver Standings API](#driver-standings-api)
  - [Constructor Standings API](#constructor-standings-api)
- [MCP Server](#mcp-server)
- [Testing](#testing)
- [API Documentation](#api-documentation)
- [License](#license)

## Features

- Simple, fluent API for accessing Formula 1 data
- Support for all endpoints in the jolpica-f1 API
- MCP server for exposing F1 data as Model Context Protocol tools

## Requirements

- Java 23 or higher
- Maven (for build/test)

## Installation & Build

Clone the repository and build with Maven:

```sh
mvn package
```

## Usage

### Creating a Client

```java
// Create a client with default configuration
F1ApiClient apiClient = new F1ApiClient();

// Or use a custom base URL
F1ApiClient apiClient = new F1ApiClient("https://api.jolpi.ca");
```

### Circuits API

```java
CircuitsClient circuitsClient = apiClient.circuitsClient();

// Get all circuits
List<Circuit> circuits = circuitsClient.getAllCircuits();

// Get circuits with pagination
List<Circuit> circuits = circuitsClient.getAllCircuits(30, 10); // offset 30, limit 10

// Get circuits for a specific season
List<Circuit> circuits = circuitsClient.getCircuitsBySeason("2023");

// Get a specific circuit by ID
Circuit circuit = circuitsClient.getCircuitById("monza");

// Get circuits for a specific round of a season
List<Circuit> circuits = circuitsClient.getCircuitsByRound("2023", "1");
```

### Drivers API

```java
DriversClient driversClient = apiClient.driversClient();

// Get all drivers
List<Driver> drivers = driversClient.getAllDrivers();

// Get drivers with pagination
List<Driver> drivers = driversClient.getAllDrivers(30, 10); // offset 30, limit 10

// Get drivers for a specific season
List<Driver> drivers = driversClient.getDriversBySeason("2023");

// Get a specific driver by ID
Driver driver = driversClient.getDriverById("hamilton");

// Get drivers for a specific round of a season
List<Driver> drivers = driversClient.getDriversByRound("2023", "1");

// Get drivers for a specific circuit
List<Driver> drivers = driversClient.getDriversByCircuit("monza");

// Get drivers for a specific constructor
List<Driver> drivers = driversClient.getDriversByConstructor("mercedes");
```

### Driver Standings API

```java
DriverStandingsClient driverStandingsClient = apiClient.driverStandingsClient();

// Get driver standings for a season
List<DriverStanding> standings = driverStandingsClient.getDriverStandingsBySeason("2023");

// Get driver standings for a specific round
List<DriverStanding> standings = driverStandingsClient.getDriverStandingsByRound("2023", "1");

// Get driver standings for a specific driver in a season
List<DriverStanding> standings = driverStandingsClient.getDriverStandingsByDriver("2023", "hamilton");

// Get driver standings for a specific position in a season
List<DriverStanding> standings = driverStandingsClient.getDriverStandingsByPosition("2023", "1");
```

### Constructor Standings API

```java
ConstructorStandingsClient constructorStandingsClient = apiClient.constructorStandingsClient();

// Get constructor standings for a season
List<ConstructorStanding> standings = constructorStandingsClient.getConstructorStandingsBySeason("2023");

// Get constructor standings for a specific round
List<ConstructorStanding> standings = constructorStandingsClient.getConstructorStandingsByRound("2023", "1");

// Get constructor standings for a specific constructor in a season
List<ConstructorStanding> standings = constructorStandingsClient.getConstructorStandingsByConstructor("2023", "mercedes");

// Get constructor standings for a specific position in a season
List<ConstructorStanding> standings = constructorStandingsClient.getConstructorStandingsByPosition("2023", "1");
```

## MCP Server

This project includes an optional MCP (Model Context Protocol) server that exposes F1 data as MCP tools over HTTP (Jetty).

### Running the MCP Server

Build the project, then run:

```sh
java -cp target/f1-mcp-1.0-SNAPSHOT.jar dev.anthonybruno.f1.mcp.Server
```

By default, the server starts on port 8080. Access the MCP server at:

```
http://localhost:8080/f1
```

### Exposed Tools
- `f1 circuits`: Returns all circuits
- `f1 drivers`: Returns all drivers

(You can extend the server to expose more tools by editing `F1Mcp.java`.)

## Testing

Run all tests with:

```sh
mvn test
```

## API Documentation

For more information about the API, see the [jolpica-f1 documentation](https://github.com/jolpica/jolpica-f1).

## License

This project is licensed under the MIT License - see the LICENSE file for details.