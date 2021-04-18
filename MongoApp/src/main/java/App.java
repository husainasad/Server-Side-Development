import com.mongodb.*;
import entities.Student;

import java.net.UnknownHostException;
import java.util.List;

public class App {
    public static void main(String[] args) throws UnknownHostException {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        List<String> dbs = mongoClient.getDatabaseNames();
//        System.out.println("List of databases are: "+dbs);

        /**
         * Write the code to ingest the data into mongodb
         */
        Student student = new Student(123, "Abhinav", 356, 28);

        DBObject doc = student.createDBObject();

        DB db = mongoClient.getDB("upgrad");

        DBCollection col = db.getCollection("students");

//        WriteResult result = col.insert(doc);
//        System.out.println(result.toString());

        /**
         * Data before update
         */
//        DBObject query = BasicDBObjectBuilder.start().add("_id", student.getId()).get();
//
//        DBCursor cursor = col.find(query);
//        while (cursor.hasNext()) {
//            System.out.println("Data before update: " + cursor.next());
//        }

        /**
         * Updating data in MongoDB
         */

//        student.setName("Vishwa");
//        doc = student.createDBObject();
//
//        WriteResult result = col.update(query, doc);
//        System.out.println(result.toString());

        /**
         * Reading data from MongoDB
         */
//        cursor = col.find(query);
//        while (cursor.hasNext()) {
//            System.out.println("Data after update: " +cursor.next());
//        }

        /**
         * Deleting data from MongoDB
         */
        DBObject query = BasicDBObjectBuilder.start().add("_id", student.getId()).get();
        WriteResult result = col.remove(query);
        System.out.println(result.toString());

        /**
         * Close resources
         */
        mongoClient.close();
    }
}
