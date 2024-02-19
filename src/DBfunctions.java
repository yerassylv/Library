import java.sql.*;
public class DBfunctions {
    public Connection connect_to_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection established");
            } else {
                System.out.println("Connection failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;

    }
    public void createTable(Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "create table " + table_name + "(empid SERIAL,book_name varchar(200),author varchar(200),year int,pages int,primary key(empid);";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void insert_row(Connection conn, String table_name, String book_title, String author, int year, int pages) {
        Statement statement;
        try {
            String query = String.format("insert into %s(book_name,author,) values ('%s','%s');", table_name, book_title, author, year, pages);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row added");
        } catch (
                Exception e) {
            System.out.println(e);
        }
    }
}


//    public void read_data(Connection conn, String table_name){
//        Statement statement;
//        ResultSet rs = null;
//        try{
//            String query = String.format("select * from %s",table_name);
//            statement = conn.createStatement();
//            rs = statement.executeQuery(query);
//            while(rs.next()){
//                System.out.println(rs.getString("empid")+"");
//                System.out.println(rs.getString("book_name")+"");
//                System.out.println(rs.getString("author")+"");
//            }
//        } catch(Exception e){
//            System.out.println(e);
//        }
//    }
//}
