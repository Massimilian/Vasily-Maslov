package ru.job4j.journal;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Journal {
    private Connection connection;
    private static Journal instance;
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String password = "qetupoi";
    private ArrayList<String> pupils;
    private ArrayList<String> disciplines;
    private String message;

    public String getMessage() {
        return message;
    }

    public ArrayList<String> getDisciplines() {
        return disciplines;
    }

    private Journal() {
        pupils = new ArrayList<>();
        disciplines = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(this.url, this.username, this.password);
            PreparedStatement st = connection.prepareStatement("CREATE TABLE IF NOT EXISTS journal (name VARCHAR, last_change TIMESTAMP)");
            st.executeUpdate();
            st.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Journal getInstance() {
        if (instance == null) {
            instance = new Journal();
        }
        return instance;
    }

    public boolean addNewPupil(String name) {
        boolean result;
        if (pupils.contains(name)) {
            this.message = "False! This pupil is already in the journal.";
            result = false;
        } else {
            pupils.add(name);
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
                PreparedStatement st = connection.prepareStatement("INSERT INTO journal (name, last_change) VALUES (?, ?)");
                st.setString(1, name);
                st.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                st.executeUpdate();
                st.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            result = true;
        }
        return result;
    }


    public boolean addNewDiscipline(String discipline) {
        boolean result;
        if (disciplines.contains(discipline)) {
            this.message = "False! This discipline exists in the journal.";
            result = false;
        } else {
            disciplines.add(discipline);
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
                PreparedStatement st = connection.prepareStatement(String.format("ALTER TABLE journal ADD COLUMN %s VARCHAR(1) DEFAULT '*'", discipline));
                st.executeUpdate();
                st.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            result = true;
        }
        return result;
    }

    public boolean deletePupil(String name) {
        boolean result;
        if (!pupils.contains(name)) {
            this.message = "Impossible operation! This pupil doesn't exist.";
            result = false;
        } else {
            pupils.remove(name);
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
                PreparedStatement st = connection.prepareStatement("DELETE FROM journal WHERE name=?");
                st.setString(1, name);
                st.executeUpdate();
                st.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            result = true;
        }
        return result;
    }

    public boolean deleteDiscipline(String discipline) {
        boolean result;
        if (!disciplines.contains(discipline)) {
            this.message = "False! There is no this discipline here.";
            result = false;
        } else {
            disciplines.remove(discipline);
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
                PreparedStatement st = connection.prepareStatement(String.format("ALTER TABLE journal DROP COLUMN %s", discipline));
                st.executeUpdate();
                st.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            result = true;
        }
        return result;
    }

    public boolean addMarks(String name, HashMap<String, String> marks) {
        boolean result;
        if (!pupils.contains(name) || !checkMap(marks)) {
            result = false;
        } else {
            for (Map.Entry<String, String> entry : marks.entrySet()) {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                    PreparedStatement st = connection.prepareStatement(String.format("UPDATE journal SET %s = ? WHERE name = ?", entry.getKey()));
                    st.setString(1, entry.getValue());
                    st.setString(2, name);
                    st.executeUpdate();
                    st.close();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
            result = true;
        }
        return result;
    }

    public String[][] prepareTable() {
        String[][] pupilsAndMarks = new String[pupils.size()][disciplines.size() + 2];
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM journal");
            int pupilNum = 0;
            while (rs.next()) {
                int position = 0;
                pupilsAndMarks[pupilNum][position++] = rs.getString("name");
                for (String discipline : disciplines) {
                    pupilsAndMarks[pupilNum][position++] = rs.getString(discipline);
                }
                pupilsAndMarks[pupilNum][position] = rs.getTimestamp("last_change").toString();
                pupilNum++;
            }
            st.close();
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pupilsAndMarks;
    }

    public void deleteAll() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(this.url, this.username, this.password);
            PreparedStatement st = connection.prepareStatement("DROP TABLE IF EXISTS journal");
            st.executeUpdate();
            st.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean checkMap(HashMap<String, String> marks) {
        boolean result = true;
        for (Map.Entry<String, String> entry : marks.entrySet()) {
            if (!(entry.getKey().matches("[A-Za-z][a-z]*") || entry.getValue().matches("[0-9]{1,2}|n|i|\\*"))) {
                result = false;
                break;
            }
        }
        return result;
    }
}
