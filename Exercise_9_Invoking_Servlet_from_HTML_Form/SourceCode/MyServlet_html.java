// MyServlet_html.java
// This servlet receives form input and performs basic arithmetic operations using the input.

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet_html extends HttpServlet {
    // Variable declarations
    String name;
    int count = 0;
    float num1, num2, add, sub, mul, div;

    // Method to handle POST request from HTML form
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Setting response content type as HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        count++;  // Increment counter to track servlet invocation

        try {
            // Reading user input parameters
            name = request.getParameter("username");
            num1 = Float.parseFloat(request.getParameter("number1"));
            num2 = Float.parseFloat(request.getParameter("number2"));

            // Performing arithmetic operations
            add = num1 + num2;
            sub = num1 - num2;
            mul = num1 * num2;
            div = num1 / num2;

            // Designing the servlet output page
            out.println("<HTML>");
            out.println("<HEAD><TITLE>MyServlet_html</TITLE></HEAD>");
            out.println("<BODY>");
            out.println("<h1>MyServlet_html is Invoked...</h1>");
            out.println("<h2>Hello " + name + "... Welcome to Servlet</h2>");
            out.println("<h3>Calculation Result</h3>");
            out.println("<h3>Addition : " + add + "<br>Subtraction : " + sub +
                        "<br>Multiplication : " + mul + "<br>Division : " + div + "</h3>");
            out.println("<h3>Number of times the servlet invoked... " + count + "</h3>");
            out.println("</BODY></HTML>");
        } catch (Exception e) {
            // Handling error case for invalid inputs
            out.println("<HTML>");
            out.println("<HEAD><TITLE>MyServlet_html</TITLE></HEAD>");
            out.println("<BODY>");
            out.println("<h1>MyServlet_html is Invoked...</h1>");
            out.println("<h2>Invalid inputs !</h2>");
            out.println("</BODY></HTML>");
            e.printStackTrace();
        }
    }
}
