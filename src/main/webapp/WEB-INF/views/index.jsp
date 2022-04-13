<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="en">

<%@include file="dynamic/head.jspf"%>

<body>
<!-- Responsive navbar-->
<%@include file="dynamic/navbar.jspf"%>
<!-- Page content-->
<div class="container mt-5">
<div class="row">
<div class="col-lg-8">
<!-- Post content-->
<article>
<!-- Preview image figure-->
<figure class="mb-4"><img class="img-fluid rounded" src="<c:url value="/resources/assets/quiz.jpg"/>" alt="..."/>
</figure>
<!-- Post content-->
<section class="mb-5">


<table class="table table-hover">
<thead>
<tr>
    <th scope="col">Name</th>
    <th scope="col">Last Name</th>
    <th scope="col">Win ratio</th>
    <th scope="col">All answers</th>
    <th scope="col">Points</th>
</tr>
</thead>
<tbody>

<c:forEach items="${players}" var="players">

    <tr class="table-info">
    <td>${players.name}</td>
    <td>${players.lastName}</td>
    <td>${players.percentOfCorrectAnswers}%</td>
    <td>${players.allPlayerAnswers}</td>
    <td>${players.points}</td>
    </tr>
</c:forEach>
    </tbody>
    </table>


    </section>

    </article>
    <!-- Comments section-->

    </div>
    <!-- Side widgets-->
    <div class="col-lg-4">
    <!-- Categories widget-->
        <%@include file="dynamic/navigator.jspf"%>

    <!-- Footer-->
        <%@include file="dynamic/footer.jspf"%>
    </body>

    </html>
