import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;

/*
Обязательно создать пользователя базы данных
 */
public class MongoDBJDBC {
    public static void main(String[] args) throws ClassNotFoundException {
        MongoClient client = connectToStandAlone();
        MongoDatabase db = client.getDatabase("employees");
        QueryData(db);
    }

    private static MongoClient connectToStandAlone() {
       ArrayList<ServerAddress> hosts = new ArrayList<ServerAddress>();
        hosts.add(new ServerAddress("127.0.0.1", 27017));
        MongoCredential mongoCredential = MongoCredential.createCredential("admin", "employees", "admin".toCharArray());

       MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyToClusterSettings(clusterSettingsBuilder -> clusterSettingsBuilder.hosts(hosts))
                .credential(mongoCredential)
                .writeConcern(WriteConcern.W1)
                .readConcern(ReadConcern.MAJORITY)
                .readPreference(ReadPreference.nearest())
                .retryWrites(true)
                .build();

       MongoClient client = (MongoClient) MongoClients.create(mongoClientSettings);

        return client;
    }

    private static void QueryData(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("employer");
        /*
        MongoCursor<Document> cursor = collection.find(Filters.eq("job", "MANAGER"))
                //.sort(new Document("review_date", -1))
                .skip(0)
                .limit(20)
                .iterator();
         */

        MongoCursor<Document> cursor = collection.find().iterator();

        while(cursor.hasNext()) {
            Document document = cursor.next();
            String json = document.toJson();
            System.out.println(json);
        }
    }
} 