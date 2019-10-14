package ru.job4j.planner;

import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TaskStorage {
    private boolean result;
    private static TaskStorage instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String password = "qetupoi";

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    private TaskStorage() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(this.url, this.username, this.password);
            PreparedStatement st = connection.prepareStatement("CREATE TABLE IF NOT EXISTS tasks (id SERIAL PRIMARY KEY, info VARCHAR(200), create_date TIMESTAMP, urgency INTEGER)");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static TaskStorage getInstance() {
        if (instance == null) {
            instance = new TaskStorage();
        }
        return instance;
    }

    public boolean add(Task task) {
        this.result = true;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = connection.prepareStatement("INSERT INTO tasks (info, create_date, urgency) VALUES (?, ?, ?)");
            st.setString(1, task.getInfo());
            st.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            st.setInt(3, task.getUrgency());
            st.executeUpdate();
            st.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.result;
    }

    public boolean delete(int id) {
        boolean result = this.checkTask(id);
        if (result) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
                PreparedStatement st = connection.prepareStatement(String.format("DELETE FROM tasks VALUES WHERE id=%d", id));
                st.executeUpdate();
                st.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean edit(int id, Task task) {
        boolean result = this.checkTask(id);
        if (result) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
                PreparedStatement st = connection.prepareStatement("UPDATE tasks SET info=?, create_Date=?, urgency=? WHERE id=?");
                st.setString(1, task.getInfo());
                st.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                st.setInt(3, task.getUrgency());
                st.setInt(4, id);
                st.executeUpdate();
                st.close();
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<Task> asList() {
        ArrayList<Task> tasks = new ArrayList<Task>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tasks");
            while (rs.next()) {
                Task task = new Task(rs.getInt("id"), rs.getString("info"), rs.getInt("urgency"), rs.getTimestamp("create_date"));
                tasks.add(task);

            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (ArrayList<Task>) tasks.stream().sorted((a, b) -> Integer.compare(a.getUrgency(), b.getUrgency())).collect(Collectors.toList());
    }

    public String chosedColor(int color) {
        String result;
        switch (color) {
            case 1:
                result = "crimson";
                break;
            case 2:
                result = "orange";
                break;
            case 3:
                result = "gold";
                break;
            case 4:
                result = "chartreuse";
                break;
            case 5:
                result = "aquamarine";
                break;
            case 6:
                result = "aqua";
                break;
            case 7:
                result = "fuchsia";
                break;
            default:
                result = "aliceblue";
        }
        return result;
    }

    private boolean checkTask(int id) {
        return this.asList().stream().anyMatch(p -> p.getNumber() == id);
    }
}
