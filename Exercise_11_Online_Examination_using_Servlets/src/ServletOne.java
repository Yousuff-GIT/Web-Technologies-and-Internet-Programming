import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ServletOne handles the validation of student login credentials.
 * If credentials are valid and the student hasn't attended the exam,
 * the student is redirected to the exam page.
 */
public class ServletOne extends HttpServlet {
    // JDBC configuration
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost/students";
    String USERNAME = "root";
    String PASSWORD = "root123";

    // Handles GET request (Session Expired scenario)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<div align='center'><h1>Session Expired!</h1></div>");
    }

    // Handles POST request from Login.jsp
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String value1 = request.getParameter("stdid");
        String value2 = request.getParameter("password");

        // Redirect to Invalid.jsp if fields are empty
        if (value1.isEmpty() || value2.isEmpty()) {
            response.sendRedirect("Invalid.jsp");
            return;
        }

        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery("SELECT * FROM information WHERE id = '" + value1 + "'");

            String sid = "", pwd = "", status = "";

            while (rst.next()) {
                sid = rst.getString("id");
                pwd = rst.getString("password");
                status = rst.getString("result");
            }

            conn.close();

            // Check credentials and redirect based on exam status
            if (value1.equals(sid) && value2.equals(pwd)) {
                if (status.equals("NIL")) {
                    session.setAttribute("identification1", value1);
                    response.sendRedirect("Exam.jsp");
                } else {
                    response.sendRedirect("Over.jsp");
                }
            } else {
                response.sendRedirect("Invalid.jsp");
            }

        } catch (Exception e) {
            System.out.println("Exception in Login");
            e.printStackTrace();
        }
    }
}
