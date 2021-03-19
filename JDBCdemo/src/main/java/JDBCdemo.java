import java.sql.*;

public class JDBCdemo {

   public static void main(String[] args) throws SQLException {

    /**
     * Database credentials
     */
    String url = "jdbc:mysql://localhost:3306/census";
    String user = "root";
    String password = "password";

    /**
     * Creating a connection
     */
    Connection connection = DriverManager.getConnection(url, user, password);

    /**
     * Checking if the connection is not null
     */
    if (connection != null) {
      System.out.println("Connected to the database");
    }

    System.out.println("######  Reading the data from database #######");

    Statement statement = connection.createStatement();

    String sql = "select id, name, gender, aadhar_id, is_nri from citizens";

    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {

      System.out.print("Id is : " + resultSet.getInt("id") + "\t");
      System.out.print("Name is : " + resultSet.getString("name") + "\t");
      System.out.print("Gender is : " + resultSet.getString("gender") + "\t");
      System.out.print("Aadhar is : " + resultSet.getString("aadhar_id") + "\t");
      System.out.print("Nri_Id is : " + resultSet.getInt("is_nri") + "\t");

      System.out.println();
    }

    /**
     * closing the statement
     */
    statement.close();

    /**
     * Dynamically supplying arguments - PreparedStatement
     */

    System.out.println("#####  Dynamically supplying arguments - PreparedStatement  #####");

    String prepareSQL = "select id, name, gender, aadhar_id, is_nri from citizens where name=? and gender=?";

    PreparedStatement preparedStatement = connection.prepareStatement(prepareSQL);

    preparedStatement.setString(1, "anil");
    preparedStatement.setString(2, "Male");

    resultSet = preparedStatement.executeQuery();

    while (resultSet.next()) {

      System.out.print("Id is : " + resultSet.getInt("id") + "\t");
      System.out.print("Name is : " + resultSet.getString("name") + "\t");
      System.out.print("Gender is : " + resultSet.getString("gender") + "\t");
      System.out.print("Aadhar is : " + resultSet.getString("aadhar_id") + "\t");
      System.out.print("Nri_Id is : " + resultSet.getInt("is_nri") + "\t");

      System.out.println();
    }

    preparedStatement.close();

    /**
     * Getting the metadata about the result set
     */

    System.out.println("#####  Getting the metadata about the result set  #####");

    Statement stmt = connection.createStatement();

    String sqlString = "select id, name, gender, aadhar_id, is_nri from citizens limit 5";

    resultSet = stmt.executeQuery(sql);

    ResultSetMetaData resultSetMetaData = stmt.executeQuery(sqlString).getMetaData();

    System.out.println("Total columns: " + resultSetMetaData.getColumnCount());
    System.out.println("Column Name of 1st column: " + resultSetMetaData.getColumnName(1));
    System.out.println("Column Type Name of 1st column: " + resultSetMetaData.getColumnTypeName(1));

    /**
     * Closing statements
     */
    stmt.close();

    /**
     * Closing the opened connection
     */
    connection.close();
  }
}