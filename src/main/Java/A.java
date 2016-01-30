import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

class Pacient {
    String name;
    String email;
    String h;
    String w;
    String indexBMI;
}


public class A extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sNr1=req.getParameter("height");//citesc  din browser
        String sNr2=req.getParameter("weight");
        String sNr3=req.getParameter("name");
        String sNr4=req.getParameter("email");

        float height=Float.parseFloat(sNr1);
        int weight=Integer.parseInt(sNr2);
        System.out.println(sNr1);

        float BMI;
        Pacient pacientnou =new Pacient();
        pacientnou.name=sNr3;
        pacientnou.email=sNr4;
        pacientnou.h=sNr1;
        pacientnou.w=sNr2;


        BMI = weight / (height * height);

        String sNr5 = Float.toString(BMI);
        pacientnou.indexBMI=sNr5;


        try {
            DbConn.demoCreate(pacientnou);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrintWriter out =resp.getWriter();//deschid canal cu browserul

        out.println(BMI);


        if (BMI < 18.5) {
            out.printf("  You are underweight! Go home and eat!");
        }
            else
                if (BMI >= 18.5 && BMI <= 24.9) {
                  out.printf("  You have a normal weight. ");
        }
                else
                     if (BMI >= 25 && BMI <= 29.9) {
                       out.printf("  You are overweight! Go to the gym!");
        }
                     else
                         out.printf("  You are obese! Go to the nutritionist!");

        out.close();
    }
}
