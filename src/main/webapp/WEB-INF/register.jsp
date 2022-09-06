<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" href="/css/style.css"/>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
    <!-- Bootstrap Font Icon CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

</head>
<body>
<div>

    <p><form:errors path="user.*"/></p>
    <%--@elvariable id="user" type="java"--%>
    <section class="vh-100 bg-image"
             style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
        <div class="mask d-flex align-items-center h-100 gradient-custom-3">
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                        <div class="card" style="border-radius: 15px;">
                            <div class="card-body p-5">
                                <h2 class="text-uppercase text-center mb-5">Create an account</h2>

                                <form:form method="post"  action="/registration/user"  modelAttribute="user">

                                    <div class="form-outline mb-4">
                                        <form:input  id="form3Example1cg" class="form-control form-control-lg"  path="firstName" placeholder="First Name"/>

                                    </div>

                                    <div class="form-outline mb-4">
                                        <form:input  id="form3Example1cg" class="form-control form-control-lg"  path="lastName" placeholder="Last Name"/>

                                    </div>

                                    <div class="form-outline mb-4">
                                        <form:input type="email" path="email" id="form3Example3cg" class="form-control form-control-lg" placeholder="Email"/>

                                    </div>

                                    <div class="form-outline mb-4">
                                        <form:password path="password" id="form3Example4cg" class="form-control form-control-lg" placeholder="Password"/>

                                    </div>

                                    <div class="form-outline mb-4">
                                        <form:password path="passwordConfirmation" class="form-control  form-control-lg" placeholder="Confirm password"/>

                                    </div>



                                    <div class="d-flex justify-content-center">
                                        <input type="submit"  class="btn btn-success btn-block btn-lg gradient-custom-4 text-body" value="Register">
                                    </div>

                                    <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="/login"
                                                                                                            class="fw-bold text-body"><u>Login here</u></a></p>

                                </form:form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


</div>

</body>
</html>
