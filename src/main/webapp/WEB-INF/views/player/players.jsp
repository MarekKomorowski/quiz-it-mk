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
                <section class="mb-5">


                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Last Name</th>
                            <th scope="col">Options</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${players}" var="player">

                            <tr class="table-info">
                                <td>${player.name}</td>
                                <td>${player.lastName}</td>
                                <td>
                                    <a href="<c:url value="/editPlayer/${player.id}"/>">
                                        <button type="button" class="btn btn-primary btn-sm">edit</button>
                                    </a>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                        Delete
                                    </button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Danger</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    Are you sure?
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                    <a href="<c:url value="/deletePlayer/${player.id}"/>">
                                                    <button type="button" class="btn btn-danger">Delete</button>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
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
            <%@include file="../dynamic/navigator.jspf" %>

            <!-- Footer-->
            <%@include file="../dynamic/footer.jspf" %>
</body>

</html>
