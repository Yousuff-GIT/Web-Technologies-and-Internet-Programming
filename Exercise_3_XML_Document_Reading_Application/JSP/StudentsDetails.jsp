<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--
  This JSP file renders a form to accept a student's Roll Number from the user.
  The form data will be sent to StudentProfile.jsp for further processing.
-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Roll Number</title>
</head>
<body>
    <div align="center">
        <form action="StudentProfile.jsp" method="post">
            <table>
                <tr>
                    <td bgcolor="#00CDFF"><label>Student Roll Number</label></td>
                    <td bgcolor="#00CDFF"><input type="text" name="rollnumber"></td>
                </tr>
            </table>
            <br/>
            <input type="submit" value="Get Profile" />
        </form>
    </div>
</body>
</html>
