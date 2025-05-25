# F1 API Client

A Java client for the [jolpica-f1](https://github.com/jolpica/jolpica-f1) API, which provides Formula 1 data, and a MCP server.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Installation & Build](#installation--build)
- [Usage](#usage)
  - [Creating a Client](#creating-a-client)
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
All major F1 endpoints are available as MCP tools:

- `f1 circuits`: Returns all circuits
- `f1 drivers`: Returns all drivers
- `f1 constructors`: Retrieve all F1 constructors in the database
- `f1 laps`: Retrieve all laps for the current F1 season
- `f1 pitstops`: Retrieve all pitstops for the current F1 season
- `f1 qualifying`: Retrieve all qualifying results for the current F1 season
- `f1 races`: Retrieve all F1 races in the database
- `f1 results`: Retrieve all race results for the current F1 season
- `f1 results by season and round`: Retrieve all race results for a specific F1 season and round (requires `season` and `round`)
- `f1 seasons`: Retrieve all F1 seasons available in the database
- `f1 sprint`: Retrieve all sprint race results for the current F1 season
- `f1 status`: Retrieve all possible driver finishing statuses in F1 races
- `f1 driver standings by season`: Retrieve all driver standings for a specific F1 season (requires `season`)
- `f1 constructor standings by season`: Retrieve all constructor standings for a specific F1 season (requires `season`)

### Integrate with Cursor
Add the following to the `mcp.json` config file.

``json
{
  "mcpServers": {
    "f1": {
      "url": "http://localhost:8080/sse"
    }
  }
}
```

## Testing

Run all tests with:

```sh
mvn test
```

## API Documentation

For more information about the API, see the [jolpica-f1 documentation](https://github.com/jolpica/jolpica-f1).

## License

This project is licensed under the MIT License - see the LICENSE file for details.