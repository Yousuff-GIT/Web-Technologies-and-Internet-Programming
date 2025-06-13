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
 * ServletTwo evaluates the student answers submitted from Exam.jsp
 * and calculates marks, updates them in the database, and displays
 * the student mark list.
 */
public class ServletTwo extends HttpServlet {
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost/students";
    String USERNAME = "root";
    String PASSWORD = "root123";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<div align='center'><h1>Session Expired!</h1></div>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Object svalue = session.getAttribute("identification2");
        String sessionval = svalue.toString();

        // Collecting answers from the form
        String answer1 = request.getParameter("ans1");
        String answer2 = request.getParameter("ans2");
        String answer3 = request.getParameter("protocol");
        String answer4 = request.getParameter("js");
        String answer5 = request.getParameter("ans5");

        int marks = 0;
        String result;

        // Simple evaluation logic
        if (answer1.equalsIgnoreCase("world wide web consortium")) marks += 10;
        if (answer2.equalsIgnoreCase("hyper text transfer protocol")) marks += 10;
        if (answer3.equalsIgnoreCase("smtp")) marks += 10;
        if (answer4.equalsIgnoreCase("false")) marks += 10;
        if (answer5.equalsIgnoreCase("tcp/ip")) marks += 10;

        result = (marks >= 30) ? "PASS" : "FAIL";

        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();

            // Update marks and result
            stmt.execute("UPDATE information SET marks='" + marks + "' WHERE id='" + sessionval + "'");
            stmt.execute("UPDATE information SET result='" + result + "' WHERE id='" + sessionval + "'");

            // Fetch student details to show in result
            ResultSet rst = stmt.executeQuery("SELECT * FROM information WHERE id='" + sessionval + "'");

            String id = "", name = "", degree = "", branch = "", sem = "", college = "", stdmarks = "", stdresult = "";
            while (rst.next()) {
                id = rst.getString("id");
                name = rst.getString("sname");
                degree = rst.getString("degree");
                branch = rst.getString("discipline");
                sem = rst.getString("semester");
                college = rst.getString("college");
                stdmarks = rst.getString("marks");
                stdresult = rst.getString("result");
            }
            conn.close();

            // Generate HTML result
            out.print("<html><head><title>Student Mark List</title></head><body>");
            out.print("<form name='list' method='post' action='Login.jsp'>");
            out.print("<div align='center'><h2>Student Mark List</h2>");
            out.print("<table width='40%' height='260'>");
            out.print("<tr><td bgcolor='#0099FF'>Student - ID</td><td bgcolor='#0099FF'>" + id + "</td></tr>");
            out.print("<tr><td>Student Name</td><td>" + name + "</td></tr>");
            out.print("<tr><td bgcolor='#0099FF'>Degree</td><td bgcolor='#0099FF'>" + degree + "</td></tr>");
            out.print("<tr><td>Discipline</td><td>" + branch + "</td></tr>");
            out.print("<tr><td bgcolor='#0099FF'>Semester</td><td bgcolor='#0099FF'>" + sem + "</td></tr>");
            out.print("<tr><td>College</td><td>" + college + "</td></tr>");
            out.print("<tr><td bgcolor='#0099FF'>Marks</td><td bgcolor='#0099FF'>" + stdmarks + "</td></tr>");
            out.print("<tr><td>Result</td><td>" + stdresult + "</td></tr>");
            out.print("</table><input type='submit' name='Submit' value='OK' /></div></form></body></html>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
