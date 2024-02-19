import java.sql.Connection;

public class Main {
    public static void  main(String[] args){
        DBfunctions db = new DBfunctions();
           Connection conn =db.connect_to_db("books_db","postgres","0000");
//       db.createTable(conn, "books");
       db.insert_row(conn,"books","White Fang","Jack London",1967,465);
    }

}
