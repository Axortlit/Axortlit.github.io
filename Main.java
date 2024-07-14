import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBExample {

    public static void main(String[] args) {
        // Conexión a MongoDB (asegúrate de tener MongoDB Server ejecutándose en localhost)
        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(uri);

        // Seleccionar la base de datos
        MongoDatabase database = mongoClient.getDatabase("Tienda");

        // Crear una colección
        String collectionName = "NEW_COLLECTION_NAME";
        database.createCollection(collectionName);

        // Obtener una referencia a la colección creada
        MongoCollection<Document> collection = database.getCollection(collectionName);

        // Insertar documentos de ejemplo en la colección
        insertDocuments(collection);

        // Cerrar el cliente de MongoDB
        mongoClient.close();
    }

    private static void insertDocuments(MongoCollection<Document> collection) {
        // Documentos de ejemplo
        Document document1 = new Document("name", "John Doe")
                .append("age", 30)
                .append("city", "New York");

        Document document2 = new Document("name", "Jane Smith")
                .append("age", 25)
                .append("city", "Los Angeles");

        // Insertar los documentos en la colección
        collection.insertOne(document1);
        collection.insertOne(document2);

        System.out.println("Documentos insertados correctamente.");
    }
}
