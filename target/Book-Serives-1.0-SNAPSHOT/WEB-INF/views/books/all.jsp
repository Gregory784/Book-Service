<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books List</title>
</head>
<body>

<h1>
    <button style="background-color: darkorange; text-decoration-color: blue; border-bottom-style: double; box-sizing: border-box"> <a href="/admin/books/add"> Add new book </a></button>
</h1>

<table border="1" style="background-color: aquamarine; font-style: italic" >
    <thead>
    <th>Title</th>
    <th>Author</th>
    <th>Actions</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.title}" />
            <td><c:out value="${book.author}" /></td>
            <td>
                <button type="button" style="background-color: burlywood;"><a href="/admin/books/show/${book.id}"> Details </a></button>
             <button style="background-color: yellow"> <a href="/admin/books/update/${book.id}"> Edit </a></button>
             <button style="background-color: orangered"> <a href="/admin/books/delete/${book.id}"> Delete </a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
