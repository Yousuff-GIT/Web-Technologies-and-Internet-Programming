import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletOne extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve username from request
        String name1 = request.getParameter("username");

        out.println("<html><body>");
        out.println("<div align='center'><h1>Welcome! " + name1 + "</h1>");

        // Form submission to next servlet with hidden field
        out.println("<form action='Message' method='post'>");
        out.println("<input type='hidden' name='hiddenvalue' value='" + name1 + "'>");
        out.println("<input type='submit' value='Go'>");
        out.println("</form></div></body></html>");
    }
}
