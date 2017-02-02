package model;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Model implements DBInterface {
    protected static Connection connection=null;

    public static void connect() {
      try {
        Class.forName(DRIVER);
        connection=DriverManager.getConnection(
          URL, USERNAME, PASSWORD);
      }
      catch(Exception e) {
        e.printStackTrace();
      }
    }

    public static void disconnect() {
      try {
        if(connection!=null)
          connection.close();
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
}
