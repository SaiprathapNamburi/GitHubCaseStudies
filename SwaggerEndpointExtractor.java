import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SwaggerEndpointExtractor {

    public static void main(String[] args) {
        String swaggerUrl = "http://petstore.swagger.io/v2/swagger.json"; // Example Swagger URL
        extractEndpoints(swaggerUrl);
    }

    public static void extractEndpoints(String swaggerUrl) {
        try {
            // Fetch Swagger JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new URL(swaggerUrl));

            // Extract paths (endpoints)
            JsonNode pathsNode = rootNode.path("paths");
            Iterator<String> pathIterator = pathsNode.fieldNames();
            
            System.out.println("Endpoints:");
            while (pathIterator.hasNext()) {
                String path = pathIterator.next();
                System.out.println(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
