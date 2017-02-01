package model;

import java.sql.Connection;

public abstract class Model implements DBInterface {
    protected static Connection connection=null;

    public static void connect() {
        ;
    }

    public static void disconnect() {
        ;
    }
}
