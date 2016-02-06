
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRead {
    public DataSource dataSource;

    public DatabaseRead(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {

        try {

            list();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Pacient> list() throws ClassNotFoundException, SQLException {
        // 1. load driver

        List<Pacient> pacienti = new ArrayList<Pacient>();
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/Agenda_Adrian";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query
        ResultSet rs = st.executeQuery("SELECT name,email,weight,height, index_bmi FROM bmi");

        // 6. iterate the result set and print the values
        while (rs.next()) {
            Pacient pacient = new Pacient();
            pacient.setName(rs.getString("name"));
            pacient.setEmail(rs.getString("email"));
            pacient.setW(rs.getString("weight"));
            pacient.setH(rs.getString("height"));
            pacient.setIndexBMI(rs.getString("index_bmi"));
            pacienti.add(pacient);
        }
        // 7. close the objects
        rs.close();
        st.close();
        conn.close();
        return pacienti;
    }
}

