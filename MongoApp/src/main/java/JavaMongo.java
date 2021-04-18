import com.mongodb.*;


import java.net.UnknownHostException;
import java.util.Arrays;

public class JavaMongo {
    public static void main(String[] args) throws UnknownHostException {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        DB db = mongoClient.getDB("products");

        DBCollection col = db.getCollection("purchases");

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("Sales" , new BasicDBObject("$gte",3000));
        basicDBObject.put("Profit" , new BasicDBObject("$gte",2000));


        DBCursor result = col.find(basicDBObject);
        while(result.hasNext()){
            System.out.println(result.next());
        }

    }
}
