import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HitCounter extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Create or retrieve existing session
        HttpSession session = request.getSession(true);

        // Get visit count from session
        Integer count = (Integer) session.getAttribute("tracker.count");
        if (count == null)
            count = 1;
        else
            count = count + 1;

        // Store updated count back in session
        session.setAttribute("tracker.count", count);

        out.println("<html><head><title>SessionTracker</title></head>");
        out.println("<body><h1>Session Tracking Demo</h1>");
        out.println("You have visited this page " + count + ((count == 1) ? " time." : " times."));
        out.println("<p><h2>Here is the session data:</h2>");

        // Print all session attributes
        Enumeration<String> attributes = session.getAttributeNames();
        while (attributes.hasMoreElements()) {
            String name = attributes.nextElement();
            out.println(name + ": " + session.getAttribute(name) + "<br>");
        }

        out.println("</body></html>");
    }
}
