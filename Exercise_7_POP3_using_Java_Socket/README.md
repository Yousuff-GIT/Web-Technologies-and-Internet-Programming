# Exercise 2A (iv) – POP3 Using Java Socket

## Aim
To demonstrate how the Post Office Protocol version 3 (POP3) is implemented using Java Socket programming.

## Procedure
1. Develop a Java class to initiate a socket connection to a POP3 server (e.g., hMailServer) on port 110.
2. Use an OutputStream to send POP3 commands such as USER, PASS, STAT, RETR, and QUIT.
3. Use an InputStream to capture and display the server's responses.
4. Execute the program and observe the POP3 session sequence in the console output.

## Output
```
+OK Send your password
+OK Mailbox locked and ready
+OK 2 480
+OK 240 octets
Return-Path: admin@cahcetlab.edu.in
Received: from Yousuff (Yousuff [127.0.0.1])
by YOUSUFF with ESMTP
; Fri, 21 Aug 2015 09:34:19 -0700
Message-ID: <06CB29C9-0A72-4AA4-9E68-F3D379509326@YOUSUFF>
SUBJECT: Demonstration of SMTP
Happy SMTP Programming with hmail server
.
+OK POP3 server saying goodbye...
```

## Result
Thus, the Post Office Protocol (POP3) was successfully demonstrated using Java Socket programming.
