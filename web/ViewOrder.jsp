

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View order</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <%-- HEARDER --%>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="LoadProductController">Minh Duong Store</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">


                        <c:if test="${ssessionScope.TAI_KHOAN.nhomtk eq 'Admin'}">
                            <li class="nav-item">
                                <a class="nav-link" href="ManagerProduct">Manager Product</a>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.TAI_KHOAN != null}">
                            <li class="nav-item">
                                <a class="nav-link" href="LoadProduct">Hello ${TAI_KHOAN.tentk} </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="LogoutController">Logout</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.TAI_KHOAN == null}">
                            <li class="nav-item">
                                <a class="nav-link" href="Login.jsp">Login</a>
                            </li>
                        </c:if>    
                    </ul>
                </div>
            </div>
        </nav>
        <%-- END HEARDER --%>
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col" class="border-0 bg-light">
                            <div class="p-2 px-3 text-uppercase">Ma Hoa Don</div>
                        </th>
                        <th scope="col" class="border-0 bg-light">
                            <div class="py-2 text-uppercase">Ten Khach Hang</div>
                        </th>
                        <th scope="col" class="border-0 bg-light">
                            <div class="py-2 text-uppercase">Ngày mua</div>
                        </th> 
                        <th scope="col" class="border-0 bg-light">
                            <div class="py-2 text-uppercase">Action</div>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${sessionScope.HOA_DON}" var="c">                    
                        <tr>
                            <td class="align-middle">              
                                ${c.mahd}
                                <input type="hidden" name="txtMaHD" value="${c.mahd}" >
                            </td>
                            <td class="align-middle">
                                ${c.makh}
                                <input type="hidden" name="txtname" value="${c.makh}">
                            </td>
                            <td class="align-middle">
                                ${c.ngayhd}
                                <input type="hidden" name="txtDate" value="${c.ngayhd}" readonly>
                            </td>
                            <td class="align-middle">
                                <a href="ViewOrderDetailController?hoaDon=${c.mahd}" class="btn btn-dark rounded-pill py-2 btn-block">View order detail</a>
                            </td>
                        </tr> 

                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- End -->
    </body>
</html>
