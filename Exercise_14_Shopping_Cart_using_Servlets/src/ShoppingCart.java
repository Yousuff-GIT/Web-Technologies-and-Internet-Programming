// Servlet to handle cart checkout and show summary
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShoppingCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int amount = 0;
        String[] bookslist = request.getParameterValues("books");

        try {
            for (String book : bookslist)
                amount += 350;
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        Cookie[] cookie = request.getCookies();

        out.println("<HTML><BODY><div align='center'><H1>Purchase Details</H1><HR>");
        out.println("<FORM><TABLE>");
        out.println("<TR><TD>Username</TD><TD><INPUT type='text' disabled value='" + cookie[0].getValue() + "'></TD></TR>");
        out.println("<TR><TD>Credit Card Number</TD><TD><INPUT type='text' disabled value='" + cookie[1].getValue() + "'></TD></TR>");
        out.println("<TR><TD>Total Amount</TD><TD><INPUT type='text' disabled value='" + amount + "'></TD></TR>");
        out.println("</TABLE></FORM></div></BODY></HTML>");
    }
}
