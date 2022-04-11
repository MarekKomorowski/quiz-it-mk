<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="en">

<%@include file="../dynamic/head.jspf" %>

<body>
<!-- Responsive navbar-->
<%@include file="../dynamic/navbar.jspf" %>
<!-- Page content-->
<div class="container mt-5">
    <div class="row">
        <div class="col-lg-8">
            <!-- Post content-->
            <article>
                <!-- Preview image figure-->
                <figure class="mb-4"><img class="img-fluid rounded" src="<c:url value="/resources/assets/quiz.jpg"/>"
                                          alt="..."/>
                </figure>
                <!-- Post content-->
                <form method="post" action='<c:url value="/editPlayer/${player.id}"/>'>

                    <section class="mb-5">

                        <div class="form-group">
                            <label class="col-form-label mt-4" for="inputDefault1">name</label>
                            <input type="text" class="form-control" placeholder="${player.name}" id="inputDefault1" name="name" required="required" pattern="[A-Za-z0-9]{1,20}">
                        </div>

                        <div class="form-group">
                            <label class="col-form-label mt-4" for="inputDefault2">last name</label>
                            <input type="text" class="form-control" placeholder="${player.lastName}" id="inputDefault2" name="lastName" required="required" pattern="[A-Za-z0-9]{1,20}">
                        </div>
                    </section>
                    <button type="submit" class="btn btn-primary">save changes</button>

                </form>
            </article>
            <!-- Comments section-->

        </div>
        <!-- Side widgets-->
        <div class="col-lg-4">
            <!-- Categories widget-->
            <%@include file="../dynamic/navigator.jspf" %>

            <!-- Footer-->
            <%@include file="../dynamic/footer.jspf" %>
</body>

</html>
