<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
    <title>WebCar</title>
  </head>
  <body>
  <jsp:include page="fragments/navbar.jspf" />
  <form action="car" method="post">
  <c:if test="${not empty requestScope.advertisements}">
  <c:forEach var="advertisement" items="${requestScope.advertisements}">
    <div class="container">
      <div class="row bs-callout bs-callout-primary">
        <div class="col-sm-10">
          <h3 class="centered"><a href="<c:out value="${pageContext.request.contextPath}/car?advertisementId=${advertisement.id}" />"><c:out value="${advertisement.title}" /></a></h3>
          <h6><small>Dodane przez: <c:out value="${advertisement.user.username}" />,
            Dnia: <fmt:formatDate value="${advertisement.timestamp}" pattern="dd/mm/YYYY"/>
            </small></h6>


            <a href="<c:out value="${pageContext.request.contextPath}/car?advertisementId=${advertisement.id}" />"class="btn btn-default btn-xs">Przejdź do ogłoszenia</a>
        </div>
      </div>
    </div>
  </c:forEach>
  </c:if>
  </form>
  <jsp:include page="fragments/footer.jspf" />
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
  <script src="resources/js/bootstrap.js"></script>
  </body>
</html>
