# EXNO: 3B (ii) - Instant Login Feedback and Auto Complete using AJAX

## AIM
To implement instant login feedback and answer with auto complete using AJAX.

## PROCEDURE
1. Design a form to get user details and location using JSP.
2. Create an AJAX object using the `XMLHttpRequest` method and bind it to form field events inside the JSP.
3. Create a database and corresponding table to store user information.
4. When the user finishes entering their username, invoke the AJAX object to call a JSP page (`Check.jsp`) to validate username availability.
5. Verify the entered username against the database and provide instant feedback.
6. Define an XML Schema (XSD) and generate an XML file containing a list of city names.
7. When the user starts entering a city name, call a JSP page (`Extract.jsp`) using AJAX to fetch relevant city suggestions.
8. Match the typed city prefix with XML entries and return a filtered list of matching cities.
9. Display the suggestions dynamically below the city field using `responseText` from the AJAX response.
10. Once the form is completed, save the details to the database through a backend JSP file (`Save.jsp`).
11. Display appropriate feedback using `Success.jsp` or `Exception.jsp`.
12. Deploy and run the application using a web server like Apache Tomcat.

## RESULT
Thus, the implementation of instant login feedback and auto complete using AJAX was successfully developed and verified.

## TECHNOLOGY USED
- **Front-End:** HTML, CSS, JavaScript
- **Back-End:** JSP, AJAX
- **Database:** MS Access (via UCanAccess JDBC driver)
- **Data Markup:** XML, XSD
- **Web Server:** Apache Tomcat
