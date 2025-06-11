# Exercise 2A (iii) – SMTP Using Java Socket

## Aim
To demonstrate how the Simple Mail Transfer Protocol (SMTP) works using Java Socket programming by interacting with a mail server (hMailServer).

## Procedure
1. Install and configure hMailServer on localhost with a valid domain and email accounts.
2. Develop a Java program to initiate a TCP connection with the SMTP server on port 25.
3. Use Java Sockets to establish input and output streams for client-server communication.
4. Send SMTP commands such as HELO, MAIL FROM, RCPT TO, and DATA through the OutputStream.
5. Read server responses from the InputStream to confirm successful execution of commands.
6. Properly terminate the session with the QUIT command and close the socket.
7. Run the program to observe SMTP request/response interactions on the console.

## Output
```
Host Name = Yousuff
220 YOUSUFF ESMTP
250 Hello.
250 OK
250 OK
354 OK, send.
250 Queued (0.031 seconds)
221 goodbye
Delivery Status : SUCCESS
```

## Result
Thus, the working of the Simple Mail Transfer Protocol (SMTP) was successfully demonstrated using Java Socket programming.
