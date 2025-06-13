# EXNO: 2E  
## REQUEST LOCK USING JAVA SERVLET

### AIM
To lock the Servlet itself to a particular IP Address and port number and use an Init Parameter key to unlock itself and handle a request.

### PROCEDURE
1. Create an HTML form that invokes the servlet.
2. Create a `web.xml` file with `servlet-mapping` and `init-param` tags.
3. Create a Servlet using `PrintWriter` and `ServletConfig` objects.
4. Retrieve the key from the `init-param` tag in `web.xml` using the `ServletConfig` object.
5. Unlock the Servlet for valid key matches by comparing with a generated key based on host and port, and run the application on Apache Tomcat Server.

### RESULT
Thus, the servlet was successfully executed to lock and unlock the HTTP request based on the `init-param` tag of the `web.xml` file.
