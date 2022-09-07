
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
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

<c:if test="${logoutMessage != null}">
    <div class="alert alert-success col-md-4 col-md-offset-4 m-3" >
        <c:out value="${logoutMessage}"></c:out>
    </div>


</c:if>

<h1 class="text-center text-primary">Welcome</h1>
<c:if test="${errorMessage != null}">
    <div class="alert alert-danger col-md-4 col-md-offset-4 m-3" >
        <c:out value="${errorMessage}" ></c:out>
    </div>

</c:if>

<form action="/login" method="POST">
    <section class="vh-100">
        <div class="container-fluid h-custom">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-9 col-lg-6 col-xl-5">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                         class="img-fluid" alt="Sample image">
                </div>
                <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">

                    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                        <p class="lead fw-normal mb-0 me-3">Sign in with</p>
                        <button type="button" class="btn btn-primary btn-floating mx-1">
                            <i class=" bi-facebook"></i>
                        </button>

                        <button type="button" class="btn btn-primary btn-floating mx-1">
                            <i class=" bi-twitter"></i>
                        </button>

                        <button type="button" class="btn btn-primary btn-floating mx-1">
                            <i class=" bi-linkedin"></i>
                        </button>
                    </div>

                    <div class="divider d-flex align-items-center my-4">
                        <p class="text-center fw-bold mx-3 mb-0">Or</p>
                    </div>


                    <div class="form-outline mb-4">
                        <input type="text" id="email" name="email" class="form-control form-control-lg"
                               placeholder="Email" />

                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <input type="password" id="password" name="password" class="form-control form-control-lg"
                               placeholder="Enter password" />
                        <%-- <label class="form-label" >Password</label>--%>
                    </div>

                    <div class="text-center text-lg-start mt-4 pt-2">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="submit" class="btn btn-primary btn-lg"
                               style="padding-left: 2.5rem; padding-right: 2.5rem;" value="Login">
                        <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="/registration/user"
                                                                                          class="link-danger">Register</a></p>
                    </div>


                </div>
            </div>
        </div>
        <div
                class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
            <!-- Copyright -->
            <div class="text-white mb-3 mb-md-0">
                Copyright © 2022. All rights reserved.
            </div>
            <!-- Copyright -->
        </div>
    </section>
</form>
</body>
</html>

