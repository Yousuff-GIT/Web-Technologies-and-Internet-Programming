# Exercise 2C (i) – Invoking Servlet from HTML Form

## Aim
To develop and execute a Java Servlet that performs arithmetic operations by receiving input from an HTML form.

## Procedure
1. Create an HTML form using the `<form>` tag with method `POST` and action pointing to the servlet name.
2. Design form fields to accept user inputs (name, number1, number2).
3. Develop a servlet class by extending `HttpServlet` and overriding the `doPost()` method.
4. Inside the servlet, read the input parameters using `HttpServletRequest`.
5. Perform arithmetic operations and generate HTML output using `PrintWriter`.
6. Configure the servlet and URL mapping in `web.xml`.
7. Deploy on Apache Tomcat and run the HTML file.

## Output
- **Input Form Screenshot** – user submits name and two numbers.
- **Servlet Response Screenshot** – result of calculations is shown.

## Result
Thus, the servlet was successfully invoked from the HTML form and arithmetic results were computed and displayed.

