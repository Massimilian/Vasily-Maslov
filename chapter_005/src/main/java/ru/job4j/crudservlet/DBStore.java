package ru.job4j.crudservlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class DBStore implements Store {
    private static DBStore instance;
    private List<User> list = new CopyOnWriteArrayList<>();
    AtomicInteger value = new AtomicInteger(0);
    private String command;
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "qetupoi";
    Connection connection = null;
    private User admin = new User(1, "Admin", "Admin", "admin@crud.com", new Date(), "admin");

    public static DBStore getInstance() {
        if (instance == null) {
            instance = new DBStore();
        }
        return instance;
    }

    private boolean specialAdd() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = connection.prepareStatement("INSERT INTO users_system (id, name, login, email, create_date) VALUES (?, ?, ?, ?, ?) ON CONFLICT DO NOTHING");
            st.setLong(1, this.admin.getId());
            st.setString(2, this.admin.getName());
            st.setString(3, this.admin.getLogin());
            st.setString(4, this.admin.getEmail());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            st.close();
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
        return true;
    }

    private DBStore() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users_system (id SERIAL PRIMARY KEY, name VARCHAR(200), login VARCHAR(200), email VARCHAR(200), create_date TIMESTAMP, barray VARCHAR)");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.specialAdd();
        this.list = getList();
    }

    @Override
    public boolean userCheck(String login) {
        boolean result = false;
        if (!login.equals(admin.getLogin())) {
            for (User user : list) {
                if (user.getLogin().equals(login)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public boolean adminCheck(String login, String password) {
        return admin.getLogin().equals(login) && admin.getPassword().equals(password);
    }

    @Override
    public int getValue() {
        return this.value.incrementAndGet();
    }

    @Override
    public List<User> getList() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users_system");
            while (rs.next()) {
                users.add(new User(rs.getLong("id"), rs.getString("name"), rs.getString("login"), rs.getString("email"), rs.getTimestamp("create_date"), null));
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
        return users;
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public boolean add(User user) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = connection.prepareStatement("INSERT INTO users_system (name, login, email, create_date) VALUES (?, ?, ?, ?)");
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            st.close();
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
        this.list.add(user);
        return true;
    }

    @Override
    public boolean update(User user) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = connection.prepareStatement("UPDATE users_system SET name = ?, login = ?, email = ?, create_date = ? WHERE id=?");
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.setLong(5, user.getId());
            st.executeUpdate();
            st.close();
            //rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        updateInList(user);
        return true;
    }

    private void updateInList(User user) {
        for (User temp : this.list) {
            if (temp.equals(user)) {
                temp = user;
                break;
            }
        }
    }

    @Override
    public boolean delete(User user) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = connection.prepareStatement("DELETE FROM users_system VALUES WHERE id = ?");
            st.setLong(1, user.getId());
            st.executeUpdate();
            st.close();
            //rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.list.remove(user);
        return true;
    }

    @Override
    public List<User> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public void deleteAll() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("DELETE FROM users_system");
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public long findUserIdByLogin(String login) {
        long result = 0L;
        for (User user : this.list) {
            if (user.getLogin().equals(login)) {
                result = user.getId();
            }
        }
        return result;
    }
}