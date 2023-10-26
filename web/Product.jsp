

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: auto;
                display: inline-block;
                cursor: zoom-in;
            }


            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }
            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }
            .img-big-wrap img{
                width: 100% !important;
                height: auto !important;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="LoadProductController">Moon Cakes Store</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">


                        <c:if test="${ssessionScope.TAI_KHOAN.nhomtk eq 'Admin' }">
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
                    <%-- Search product by name --%>
                    <form action="SearchController" method="get" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txtSearch" type="text" value="${param.txtSearch}" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number" >
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="CartController">
                            <i class="fa fa-shopping-cart"></i> Car
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <%-- END HEARDER --%>

        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">MINH DUONG STORE CHUYEN BAN DO THE THAO</h1>
                <p class="lead text-muted mb-0" > - Kính chào Quý Khách hàng! -</p>
            </div>
        </section>


        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Danh Muc</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${LIST_DANHMUC}" var="o">
                                <li style="background-color: #ccc" class="list-group-item text-white ${tendm == o.tendm ? "active" :""}">
                                    <a style="text-decoration: none;" href="LoadProductController?action=DanhMuc&MaDanhMuc=${o.madm}">${o.tendm}</a>
                                </li>
                            </c:forEach>
                            <li style="background-color: #ccc" class="list-group-item text-white ${tendm == o.tendm ? "active" :""}">
                                <a style="text-decoration: none;" href="LoadProductController">All</a>
                            </li>
                        </ul>
                    </div>
                    <%--Sort product--%>     
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Nha cung cap</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${LIST_NHACUNGCAP}" var="o">
                                <li style="background-color: #ccc" class="list-group-item text-white ${tenncc == o.tenncc ? "active" :""}">
                                    <a style="text-decoration: none;" href="LoadProductController?action=NhaCungCap&MaNCC=${o.mancc}">${o.tenncc}</a>
                                </li>
                            </c:forEach>
                            <li style="background-color: #ccc" class="list-group-item text-white ${tenncc == o.tenncc ? "active" :""}">
                                <a style="text-decoration: none;" href="LoadProductController">All</a>
                            </li>
                        </ul>
                    </div>    
                </div>

                <div class="col-sm-9">
                    <div class="container">
                        <div class="card">
                            <div class="row">
                                <aside class="col-sm-5 border-right">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="${SANPHAM.hinhAnh}"></a></div>
                                        </div> <!-- slider-product.// -->
                                    </article> <!-- gallery-wrap .end// -->
                                </aside>
                                <aside class="col-sm-7">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${SANPHAM.tensp}</h3>

                                        <p class="price-detail-wrap"> 
                                            <span class="price h3 text-warning"> 
                                                <span class="currency"></span><span class="num">${SANPHAM.donGia} VNĐ</span>
                                            </span> 
                                            <!--<span>/per kg</span>--> 
                                        </p> <!-- price-detail-wrap .// -->
                                        <dl class="item-property">
                                            <dt>Mô tả</dt>
                                            <dd><p>${SANPHAM.moTa} </p></dd>
                                        </dl>
                                        <dl class="item-property">
                                            <dt>Số lượng</dt>
                                            <dd><p>${SANPHAM.soLuong} </p></dd>
                                        </dl>
                                        <hr>
                                        <c:if test="${sessionScope.SANPHAM.trangThai == True}">
                                            <dl class="item-property">
                                                <dt>Tình trạng</dt>
                                                <dd><p>Còn hàng </p></dd>
                                            </dl>
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
                                        </c:if>

                                    </article> <!-- card-body.// -->
                                </aside> <!-- col.// -->
                            </div> <!-- row.// -->
                        </div> <!-- card.// -->
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
