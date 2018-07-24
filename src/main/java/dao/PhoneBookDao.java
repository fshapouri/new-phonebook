package dao;

import service.PhoneBookEntity;
import service.PhoneBookService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PhoneBookDao {
    private static String dbURL = "jdbc:derby://localhost:1527/c:/derbyDB;create=true";
    private static Connection cn = null;
    private static Statement st = null;

    private static void open() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        cn = DriverManager.getConnection(dbURL);
        st = cn.createStatement();
    }

    public static void insertPhoneBook(PhoneBookEntity phoneBookEntity) {

        try {

            open();
            st.executeUpdate("INSERT INTO PHONEBOOK ( PHONEBOOKNAME ) "+ " VALUES ("+phoneBookEntity.getPhonebookName()+")");
            close();

        }catch (Exception sqlExcept) {

            if (sqlExcept.getMessage().equals("Table/View 'PHONEBOOK' already exists in Schema 'APP'.")) {

                try {
                    st.executeUpdate("CREATE TABLE PHONEBOOK (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),phonebookName VARCHAR(255), PRIMARY KEY (ID) )");
                    insertPhoneBook(phoneBookEntity);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else {
                sqlExcept.printStackTrace();
            }
        }
    }

//    public static void createTable(PhoneBookEntity phoneBookEntity) {}


    private static void close() throws Exception{
        st.close();
        cn.close();
    }
}




