package ru.job4j.tracker2.start;

import ru.job4j.tracker2.models.*;

import java.sql.*;
import java.util.*;

public class TrackerSecond implements AutoCloseable {
    private List<ItemSecond> items = new ArrayList<>();
    private static final Random RN = new Random();
    private Connection connection;

    public ItemSecond getItem(int position) {
        return items.get(position);
    }

    public void firstStep() {
        String url = "jdbc:postgresql://localhost:5432/tracker";
        String username = "postgres";
        String password = "qetupoi";
        String driverName = "org.postgresql.Driver";
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("CREATE TABLE tracker (id SERIAL PRIMARY KEY, name VARCHAR(50), description TEXT, time TIMESTAMP)");
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


    public void add(ItemSecond item) {
        item.setId(this.generateId());
        items.add(item);
    }

    public void update(ItemSecond fresh) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) != null && this.items.get(i).getId().equals(fresh.getId())) {
                items.remove(i);
                items.add(i, fresh);
                break;
            }
        }
    }


    public void delete(String id) {
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                break;
            }
        }
    }

    public ArrayList<ItemSecond> findByName(String key) {
        ArrayList<ItemSecond> result = new ArrayList<>();
        for (ItemSecond item : items) {
            if (item != null && item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    protected ItemSecond findById(String id) {
        ItemSecond result = null;
        for (ItemSecond item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public List<ItemSecond> getAll() {
        return items;
    }

    @Override
    public void close() throws Exception {
    }
}