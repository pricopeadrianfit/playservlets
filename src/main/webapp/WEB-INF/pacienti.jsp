<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

...
<table>
    <c:forEach items="${pacienti}" var="pacient">
        <tr>
            <td>${pacient.id}</td>
            <td><c:out value="${pacient.name}" /></td>
            <td><c:out value="${pacient.email}" /></td>
            <td><c:out value="${pacient.height}" /></td>
            <td><c:out value="${pacient.weight}" /></td>
            <td><c:out value="${pacient.index_bmi}" /></td>
        </tr>
    </c:forEach>
</table>