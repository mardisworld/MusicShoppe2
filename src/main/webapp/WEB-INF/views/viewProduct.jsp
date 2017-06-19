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
                            <img src="#" alt="image" style="width: 100%; height: 300px" />
                        </div>
                            <div class="col-md-5">
                                <h3>${product.productName} </h3>
                                <h2>
                                    <em>Description</em>: ${product.productDescription}
                                </h2>
                                <h2>
                                    <em>Manufacturer</em>: ${product.productManufacturer}
                                </h2>
                                <h2>
                                    <em>Category</em>: ${product.productCategory}
                                </h2>
                                <h2>
                                    <em>Condition</em>: ${product.productCondition}
                                </h2>
                                <h2>
                                    <em>Price</em>: ${product.productPrice}
                                </h2>
                            </div>
                    </div>
                </div>
        </div>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>




