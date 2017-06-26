<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>
            <p class="lead">Detailed Information</p>
        </div>

        <div class="container">
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
                            </div>
                    </div>
                </div>
        </div>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>




