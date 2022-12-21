import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // db parameters
            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "devpass";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here
            Statement statement = conn.createStatement();
            String studTab = ""
                    + "CREATE TABLE `students` ( "
                    + "  `student_id` int NOT NULL AUTO_INCREMENT, "
                    + "  `last_name` varchar(30) DEFAULT NULL, "
                    + "  `first_name` varchar(30) DEFAULT NULL, "
                    + "  PRIMARY KEY (`student_id`) "
                    + ") ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            statement.executeUpdate(studTab);
            String popTab = ""
                    + "insert into students (last_name, first_name) "
                    + "values "
                    + "('Rossi', 'Valentino'), "
                    + "('Bianchi', 'Roberto'), "
                    + "('Verdi', 'Domenico'), "
                    + "('Marrone', 'Mister');";
            statement.executeUpdate(popTab);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(conn != null){
                conn.close();}
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}