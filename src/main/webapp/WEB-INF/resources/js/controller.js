/**
 * Created by Marissa on 7/8/17.
 */

var cartApp= angular.module("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http) {

    $scope.refreshCart = function(cartId) {
        $http.get(' / musicShoppe2/rest/cart/' +$scope.cartId).success(function (data) {
            $scope.cart=data;

        });
    };

    $scope.clearCart = function() {
        $http.delete(' /musicShoppe2/rest/cart' +$scope.cartId).success($scope.refreshCart($scope.refreshCart($scope.cartId));
    };


    $scope.initCardId = function (cartId) {
        $scope.cartId=cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productId) {
        $http.put('musicShoppe2/rest/cart/add' +productId).success(function (data) {
            $scope.refreshCart($http.get(' /musicShoppe2/rest/cart/cartId'));
            alert("Product successfully added to the cart.")
        });
    };

    $scope.removeFromCart = function(productId) {
        $http.put('/eMusicStore/rest/cart/remove' +productId).success(function (data) {
            $scope.refreshCart($http.get(' /musicShoppe2/rest/cart/cartId'));
        });
    };


});
