<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>
            <p class="lead">Detailed Information</p>
        </div>

        <div class="container" ng-app="cartApp">
                <div class="row">
                        <div class="col-md-5">
                            <img src="<c:url value="/resources/images/${product.productId}.png" />" alt="image"
                                     style="width:100%"/>
                        </div>
                            <div class="col-md-5">
                                <h2>${product.productName} </h2>
                                <h3>
                                    <bold>Description</bold>: ${product.productDescription}
                                </h3>
                                <h3>
                                    <bold>Manufacturer</bold>: ${product.productManufacturer}
                                </h3>
                                <h3>
                                    <bold>Category</bold>: ${product.productCategory}
                                </h3>
                                <h3>
                                    <bold>Condition</bold>: ${product.productCondition}
                                </h3>
                                <h3>
                                    <bold>Price</bold>: ${product.productPrice} USD
                                </h3>

                                <br>

                                <c:set var="role" scope="page" value="${param.role}" />
                                <c:set var="url"scope="page" value="/productList" />
                                <c:if test="${role='admin'}">
                                    <c:set var="url" scope="page" value="/admin/productInventory" />
                                </c:if>

                                <p ng-controller="cartCtrl">
                                    <a href="<c:url value="${url}" />" class="btn btn-default">Back</a>
                                    <a href="#" class="btn btn-warning btn-large"
                                       ng-click="addToCart('${product.productId}')"><span class="glyphicon glypicon-shopping-cart"></span>Order Now</a>
                                    <a href="<spring:url value="/cart" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
                                </p>




                            </div>
                    </div>
                </div>
        </div>

        <script src="<c:url value="/resources/js/controller.js" /> "></script>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>




