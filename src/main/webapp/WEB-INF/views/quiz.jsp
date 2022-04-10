<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<%@include file="dynamic/head.jspf" %>

<body>
<!-- Responsive navbar-->
<%@include file="dynamic/navbar.jspf" %>
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
                <form method="post" action='<c:url value="/result"/>'>

                    <div class="row">
                        <div class="col-4">
                            <div class="card bg-primary text-white shadow">
                                <div class="card-body">
                                    ${player.name} ${player.lastName}
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="card bg-primary text-white shadow">
                                <div class="card-body">
                                    ${technology}
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="card bg-primary text-white shadow">
                                <div class="card-body">
                                    ${difficulty}
                                </div>
                            </div>
                        </div>
                    </div>


                    <c:forEach items="${map}" var="quiz">
                        <fieldset class="form-group">
                            <legend class="mt-4">${quiz.value.question}</legend>
                            <c:if test="${quiz.value.answer_a != null}">
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <input type="radio" class="form-check-input" required="required"
                                               name="${quiz.key}"
                                               id="optionsRadios1"
                                               value="${quiz.value.answer_a}"
                                               data-com.bitwarden.browser.user-edited="yes">
                                            ${quiz.value.answer_a}
                                    </label>
                                </div>
                            </c:if>
                            <c:if test="${quiz.value.answer_b != null}">
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <input type="radio" class="form-check-input" required="required"
                                               name="${quiz.key}"
                                               id="optionsRadios2"
                                               value="${quiz.value.answer_b}"
                                               data-com.bitwarden.browser.user-edited="yes">
                                            ${quiz.value.answer_b}
                                    </label>
                                </div>
                            </c:if>

                            <c:if test="${quiz.value.answer_c != null}">
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <input type="radio" class="form-check-input" required="required"
                                               name="${quiz.key}"
                                               id="optionsRadios2"
                                               value="${quiz.value.answer_c}"
                                               data-com.bitwarden.browser.user-edited="yes">
                                            ${quiz.value.answer_c}
                                    </label>
                                </div>
                            </c:if>

                            <c:if test="${quiz.value.answer_d != null}">
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <input type="radio" class="form-check-input" required="required"
                                               name="${quiz.key}"
                                               id="optionsRadios2"
                                               value="${quiz.value.answer_d}"
                                               data-com.bitwarden.browser.user-edited="yes">
                                            ${quiz.value.answer_d}
                                    </label>
                                </div>
                            </c:if>

                            <c:if test="${quiz.value.answer_e != null}">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="radio" class="form-check-input" required="required"
                                           name="${quiz.key}"
                                           id="optionsRadios2"
                                           value="${quiz.value.answer_e}" data-com.bitwarden.browser.user-edited="yes">
                                        ${quiz.value.answer_e}
                                </label>
                            </div>
                            </c:if>

                            <c:if test="${quiz.value.answer_f != null}">
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <input type="radio" class="form-check-input" required="required"
                                               name="${quiz.key}"
                                               id="optionsRadios2"
                                               value="${quiz.value.answer_f}"
                                               data-com.bitwarden.browser.user-edited="yes">
                                            ${quiz.value.answer_f}
                                    </label>
                                </div>
                            </c:if>

                        </fieldset>
                    </c:forEach>

                    <button type="submit" class="btn btn-primary">Submit</button>
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
