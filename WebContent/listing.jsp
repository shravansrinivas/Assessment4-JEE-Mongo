<%@page import="local.ad.adClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>
     
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
h3{
color:green;
background-color:yellow;}
.form-group{
text-align:center;}
</style>
    <title>Listing</title>
  </head>
  <body>
  <h1 style="text-align:center">Welcome to Ad-Space</h1><hr>
    <div class="container">
    <div class="row">
    <div class="col-md-6">
    <h3 style="text-align:center">Ads in ${sessionScope.category }</h3>
    <table class="table table-striped table-dark">
<thead>
<tr>
<td>Ad Title</td>
<td>City</td>
<td>Phone</td>
</tr>
</thead>
<tbody>
<f:forEach var="adClass" items="${list }">
<tr>
<td>${adClass.adName }</td>
<td>${adClass.city}</td>
<td>${adClass.contactNumber}</td>
<td><button type="submit" name="reply" value=${adClass.adName }><a href="reply.jsp">Reply</a></button></td>
</tr>
</f:forEach>
</tbody>
</table>
    
    
    </div>
    <div class="col-md-6">
    <h3 style="text-align:center">Have an ad to post? Post here!</h3>
    <form action="listing" method="post">
  <div class="form-group">
    <label for="adTitle">Ad Title</label>
    <input required type="text" class="form-control" id="adTitle" name="adTitle" placeholder="Enter ad title">
  </div>
  
  <div class="form-group">
    <label for="adDesc">Ad Description</label>
    <textarea required class="form-control" id="adDesc" name="adDesc" rows="3"></textarea>
  </div>
  <div class="form-group">
    <label for="contactNumber">Contact Number</label>
    <input type="tel" required class="form-control" id="contactNumber" name="contactNumber" placeholder="Contact Number">
  </div>
  <div class="form-group">
    <label for="email">Email address</label>
    <input type="email" required class="form-control" id="email" name="email" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="city">City</label>
    <input type="text" required class="form-control" id="city" name="city" placeholder="Enter City">
  </div>
  <div class="form-group">
    <label for="zip">ZIP Code</label>
    <input type="number" required max="999999" min="000000" class="form-control" id="zip" name="zip" placeholder="Enter ZIP">
  </div>
  
   
  
  <button type="submit" name="submitAd" class="btn btn-primary">Submit Ad</button>
 
 </form>
    </div>
    </div>
    
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>