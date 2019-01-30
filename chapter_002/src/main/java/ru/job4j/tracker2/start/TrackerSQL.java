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
        item.setId(this.generateId());
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = connection.prepareStatement("INSERT INTO tracker (id, name, description, createDate) VALUES (?, ?, ?, ?)");
            pst.setString(1, item.getId());
            pst.setString(2, item.getName());
            pst.setString(3, item.getDescription());
            Date date = new Date(System.currentTimeMillis());
            pst.setString(4, date.toString());
            ResultSet rs = pst.executeQuery();
            rs.close();
            pst.close();
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

    @Override
    public void replace(String id, Item item) {

    }

    @Override
    public void delete(String id) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = connection.prepareStatement("DELETE FROM tracker WHERE id = ?");
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            rs.close();
            pst.close();
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

    @Override
    public boolean update(Item fresh) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = connection.prepareStatement("UPDATE tracker SET name = ?,  description = ? WHERE id = ?");
            pst.setString(1, fresh.getName());
            pst.setString(2, fresh.getDescription());
            pst.setString(3, fresh.getId());
            ResultSet rs = pst.executeQuery();
            rs.close();
            pst.close();
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
        return true;
    }

    @Override
    public Item[] findAll() {
        return new Item[0];
    }


    @Override
    public void findByNameSQL(String key) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM tracker WHERE name = ?");
            pst.setString(1, key);
            ResultSet rs = pst.executeQuery();
            this.show(rs);
            rs.close();
            pst.close();
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

    @Override
    public void findByIdSQL(String id) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM tracker WHERE id = ?");
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            this.show(rs);
            rs.close();
            pst.close();
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

    public void getAllwithSQL() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tracker");
            this.show(rs);
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

    @Override
    public void close() throws Exception {

    }

    public void activate() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("CREATE TABLE tracker (id TEXT, name TEXT, description TEXT, createDate TEXT)");
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

    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    private void show(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(String.format("Task with id-number %s named %s has description: '%s'. Date of birth - %s.", rs.getString("id"),
                        rs.getString("name"), rs.getString("description"), rs.getDate("createdate")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
