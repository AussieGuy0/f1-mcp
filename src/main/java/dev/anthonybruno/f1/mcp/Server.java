package dev.anthonybruno.f1.mcp;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.server.transport.HttpServletSseServerTransportProvider;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class Server {

    private final int port;


    public Server(int port) {
        this.port = port;
    }

    private void start() {
        var objectMapper = new ObjectMapper();
        var transportProvider = new HttpServletSseServerTransportProvider(objectMapper, "f1");
        new F1Mcp().attach(transportProvider);


        try {
            // Create a Jetty server
            org.eclipse.jetty.server.Server jettyServer = new org.eclipse.jetty.server.Server(port);

            // Create a ServletContextHandler
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");

            // Create a custom servlet that integrates with the transportProvider
            // The path "/f1/*" is based on the constructor parameter of HttpServletSseServerTransportProvider
            context.addServlet(new ServletHolder(transportProvider), "/*");

            // Set the handler
            jettyServer.setHandler(context);

            // Start the server
            jettyServer.start();
            System.out.println("Jetty server started on port " + port);
            System.out.println("Access the F1 MCP Server at http://localhost:" + port + " /f1");

            // Keep the server running
            jettyServer.join();
        } catch (Exception e) {
            throw new RuntimeException("Failed to start Jetty server", e);
        }
    }

    public static void main(String[] args) {
        new Server(8080).start();
    }

}
