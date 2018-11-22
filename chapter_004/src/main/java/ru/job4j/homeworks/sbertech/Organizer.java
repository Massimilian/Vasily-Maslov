package ru.job4j.homeworks.sbertech;

import java.sql.*;

public class Organizer {
    // ????????????? ???????????
    public void init() {
        String url = "jdbc:postgresql://localhost:5432/organizer";
        String username = "postgres";
        String password = "qetupoi";
        String driverName = "org.postgresql.Driver";
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = connection.prepareStatement("CREATE TABLE newTable (id int PRIMARY KEY)");
            ResultSet rs = st.executeQuery();
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
