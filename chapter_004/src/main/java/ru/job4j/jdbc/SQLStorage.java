package ru.job4j.jdbc;

import java.sql.*;
import java.util.logging.Logger;

public class SQLStorage {
    // Давайте создадим метод main.
    public static void main(String[] args) {
        // Скопируем куски кода, который нам предлагают.
        // Написали URL, по которому хотим коннектиться.
        String url = "jdbc:postgresql://localhost:5432/family";
        // теперь мы должны использовать username
        String username = "postgres";
        // вводим пароль базы данных
        String password = "qetupoi";
        // создаём статическую фабрику, которая должна получить запрос
        Connection connection = null;
        // всё это иницилизируем в try-catch
        try {
            // у нас есть Драйвер-менеджер, которому мы создаём объект (connection), используя статическую фабрику
            // передаём все необходимые данные - URL, имя и пароль
            connection = DriverManager.getConnection(url, username, password);
            // получаем запрос из объекта connection
            Statement st = connection.createStatement();
            // посылаем запрос на получение итератора ResultSet
            ResultSet rs = st.executeQuery("SELECT * FROM family");
            while(rs.next()) {
                // используем указание по имени колонки
                System.out.println(rs.getInt("years_old"));
            }
            // закрываем оба ресурса, которые ранее были открыты. Вообще закрывать надо в блоке finally
            rs.close();;
            st.close();
        } catch (SQLException e) {
            // обязательно прописываем метод, который помогает понять в случае ошибки, что же произошло в коде
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) {
                // если connection не равен нолю, его надо закрыть
                // ещё раз оборачиваем в try-catch
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
// Далее случается конфуз -  в лекции всё выводится на консоль, у меня же выводится только это:

//"C:\Program Files\Java\jdk1.8.0_144\bin\java"
//        "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2017.3\lib\idea_rt.jar=61819:" +
//        "C:\Program Files\JetBrains\IntelliJ IDEA 2017.3\bin" -Dfile.encoding=UTF-8 -classpath
//        "C:\Program Files\Java\jdk1.8.0_144\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_144\jre\lib\deploy.jar;" +
//        "C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\cldrdata.jar;" +
//        "C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\jaccess.jar;" +
//        "C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\localedata.jar;" +
//        "C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\sunec.jar;" +
//        "C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\sunmscapi.jar;" +
//        "C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\zipfs.jar;" +
//        "C:\Program Files\Java\jdk1.8.0_144\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_144\jre\lib\jce.jar;" +
//        "C:\Program Files\Java\jdk1.8.0_144\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_144\jre\lib\jfxswt.jar;" +
//        "C:\Program Files\Java\jdk1.8.0_144\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_144\jre\lib\management-agent.jar;" +
//        "C:\Program Files\Java\jdk1.8.0_144\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_144\jre\lib\resources.jar;" +
//        "C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar;C:\projects\Vasily-Maslov\chapter_004\target\classes;" +
//        "C:\Users\admin\.m2\repository\postgresql\postgresql\9.1-901-1.jdbc4\postgresql-9.1-901-1.jdbc4.jar;" +
//        "C:\Users\admin\.m2\repository\org\hamcrest\hamcrest-all\1.3\hamcrest-all-1.3.jar;" +
//        "C:\Users\admin\.m2\repository\org\apache\maven\doxia\doxia-module-markdown\1.4\doxia-module-markdown-1.4.jar;" +
//        "C:\Users\admin\.m2\repository\org\pegdown\pegdown\1.2.1\pegdown-1.2.1.jar;" +
//        "C:\Users\admin\.m2\repository\org\parboiled\parboiled-java\1.1.4\parboiled-java-1.1.4.jar;" +
//        "C:\Users\admin\.m2\repository\org\parboiled\parboiled-core\1.1.4\parboiled-core-1.1.4.jar;" +
//        "C:\Users\admin\.m2\repository\org\ow2\asm\asm\4.1\asm-4.1.jar;C:\Users\admin\.m2\repository\org\ow2\asm\asm-tree\4.1\asm-tree-4.1.jar;" +
//        "C:\Users\admin\.m2\repository\org\ow2\asm\asm-analysis\4.1\asm-analysis-4.1.jar;C:\Users\admin\.m2\repository\org\ow2\asm\asm-util\4.1\asm-util-4.1.jar;" +
//        "C:\Users\admin\.m2\repository\org\apache\maven\doxia\doxia-module-xhtml\1.4\doxia-module-xhtml-1.4.jar;" +
//        "C:\Users\admin\.m2\repository\org\codehaus\plexus\plexus-utils\3.0.10\plexus-utils-3.0.10.jar;" +
//        "C:\Users\admin\.m2\repository\org\apache\maven\doxia\doxia-core\1.4\doxia-core-1.4.jar;" +
//        "C:\Users\admin\.m2\repository\org\apache\maven\doxia\doxia-logging-api\1.4\doxia-logging-api-1.4.jar;" +
//        "C:\Users\admin\.m2\repository\org\codehaus\plexus\plexus-container-default\1.0-alpha-30\plexus-container-default-1.0-alpha-30.jar;" +
//        "C:\Users\admin\.m2\repository\org\codehaus\plexus\plexus-classworlds\1.2-alpha-9\plexus-classworlds-1.2-alpha-9.jar;" +
//        "C:\Users\admin\.m2\repository\xerces\xercesImpl\2.9.1\xercesImpl-2.9.1.jar;C:\Users\admin\.m2\repository\xml-apis\xml-apis\1.3.04\xml-apis-1.3.04.jar;" +
//        "C:\Users\admin\.m2\repository\commons-lang\commons-lang\2.4\commons-lang-2.4.jar;" +
//        "C:\Users\admin\.m2\repository\org\apache\httpcomponents\httpclient\4.0.2\httpclient-4.0.2.jar;" +
//        "C:\Users\admin\.m2\repository\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar;" +
//        "C:\Users\admin\.m2\repository\commons-codec\commons-codec\1.3\commons-codec-1.3.jar;" +
//        "C:\Users\admin\.m2\repository\org\apache\httpcomponents\httpcore\4.0.1\httpcore-4.0.1.jar;" +
//        "C:\Users\admin\.m2\repository\org\apache\maven\doxia\doxia-sink-api\1.4\doxia-sink-api-1.4.jar;" +
//        "C:\Users\admin\.m2\repository\org\codehaus\plexus\plexus-component-annotations\1.5.5\plexus-component-annotations-1.5.5.jar;" +
//        "C:\Users\admin\.m2\repository\org\junit\jupiter\junit-jupiter-api\5.3.1\junit-jupiter-api-5.3.1.jar;" +
//        "C:\Users\admin\.m2\repository\org\apiguardian\apiguardian-api\1.0.00\apiguardian-api-1.0.0.jar;" +
//        "C:\Users\admin\.m2\repository\org\opentest4j\opentest4j\1.1.1\opentest4j-1.1.1.jar;" +
//        "C:\Users\admin\.m2\repository\org\junit\platform\junit-platform-commons\1.3.1\junit-platform-commons-1.3.1.jar;4" +
//        "C:\Users\admin\.m2\repository\net\jcip\jcip-annotations\1.0\jcip-annotations-1.0.jar"
//        ru.job4j.jdbc.SQLStorage
//
//        �����: ���� ������ "family" �� ����������
//
//        Process finished with exit code 0