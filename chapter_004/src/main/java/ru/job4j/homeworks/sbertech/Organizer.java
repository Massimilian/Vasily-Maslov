
package ru.job4j.homeworks.sbertech;

import java.sql.*;
import java.util.Scanner;

public class Organizer {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String pass = "qetupoi";
    Connection connection = null;
    String ls = System.lineSeparator();
    Scanner scanner = new Scanner(System.in);

    public Organizer() {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            Statement st = connection.createStatement();
            st.execute("CREATE TABLE organizer (id SERIAL PRIMARY KEY, name VARCHAR(200), position VARCHAR(200), organization VARCHAR(200), mail VARCHAR(50), phone VARCHAR(20))");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqle) {
                    System.out.println(sqle.getMessage());
                }
            }
        }
    }

    public void help() {
        int incr = 0;
        System.out.printf("%sWelcome to organizer!%s For help press %d.%s To insert new client press %d.%s For update your client press %d.%s To delete your client press %d.%s To show all clients press %d.%s To find the client by the phone number press %d.%s To exit press %d.", ls, ls, ++incr, ls, ++incr, ls, ++incr, ls, ++incr, ls, ++incr, ls, ++incr, ls, ++incr);
    }

    public void insert(String[] info) {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = connection.prepareStatement("INSERT INTO organizer (name, position, organization, mail, phone) VALUES (?, ?, ?, ?, ?)");
            for (int i = 0; i < 5; i++) {
                pst.setString(i + 1, info[i]);
            }
            pst.executeQuery();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqle) {
                    System.out.println(sqle.getMessage());
                }
            }
        }
        System.out.println("Inserted successfully!");
    }

    public void update(String firstName, String[] info) {
        int incr = 0;
        try {
            connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = connection.prepareStatement("UPDATE organizer SET name = ?, position = ?, organization = ?, mail = ?, phone = ? WHERE name = ?");
            for (int i = 0; i < 5; i++) {
                pst.setString(i + 1, info[i]);
            }
            pst.setString(6, firstName);
            pst.executeQuery();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqle) {
                    System.out.println(sqle.getMessage());
                }
            }
        }
        System.out.println("Updated successfully!");
    }

    public void delete(String name) {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = connection.prepareStatement("DELETE FROM organizer WHERE name = ?");
            pst.setString(1, name);
            pst.executeQuery();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqle) {
                    System.out.println(sqle.getMessage());
                }
            }
        }
        System.out.printf("%s deleted!%s", name, System.lineSeparator());
    }

    public void list() {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM organizer");
            int incr = 0;
            while (rs.next()) {
                incr++;
                System.out.printf("Returned card №%d info:%s1. Name - %s;%s2. Position - %s;%s3. Organization - %s;%s4. Mail - %s;%s5. Phone - %s.%s%s",
                        incr, ls, rs.getString("name"), ls, rs.getString("position"), ls,
                        rs.getString("organization"), ls, rs.getString("mail"), ls,
                        rs.getString("phone"), ls, ls);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqle) {
                    System.out.println(sqle.getMessage());
                }
            }
        }
    }

    public void findByTel(String phone) {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM organizer WHERE phone = ?");
            pst.setString(1, phone);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.printf("Returned card info:%s1. Name - %s;%s2. Position - %s;%s3. Organization - %s;%s4. Mail - %s;%s5. Phone - %s.%s%s",
                        ls, rs.getString("name"), ls, rs.getString("position"), ls,
                        rs.getString("organization"), ls, rs.getString("mail"), ls,
                        rs.getString("phone"), ls, ls);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqle) {
                    System.out.println(sqle.getMessage());
                }
            }
        }
    }

    public boolean finish() {
        System.out.printf("*****%sThank you for using organizer. Good-bye!", System.lineSeparator());
        return false;
    }

    public String[] getInfo() {
        String[] info = new String[5];
        int incr = 0;
        System.out.println("Write name of the client:");
        info[incr++] = scanner.nextLine();
        System.out.println("Write position of the client:");
        info[incr++] = scanner.nextLine();
        System.out.println("Write organization of the client:");
        info[incr++] = scanner.nextLine();
        System.out.println("Write e-mail of the client:");
        info[incr++] = scanner.nextLine();
        System.out.println("Write the phone number of the client:");
        info[incr++] = scanner.nextLine();
        return info;
    }

    public String getSmallInfo(String pos) {
        System.out.printf("Write %s of the client:", pos);
        return scanner.nextLine();
    }
}
