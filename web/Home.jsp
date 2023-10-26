

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
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


                        <c:if test="${sessionScope.TAI_KHOAN.nhomtk eq 'Admin'  }">
                            <li class="nav-item">
                                <a class="nav-link" href="ManageController">Manager Product</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="ViewOrderAdminController">Xem đơn hàng</a>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.TAI_KHOAN.nhomtk eq 'User'}">
                            <li class="nav-item">
                                <a class="nav-link" href="ViewOrderController">Xem đơn hàng</a>
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
                    <%-- Search product by name --%>
                    <form action="LoadProductController" method="get" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txtSearch" type="text" value="${param.txtSearch}" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number" name="action" value="search" >
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="CarrController">
                            <i class="fa fa-shopping-cart"></i> Cart
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <%-- END HEARDER --%>

        <%-- BODY --%>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">MINH DUONG STORE CHUYEN BAN DO THE THAO</h1>
                <p class="lead text-muted mb-0" > - Kính chào Quý Khách hàng! -</p>
            </div>
        </section>

        <%-- Caterogy--%>
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Danh Muc</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${LIST_DANHMUC}" var="o">
                                <li style="background-color: #ccc" class="list-group-item text-white ${TEN_DANHMUC == o.tendm ? "active" :""}">
                                    <a style="text-decoration: none;" href="LoadProductController?action=DanhMuc&MaDanhMuc=${o.madm}">${o.tendm}</a>
                                </li>
                            </c:forEach>
                            <li style="background-color: #ccc" class="list-group-item text-white ${TEN_DANHMUC == o.tendm ? "active" :""}">
                                <a style="text-decoration: none;" href="LoadProductController">All</a>
                            </li>
                        </ul>
                    </div>
                    <%--Sort product--%>     
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Nha cung cap</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${LIST_NHACUNGCAP}" var="o">
                                <li style="background-color: #ccc" class="list-group-item text-white ${TEN_NCC == o.tenncc ? "active" :""}">
                                    <a style="text-decoration: none;" href="LoadProductController?action=NhaCungCap&MaNCC=${o.mancc}">${o.tenncc}</a>
                                </li>
                            </c:forEach>
                            <li style="background-color: #ccc" class="list-group-item text-white ${TEN_NCC == o.tenncc ? "active" :""}">
                                <a style="text-decoration: none;" href="LoadProductController">All</a>
                            </li>
                        </ul>
                    </div>    
                </div>

                <%--Lóad product--%>        
                <div class="col-sm-9">
                    <div class="row">


                        <c:forEach items="${LIST_SANPHAM}" var="c">

                            <input type="hidden" name="productID" value="${c.masp}" />
                            <input type="hidden" name="nameProduct" value="${c.tensp}" />
                            <input type="hidden" name="price" value="${c.donGia}" />
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${c.hinhAnh}" alt="Card image cap">
                                    <div class="card-body">
                                        <h6 class="card-title show_txt" 
                                            style=" text-align:center"> 
                                            <a href="ProductController?masp=${c.masp}" title="View Product">
                                                ${c.tensp}
                                            </a>
                                        </h6>
                                        <p style=" text-align:center">${c.donGia} VNĐ</p>
                                        <div class="row">
                                            <c:if test="${sessionScope.LIST_PRODUCT.trangThai == True}">                                              
                                                <div class="col">
                                                    <c:url var="urlRewriting" value="AddToCartCon">
                                                        <c:param name="maSP" value="${c.masp}"/>
                                                        <c:param name="tenSP" value="${c.tensp}"/>
                                                        <c:param name="HinhAnh" value="${c.hinhAnh}"/>
                                                        <c:param name="donGia" value="${c.donGia}"/>
                                                    </c:url>
                                                    <c:if test="${sessionScope.TAI_KHOAN == null}">
                                                        <a class="btn btn-success btn-block" href="Login.jsp">Add to cart</a>
                                                    </c:if>  

                                                    <c:if test="${sessionScope.TAI_KHOAN != null}">
                                                        <a href="${urlRewriting}" class="btn btn-success btn-block">Add to cart</a>
                                                    </c:if>  

                                                </div>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <%-- END BODY --%>
    </body>
</html>
