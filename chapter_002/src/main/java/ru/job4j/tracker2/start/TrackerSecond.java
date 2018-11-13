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
        makeAction("CREATE TABLE tracker (id SERIAL PRIMARY KEY, name VARCHAR(50), description TEXT, code TEXT);");
    }

    public void add(ItemSecond item) {
        item.setId(this.generateId());
        items.add(item);
        this.makeAction(String.format("INSERT INTO tracker(name, description, code) VALUES ('%s', '%s', '%s');",
                item.getName(), item.getDescription(), item.getId()));
    }

    public void update(ItemSecond fresh) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) != null && this.items.get(i).getId().equals(fresh.getId())) {
                items.remove(i);
                this.makeAction(String.format("DELETE FROM tracker WHERE name='%s';", items.get(i).getName()));
                items.add(i, fresh);
                this.makeAction(String.format("INSERT INTO tracker(name, description, code) VALUES ('%s', '%s', '%s');",
                        fresh.getName(), fresh.getDescription(), fresh.getId()));
                break;
            }
        }
    }


    public void delete(String id) {
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                this.makeAction(String.format("DELETE FROM tracker WHERE code='%s';", items.get(i).getId()));
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
        this.makeAction(String.format("SELECT * FROM tracker WHERE name=%s;", key));
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
        this.makeAction(String.format("SELECT * FROM tracker WHERE code=%s;", id));
        return result;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public List<ItemSecond> getAll() {
        this.makeAction("SELECT * FROM tracker");
        return items;
    }

    @Override
    public void close() throws Exception {
    }

    public void makeAction(String action) {
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
            ResultSet rs = st.executeQuery(action);
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