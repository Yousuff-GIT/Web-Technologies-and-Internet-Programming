// Servlet to handle login and show available books
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginKart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            ServletConfig config = getServletConfig();
            String credentials = config.getInitParameter(username);
            String[] parameters = credentials.split(",");

            if (password.equals(parameters[0])) {
                out.println("<HTML><BODY><div align='center'><H1>Hello! " + username + "</H1><HR>");
                out.println("<H2>Books Available for Purchase</H2>");
                out.println("<FORM action='ShoppingCart' method='post'>");
                out.println("<INPUT type='checkbox' name='books' value='ccp'>Mastering C++<BR>");
                out.println("<INPUT type='checkbox' name='books' value='java1'>Core Java Volume-I<BR>");
                out.println("<INPUT type='checkbox' name='books' value='java2'>Core Java Volume-II<BR>");
                out.println("<INPUT type='checkbox' name='books' value='networks'>Computer Networks<BR>");
                out.println("<BR><INPUT type='submit' value='Add to Cart'></FORM></div></BODY></HTML>");
            } else {
                out.println("<HTML><BODY><div align='center'><H2>Sorry! you are not an Authentic User</H2></div></BODY></HTML>");
            }

            Cookie cookie_name = new Cookie("cname", username);
            Cookie cookie_no = new Cookie("cardno", parameters[1]);
            cookie_name.setMaxAge(60);
            cookie_no.setMaxAge(60);
            response.addCookie(cookie_name);
            response.addCookie(cookie_no);

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<HTML><BODY><div align='center'><H2>Please enter valid username and password</H2></div></BODY></HTML>");
        }
    }
}
