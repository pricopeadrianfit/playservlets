
import java.sql.*;



public class DbConn {

    public static void main(String[] args) {
        try {
             Pacient pac = new Pacient();
             demoCreate(pac);



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static void demoCreate(Pacient p) throws ClassNotFoundException, SQLException {
        // 1. load driver
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/Agenda_Adrian";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);


        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO bmi (name, email, height, weight,index_bmi) VALUES (?,?,?,?,?)");
        pSt.setString(1, p.name);
        pSt.setString(2, p.email);
        pSt.setString(3, p.h);
        pSt.setString(4, p.w);
        pSt.setString(5, p.indexBMI);


        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();
        System.out.println("inserted:" + rowsInserted);
        // 6. close the objects
        pSt.close();
        conn.close();
    }
}

