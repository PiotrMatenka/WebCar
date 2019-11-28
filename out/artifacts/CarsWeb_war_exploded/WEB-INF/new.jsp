<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>WebCar - dodaj ogłoszenie</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="fragments/navbar.jspf" />

<div class="container">
    <div class="col-md-9 col-md-offset-2">
        <form class="form-signin" method="post" action="add">
            <h2 class="form-signin-heading">Dodaj nowe ogłoszenie</h2>
            <br>
            <input name="inputTitle" type="text" class="form-control" placeholder="Tytuł: "
                   required autofocus />
            <br>
            <div class="row">
                <div class="col-sm"><input name = "inputCarProducent" class="form-control" type="text" placeholder="Producent "></div>
                <div class="col-sm"><input name = "inputCarModel" class="form-control" type="text" placeholder="Model "></div>
                <div class="col-sm"><input name = "inputYear" class="form-control" type="text" placeholder="Rocznik"></div>
                <div class="col-sm"><input name = "inputPrice" class="form-control" type="text" placeholder="Cena"></div>
            </div>
            <br>
            <div class="row">
                <div class="col-form-label">
                    <label for="carType">Typ pojazdu</label>
                    <select id="carType" name="inputCarType">
                        <option>sedan</option>
                        <option>hatchback</option>
                        <option>limuzyna</option>
                        <option>van</option>
                        <option>minivan</option>
                        <option>coupe</option>
                        <option>pick-up</option>
                        <option>kabriolet</option>
                        <option>suv</option>
                        <option>combii</option>
                    </select>
                </div>
                <div class="col-form-label">
                    <label for="fuelType">Typ paliwa</label>
                    <select id="fuelType" name="inputFuelType">
                        <option>benzyna</option>
                        <option>gaz</option>
                        <option>gaz+benzyna</option>
                        <option>diesel</option>
                        <option>elektryczny</option>
                        <option>elektryczny+benzyna</option>
                    </select>
                </div>
                <div class="col-sm"><input name = "inputCapacity" class="form-control" type="text" placeholder="Pojemność silnika "></div>
            </div>
            <textarea name="inputDescription" rows="5" class="form-control" placeholder="Opis ogłoszenia" required autofocus></textarea>
            <input class="btn btn-lg btn-primary btn-block" type="submit"
                   value="Dodaj!" />
        </form>
    </div>
</div>

<jsp:include page="fragments/footer.jspf" />
</body>
</html>
