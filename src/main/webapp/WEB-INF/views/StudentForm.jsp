<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student College Fest</title>
</head>
<body>
<div class="container">

		<h3>College Fest Students</h3>
		<hr>
		<p class="h4 mb-4">Student</p>
		<form action="/StudentManagementCRUD_MVC/students/save" method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Student.id}" />
			<div class="form-inline">
				<input type="text" name="name" value="${Student.name}"
					class="form-control mb-4 col-4" placeholder="Name">
			</div>

			<div class="form-inline">
				<input type="text" name="dept" value="${Student.department}"
					class="form-control mb-4 col-4" placeholder="Department">
			</div>

			<div class="form-inline">
				<input type="text" name="country" value="${Student.country}"
					class="form-control mb-4 col-4" placeholder="Country">
			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>

		<hr>
		<a href="/StudentManagementCRUD_MVC/students/list">Back to Student's List</a>

	</div>
</body>

</html>

