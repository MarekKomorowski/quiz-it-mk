<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<%@include file="dynamic/head.jspf" %>

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
                <form method="post" action='<c:url value="/result"/>'>

                    <c:forEach items="${quiz}" var="map">
                        <fieldset class="form-group">
                            <legend class="mt-4">${map.value.question}</legend>
                            <c:if test="${map.value.answer_a != null}">
                                <div class="form-check">
                                    <c:if test="${!map.value.correctAnswer.equals(map.value.playerAnswer)}">
                                        <div class="col-4">
                                            <div class="card bg-danger text-white shadow">
                                                <div class="card-body">
                                                        ${map.value.playerAnswer}
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-4">
                                            <div class="card bg-primary text-white shadow">
                                                <div class="card-body">
                                                    Correct: ${map.value.correctAnswer}
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>

                                    <c:if test="${map.value.playerAnswer.equals(map.value.correctAnswer)}">
                                        <div class="col-4">
                                            <div class="card bg-success text-white shadow">
                                                <div class="card-body">
                                                        ${map.value.playerAnswer}
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                    </label>
                                </div>
                            </c:if>

                        </fieldset>
                    </c:forEach>

                </form>
                </section>
            </article>
            <!-- Comments section-->

        </div>
        <!-- Side widgets-->
        <div class="col-lg-4">
            <!-- Categories widget-->
            <%@include file="dynamic/navigator.jspf" %>

            <!-- Footer-->
            <%@include file="dynamic/footer.jspf" %>


</body>
</html>
