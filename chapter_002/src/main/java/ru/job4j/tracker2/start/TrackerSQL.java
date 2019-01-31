package ru.job4j.tracker2.start;

import ru.job4j.tracker2.models.Item;
import ru.job4j.tracker2.start.interfaces.ITrackerSQL;

import java.sql.*;
import java.util.Random;

public class TrackerSQL implements ITrackerSQL, AutoCloseable {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String password = "qetupoi";
    private static final Random RN = new Random();
    Connection connection;

    public TrackerSQL() {

    }

    @Override
    public void add(Item item) {
        try (PreparedStatement pst = connection.prepareStatement("INSERT INTO tracker (name, description, createDate) VALUES (?, ?, ?)")) {
            pst.setString(1, item.getName());
            pst.setString(2, item.getDescription());
            Date date = new Date(System.currentTimeMillis());
            pst.setString(3, date.toString());
            ResultSet rs = pst.executeQuery();
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void replace(String id, Item item) {

    }

    @Override
    public void delete(String id) {
        try (PreparedStatement pst = connection.prepareStatement("DELETE FROM tracker WHERE id = ?")) {
            pst.setInt(1, Integer.parseInt(id));
            ResultSet rs = pst.executeQuery();
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean update(Item fresh) {
        try (PreparedStatement pst = connection.prepareStatement("UPDATE tracker SET name = ?,  description = ? WHERE id = ?")) {
            pst.setString(1, fresh.getName());
            pst.setString(2, fresh.getDescription());
            pst.setInt(3, Integer.parseInt(fresh.getId()));
            ResultSet rs = pst.executeQuery();
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public Item[] findAll() {
        return new Item[0];
    }


    @Override
    public void findByNameSQL(String key) {
        try (PreparedStatement pst = connection.prepareStatement("SELECT * FROM tracker WHERE name = ?")) {
            pst.setString(1, key);
            ResultSet rs = pst.executeQuery();
            this.show(rs);
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void findByIdSQL(String id) {
        try (PreparedStatement pst = connection.prepareStatement("SELECT * FROM tracker WHERE id = ?")) {
            pst.setInt(1, Integer.parseInt(id));
            ResultSet rs = pst.executeQuery();
            this.show(rs);
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllwithSQL() {
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tracker");
            this.show(rs);
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void close() throws Exception {

    }

    public void activate() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("CREATE TABLE tracker (id SERIAL PRIMARY KEY, name TEXT, description TEXT, createDate TEXT)");
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void show(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(String.format("Task with id-number %s named '%s' has description: '%s'. Date of birth - %s.", rs.getString("id"),
                        rs.getString("name"), rs.getString("description"), rs.getDate("createdate")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
