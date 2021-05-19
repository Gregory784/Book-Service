
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add book</title>
</head>
<body>
    <form:form method="post" modelAttribute="book">
        <form:hidden path="id"/>
        <div>
            <label for="isbn">ISBN</label>
            <form:input id="isbn" path="isbn"/>
            <form:errors path="isbn"/>
        </div>
        <div>
            <label for="title">Title</label>
            <form:input id="title" path="title"/>
            <form:errors path="title"/>
        </div>
        <div>
            <label for="author">Author</label>
            <form:input id="author" path="author"/>
            <form:errors path="author"/>
        </div>
        <div>
            <label for="publisher">Publisher</label>
            <form:input id="publisher" path="publisher"/>
            <form:errors path="publisher"/>
        </div>
        <div>
            <label for="type">Type</label>
            <form:input id="type" path="type" type="type"/>
            <form:errors path="type"/>
        </div>
        <div>
            <form:errors path="*" element="div" cssClass="error"/>
        </div>
        <div>
            <input type="submit">
        </div>
    </form:form>
    <a href="/admin/books/all"> Go to books list </a>
</body>
</html>
