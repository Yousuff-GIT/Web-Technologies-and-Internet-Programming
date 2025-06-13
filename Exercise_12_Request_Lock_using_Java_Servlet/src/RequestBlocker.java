import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that validates the request origin using a generated hash key based on IP and port.
 * This servlet demonstrates how to lock/unlock requests using init parameters in web.xml.
 */
public class RequestBlocker extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        // Get configuration parameter (init-param from web.xml)
        ServletConfig config = getServletConfig();
        String AccessKey = config.getInitParameter("key");

        // Generate a key based on the server's hostname and port
        String host = request.getServerName();
        int port = request.getServerPort();
        String GeneratedKey = KeyGenerator(host, port);

        // Validate generated key against the access key
        if (GeneratedKey.equals(AccessKey)) {
            pw.print("<h1 align='center' style='color:green;'>Valid User</h1>");
        } else {
            pw.print("<h1 align='center' style='color:red;'>Invalid User</h1>");
        }
    }

    // Generates an MD5 hash based on hostname and port
    private String KeyGenerator(String hostname, int portnumber) {
        String encode = hostname + ":" + portnumber;
        StringBuilder encrypt = new StringBuilder();
        try {
            MessageDigest mdobj = MessageDigest.getInstance("MD5");
            mdobj.update(encode.getBytes());
            byte[] s1 = mdobj.digest();
            for (byte b : s1) {
                encrypt.append(Integer.toHexString((0x000000ff & b) | 0xffffff00).substring(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypt.toString();
    }
}
