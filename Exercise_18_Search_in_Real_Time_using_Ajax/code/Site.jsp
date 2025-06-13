<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Technical Sites</title>
</head>
<body>
<div align="center">
<h3>
<img src="Images/explore.png" align="middle">
Search for <span style="color: green;">Technical</span>
<span style="color: orange;">WebSite</span>
</h3>
<table width="100%">
<tr>
<td align="center">
<input id="term" type="text" name="searchterm" style="font-size:large;width: 50%;"
onkeypress="searchresults()">
</td>
</tr>
<tr>
<td style="padding-left: 25%;">
<div id="results" style="font-size:larger;"></div>
</td>
</tr>
</table>
</div>
<script type="text/javascript">
function searchresults() {
    var key = document.getElementById("term").value;
    if (typeof XMLHttpRequest != "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (xmlHttp == null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    if (key == "")
        document.getElementById("results").innerHTML = "";
    else {
        var url = "Search.jsp";
        url += "?searchterm=" + key;
        xmlHttp.onreadystatechange = stateChange;
        xmlHttp.open("GET", url, true);
        xmlHttp.send(null);
    }
}
function stateChange() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
        document.getElementById("results").innerHTML = "<h3>Search Results</h3><p></p>" + xmlHttp.responseText;
    }
}
</script>
</body>
</html>
