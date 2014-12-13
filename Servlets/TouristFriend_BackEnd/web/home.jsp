<%-- 
    Document   : home
    Created on : 10-Dec-2014, 15:34:13
    Author     : Rownak
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<c:import url="header.jsp"></c:import>

<sql:setDataSource var="ds" dataSource="jdbc/touristfriend_db"/>
<sql:query dataSource="${ds}" sql="select * from photos where id_place = ?" var="results">
    <sql:param >${param.idPlace}</sql:param>
</sql:query>

<table class ="images">
    <c:set var="tablewidth" value="2"/>

    <c:forEach var="image" items="${results.rows}" varStatus="row">

        <c:if test="${row.index % tablewidth == 0}">
            <tr>
        </c:if>

        <c:set scope="page" var="imageUrl" value="${image.photo_url}"/>
        <td>
            
            <a href="<c:url value="WebViewOfImages?action=image&image=${image.id_photos}"/>">
                <img width="150" src="${pageContext.request.contextPath}/pictures/${imageUrl}"/>
            </a>
        </td>

        <c:if test="${row.index+1 % tablewidth == 0}">
            </tr>
        </c:if>

    </c:forEach>

</table>
<c:import url="footer.jsp"></c:import>