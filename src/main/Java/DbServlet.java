import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/pacienti")
public class DbServlet extends HttpServlet {
    @Resource("jdbc/Agenda_Adrian") // For Tomcat, define as <Resource> in context.xml and declare as <resource-ref> in web.xml.
    private DataSource dataSource;
    public DatabaseRead databaseRead;

    @Override
   public void init() {
       databaseRead = new DatabaseRead(dataSource);
   }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Pacient> pacienti = null;
            try {
                pacienti = DatabaseRead.list();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            request.setAttribute("pacienti", pacienti); // Will be available as ${products} in JSP
            request.getRequestDispatcher("/WEB-INF/pacienti.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Cannot obtain pacienti from DB", e);
        }
    }

}