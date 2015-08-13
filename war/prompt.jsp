
<%= request.getAttribute("doctype") %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p></p>
        <form action="messaginggae" method="GET">
            <label for="letter">Type a valid phone number you want to send text to</label>
            <input type="text" name="phoneNum" value="" /><br>
             <label for="letter">Type in the message you want to send</label>
             <input type="text" name="message" value="" /><br>
            <input type="submit" value="Click Here" />
        </form>
    </body>
</html>

