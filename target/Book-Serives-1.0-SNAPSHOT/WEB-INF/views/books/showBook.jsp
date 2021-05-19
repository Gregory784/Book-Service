<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Details</title>
</head>
<body>

<table border="1" style="background-color: yellow">

    <thead>
            <tr>
               <th>isbn</th><th>title</th><th>author</th><th>publisher</th><th>type</th>
            </tr>
    </thead>

    <tbody>
        <tr>
              <td>${book.isbn}</td><td>${book.title}</td><td>${book.author}</td><td>${book.publisher}</td><td>${book.type}</td>
        </tr>
    </tbody>
</table>
<h3>
    <a href="/admin/books/all"> Go to books list </a>
</h3>
</body>
</html>
