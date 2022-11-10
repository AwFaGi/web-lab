package org.example.util;


import org.example.beans.ExtendedPoint;

import java.sql.*;

public class Connector {
    private static final Connector INSTANCE = new Connector();

    Connection connection;

    public static Connector getInstance(){
        return INSTANCE;
    }

    private Connector(){
        try {
            String finalConnectionString;
            finalConnectionString = "jdbc:postgresql://localhost:5432/database";
            String name = "USERNAME";
            String pass = "ARIGATO";
            connection = DriverManager.getConnection(
                    finalConnectionString,
                    name,
                    pass
            );
            initDB();
        }catch (SQLException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void makeBigAdd(ExtendedPoint extendedPoint){
        try(PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO checks(id, x, y, r, date, working_time, status) VALUES (" +
                        "(SELECT nextval('id_generator')), ?,?,?,?,?,?" +
                        ")"
        )){
            statement.setDouble(1, extendedPoint.getX());
            statement.setDouble(2, extendedPoint.getY());
            statement.setDouble(3, extendedPoint.getR());
            statement.setTimestamp(4, Timestamp.valueOf(extendedPoint.getTimeStamp()));
            statement.setLong(5, extendedPoint.getWorkingTime());
            statement.setBoolean(6, extendedPoint.getStatus());
            statement.execute();
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    private void initDB() throws SQLException {
        try(Statement sm = connection.createStatement();){
            sm.execute("CREATE TABLE IF NOT EXISTS checks\n" +
                    "(\n" +
                    "    id     INTEGER PRIMARY KEY,\n" +
                    "    x      DOUBLE PRECISION,\n" +
                    "    y      DOUBLE PRECISION,\n" +
                    "    r      DOUBLE PRECISION,\n" +
                    "    date   TIMESTAMP,\n" +
                    "    working_time BIGINT,\n" +
                    "    status BOOLEAN\n" +
                    ");");
            sm.execute("CREATE SEQUENCE IF NOT EXISTS id_generator START 1 MINVALUE 1 MAXVALUE 2147483647;");
        }
    }

}
