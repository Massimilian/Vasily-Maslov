package ru.job4j.homeworks;
//13.48. В таблице должны быть напечатаны оценки каждого из 23 учеников класса по двенадцати предметам
//        (в первом столбце — по первому предмету, во второй — по второму и т. д.).
//        Названия предметов указаны в соответствующем столбце первой строки. Выяснилось,
//        что в таблицу забыли записать оценки еще по одному предмету. Изменить таблицу так,
//        чтобы в ней было название пропущенного предмета и оценки по нему,
//        учитывая, что этот предмет в списке должен быть на k-м месте.

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Task1348 {
    private int count = 0;
    private String comma = ", ";
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String password = "qetupoi";


    public Task1348(ArrayList<String> names) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(this.url, this.username, this.password);
            PreparedStatement st = connection.prepareStatement(this.prepareCommand(names));
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addMarks(String subject, TreeMap<String, Integer> marks) {
        this.addMarks(subject, marks, count);
    }

    public void addMarks(String subject, TreeMap<String, Integer> marks, int position) {
        this.count = position > this.count ? position : this.count;
        if (this.container().contains(subject)) {
            addNewMarks(subject, marks, position, false);
        } else {
            addNewMarks(subject, marks, position, true);
        }
    }

    public ArrayList<String> takeMarks(String pupil) {
        ArrayList<String> numbers = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT %s FROM marks ORDER BY number", pupil));
            while (rs.next()) {
                numbers.add(rs.getString(pupil));
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
        return numbers;
    }

    public void addNewPupil(String surname) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(this.url, this.username, this.password);
            PreparedStatement st = connection.prepareStatement(String.format("ALTER TABLE marks ADD COLUMN %s VARCHAR", surname));
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deletePupil(String surname) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(this.url, this.username, this.password);
            PreparedStatement st = connection.prepareStatement(String.format("ALTER TABLE marks DROP COLUMN %s", surname));
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(this.url, this.username, this.password);
            PreparedStatement st = connection.prepareStatement("DROP TABLE IF EXISTS marks");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addNewMarks(String subject, TreeMap<String, Integer> marks, int position, boolean isNew) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = connection.prepareStatement(this.prepareMarksForAdd(subject, marks, position, isNew));
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
    }

    private ArrayList<String> container() {
        ArrayList<String> subjects = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT lesson FROM marks");
            while (rs.next()) {
                subjects.add(rs.getString("lesson"));
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
        return subjects;
    }

    private String prepareCommand(ArrayList<String> names) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS marks (number INTEGER, lesson VARCHAR");
        for (int i = 0; i < names.size(); i++) {
            sb.append(", ");
            sb.append(names.get(i));
            sb.append(" VARCHAR");
        }
        sb.append(")");
        return sb.toString();
    }

    private String prepareMarksForAdd(String subject, TreeMap<String, Integer> marks, int position, boolean isNew) {
        String result;
        if (isNew) {
            result = this.prepareNewSubjectMarks(subject, marks, position);
        } else {
            result = this.prepareOldSubjectMarks(subject, marks);
        }
        return result;
    }

    private String prepareNewSubjectMarks(String subject, TreeMap<String, Integer> marks, int position) {
        StringBuilder sb = new StringBuilder();
        if (position <= this.count) {
            this.changePositions(position);
        }
        sb.append("INSERT INTO marks (number, lesson, ");
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            sb.append(entry.getKey());
            sb.append(comma);
        }
        sb.setLength(sb.length() - 2);
        sb.append(") VALUES (");
        sb.append(position);
        sb.append(comma);
        sb.append(" '");
        sb.append(subject);
        sb.append("'");
        sb.append(comma);
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            sb.append(entry.getValue());
            sb.append(comma);
        }
        sb.setLength(sb.length() - 2);
        sb.append(")");
        return sb.toString();
    }

    private String prepareOldSubjectMarks(String subject, TreeMap<String, Integer> marks) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE marks SET ");
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" = ");
            sb.append(entry.getValue());
            sb.append(this.comma);
        }
        sb.setLength(sb.length() - 2);
        sb.append(" WHERE lesson = '");
        sb.append(subject);
        sb.append("'");
        return sb.toString();
    }

    private void changePositions(int position) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement st = connection.prepareStatement(String.format("UPDATE marks SET number = %d WHERE number <=%d", count++, position));
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
    }
}
