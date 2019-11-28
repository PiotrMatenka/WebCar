<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
    <title>Ogłoszenie</title>
</head>
<body>
<jsp:include page="fragments/navbar.jspf"/>
<br>
<br>
<div class="container">
    <div class="col-md-9 col-md-offset-2">
        <div class="row">
           <div class="col-sm-2"> <h8>Dodał: <c:out value="${advertisement.user.username}"/></h8></div>
            <div class="col-sm-5"><h8>Dnia:<fmt:formatDate value="${advertisement.timestamp}" pattern="dd/mm/YYYY"/></h8></div>
            <div class="col-sm-2"> <h8>Miasto: <c:out value="${advertisement.user.city}"/></h8></div>
        </div>
        <br>
        <br>
        <div class="row">
            <div class="col-sm-6"><h4><c:out value="${advertisement.title}"/> </h4></div>
            <div class="col-sm-3"><h4>Cena: <c:out value="${advertisement.price}"/> Pln </h4></div>
        </div>
        <br>
        <br>
        <div class="row">
            <div class="col-sm-3"><h5>Producent: <c:out value="${advertisement.carProducent}"></c:out> </h5></div>
            <div class="col-sm-3"><h5>Model: <c:out value="${advertisement.carModel}"/> </h5></div>
            <div class="col-sm-4"><h5>Rok produkcji: <c:out value="${advertisement.yearOfProduction}"/> </h5></div>
        </div>
        <br>
        <br>
        <div class="row">
            <div class="col-sm-4"><h5>Typ nadwozia: <c:out value="${advertisement.carType}"></c:out> </h5></div>
            <div class="col-sm-5"><h5>Rodzaj paliwa:  <c:out value="${advertisement.fuelType}"/> </h5></div>
            <div class="col-sm-4"><h5>Pojemność silnika: <c:out value="${advertisement.engineCapacity}"/> </h5></div>
        </div>
        <br>
        <br>
        <div class="d-lg-table-row">
            <h6>Opis:</h6>
            <br>
            <h6><c:out value="${advertisement.description}"/> </h6>
        </div>
    </div>
</div>
<br>
<br>

<jsp:include page="fragments/footer.jspf" />
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>
