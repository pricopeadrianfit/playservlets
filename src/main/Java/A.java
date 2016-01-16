import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class A extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String sNr1=req.getParameter("nr1");//citesc nr1 din browser
        String sNr2=req.getParameter("nr2");//citesc nur2 din browser
        String sNr3=req.getParameter("nr3");//citesc nur2 din browser
        int nr1=Integer.parseInt(sNr1);
        int nr2=Integer.parseInt(sNr2);
        int nr3=Integer.parseInt(sNr3);
        int sum;
        sum =nr1+nr2+nr3;

        PrintWriter out =resp.getWriter();//deschid canal cu browserul

        out.println("Suma numerelor este:"+sum);


        out.close();
    }
}