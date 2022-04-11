<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<%@include file="dynamic/head.jspf" %>
</head>

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

                <form method="post" action='<c:url value="/quiz"/>'>

                <section class="mb-5">

                    <div class="form-group">
                        <label class="form-label mt-4">Player</label>
                        <select class="form-select" id="player" name="playerId">
                            <c:forEach items="${players}" var="players">
                                <option value="${players.id}">${players.name} ${players.lastName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label  class="form-label mt-4">Technology</label>
                        <select class="form-select" name="technology">
                                <option value="sql">SQL</option>
                                <option value="docker">Docker</option>
                                <option value="linux">Linux</option>
                                <option value="bash">Bash</option>
                                <option value="devops">DevOps</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label class="form-label mt-4">Difficulty</label>
                        <select class="form-select" name="difficulty">
                            <option value="Easy">easy</option>
                            <option value="Medium">medium</option>
                            <option value="Hard">hard</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label class="form-label mt-4">Number of questions</label>
                        <select class="form-select" name="numberOfQuestions">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                        </select>
                    </div>
                </section>

                <button type="submit" class="btn btn-primary">Play</button>
                </form>
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
