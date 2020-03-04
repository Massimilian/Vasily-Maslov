package ru.job4j.vocabulary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class WordStorage {
    private List<Word> words = new CopyOnWriteArrayList<Word>();
    private static WordStorage instance = null;
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String password = "qetupoi";
    private boolean add = false;
    private boolean delete = false;
    private Connection connection = null;

    private WordStorage() {
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public static WordStorage getInstance() {
        if (instance == null) {
            instance = new WordStorage();
            instance.init();
        }
        return instance;
    }

    private void init() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("CREATE TABLE IF NOT EXISTS words (word VARCHAR, translate VARCHAR)");
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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

    public List getWords() {
        getInstance().words.clear();
        getInstance().takeWords();
        return getInstance().words;
    }

    private void takeWords() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = connection.prepareStatement("SELECT * FROM words");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                getInstance().words.add(new Word(rs.getString("word"), rs.getString("translate")));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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

    public void add(String word, String translate) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = connection.prepareStatement("INSERT INTO words (word, translate) VALUES (?, ?)");
            st.setString(1, word);
            st.setString(2, translate);
            ResultSet rs = st.executeQuery();
            rs.close();
            st.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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

    public void delete(String word) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = connection.prepareStatement("DELETE FROM words WHERE word='" + word + "' OR translate='" + word + "'");
            ResultSet rs = st.executeQuery();
            rs.close();
            st.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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

    public Word getWord() {
        List<Word> temp = instance.getWords();
        return temp.get(new Random().nextInt(temp.size()));
    }
}


