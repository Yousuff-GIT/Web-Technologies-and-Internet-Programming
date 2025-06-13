import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTwo extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve value from hidden field
        String name2 = request.getParameter("hiddenvalue");

        out.println("<html><body>");
        out.println("<div align='center'><h1>Hello, " + name2 + "</h1>");
        out.println("<br><br><h2>This Site is Under Construction</h2>");
        out.println("</div></body></html>");
    }
}
