<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<head>
<meta charset="utf-8">
<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
<title>E-voting</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="resources/css/templatemo_main.css">
<!-- 
Dashboard Template 
http://www.templatemo.com/preview/templatemo_415_dashboard
-->
<script>
	function selectOnlyThis(id) {
		var myCheckbox = document.getElementsByName("guild");
		Array.prototype.forEach.call(myCheckbox, function(el) {
			el.checked = false;
		});
		id.checked = true;
	}
</script>
<script>
	function selectOnlyThis2(id) {
		var myCheckbox = document.getElementsByName("facultygrc");
		Array.prototype.forEach.call(myCheckbox, function(el) {
			el.checked = false;
		});
		id.checked = true;
	}
</script>
<script>
	function selectOnlyThis3(id) {
		var myCheckbox = document.getElementsByName("hallgrc");
		Array.prototype.forEach.call(myCheckbox, function(el) {
			el.checked = false;
		});
		id.checked = true;
	}
</script>

<script>
	function selectOnlyThis4(id) {
		var myCheckbox = document.getElementsByName("privategrc");
		Array.prototype.forEach.call(myCheckbox, function(el) {
			el.checked = false;
		});
		id.checked = true;
	}
</script>
<script>
	function selectOnlyThis5(id) {
		var myCheckbox = document.getElementsByName("governmentgrc");
		Array.prototype.forEach.call(myCheckbox, function(el) {
			el.checked = false;
		});
		id.checked = true;
	}
</script>
<script>
	function selectOnlyThis6(id) {
		var myCheckbox = document.getElementsByName("eveningrc");
		Array.prototype.forEach.call(myCheckbox, function(el) {
			el.checked = false;
		});
		id.checked = true;
	}
</script>
<script>
	function selectOnlyThis7(id) {
		var myCheckbox = document.getElementsByName("nonresidencegrc");
		Array.prototype.forEach.call(myCheckbox, function(el) {
			el.checked = false;
		});
		id.checked = true;
	}
</script>
<script>
	function selectOnlyThis8(id) {
		var myCheckbox = document.getElementsByName("coordinatorgrc");
		Array.prototype.forEach.call(myCheckbox, function(el) {
			el.checked = false;
		});
		id.checked = true;
	}
</script>
<script>
	function selectOnlyThis9(id) {
		var myCheckbox = document.getElementsByName("pwdgrc");
		Array.prototype.forEach.call(myCheckbox, function(el) {
			el.checked = false;
		});
		id.checked = true;
	}
</script>
<script>
	function selectOnlyThis9(id) {
		var myCheckbox = document.getElementsByName("grc");
		Array.prototype.forEach.call(myCheckbox, function(el) {
			el.checked = false;
		});
		id.checked = true;
	}
</script>

<script>
	function selectOnlyThis10(id) {
		var myCheckbox = document.getElementsByName("internationalgrc");
		Array.prototype.forEach.call(myCheckbox, function(el) {
			el.checked = false;
		});
		id.checked = true;
	}
</script>
<script>
	function selectOnlyThis11(id) {
		var myCheckbox = document.getElementsByName("hallchair");
		Array.prototype.forEach.call(myCheckbox, function(el) {
			el.checked = false;
		});
		id.checked = true;
	}
</script>



</head>
<body>
	<div id="main-wrapper">
		<div class="navbar navbar-inverse" role="navvoteigation">
			<div class="navbar-header">
				<div class="logo">
					<h1>
						<b>E-voting</b>
					</h1>
				</div>
			</div>
		</div>
		<div class="template-page-wrapper">

			<div class="form-group">
				<div class="col-md-12">
					<div class="col-md-13">


						<h4 class="modal-title" style="color: green; text-center: right;">
							<b>BALLOT PAPER</b>
						</h4>

						<div class="row votingform">


							<form action="savevote"
								class="form-horizontal templatemo-signin-form">


								<h4 class="modal-title"
									style="color: #7E191B; text-align: center;">
									<b>GUILD PRESIDENT</b>
								</h4>






								<table class="table table-striped table-bordered table-list">
									<thead>
										<tr>

											<th>FIRST NAME</th>
											<th>LAST NAME</th>


											<th>POSITION</th>
											<th>IMAGE</th>

											<th>VOTE</th>





										</tr>
									</thead>
									<tbody id="myTable">
										<c:forEach var="details" items="${listOne}">



											<tr>
												<td>${details.candidateFirstName}</td>
												<td>${details.candidateSecondName}</td>
												<td>${details.position}</td>
												<td><img class="img-responsive" alt="a" height="100px"
													width="100px"
													src="<c:url value='/resources/image/${details.imageLink}'/>">
												</td>
												<td><input type="checkbox" name="guild"
													onclick="selectOnlyThis(this)"
													value="${details.candidateId}" height="200px" width="200px" /></td>



											</tr>

										</c:forEach>

									</tbody>
								</table>





								<hr>



								<h4 class="modal-title"
									style="color: orange; text-align: center;">
									<b>HALL CHAIRPERSON</b>
								</h4>



								<table class="table table-striped table-bordered table-list">
									<thead>
										<tr>

											<th>FIRST NAME</th>
											<th>LAST NAME</th>


											<th>POSITION</th>
											<th>IMAGE</th>

											<th>VOTE</th>





										</tr>
									</thead>
									<tbody id="myTable">
										<c:forEach var="details" items="${listEleven}">

											<c:if test="${details.hall eq student.hall}">


												<tr>
													<td>${details.candidateFirstName}</td>
													<td>${details.candidateSecondName}</td>
													<td>${details.position}</td>
													<td><img class="img-responsive" alt="a" height="100px"
														width="100px"
														src="<c:url value='/resources/image/${details.imageLink}'/>">
													</td>
													<td><input type="checkbox" name="hallchair"
														onclick="selectOnlyThis11(this)"
														value="${details.candidateId}" height="200px"
														width="200px" /></td>



												</tr>
											</c:if>
										</c:forEach>

									</tbody>
								</table>

								<hr>
								<c:if test="${student.residenceType eq 'RESIDENT'}">

									<h4 class="modal-title"
										style="color: #7E191B; text-align: center;">
										<b>HALL GRC</b>
									</h4>





									<table class="table table-striped table-bordered table-list">
										<thead>
											<tr>

												<th>FIRST NAME</th>
												<th>LAST NAME</th>


												<th>POSITION</th>
												<th>IMAGE</th>

												<th>VOTE</th>





											</tr>
										</thead>
										<tbody id="myTable">
											<c:forEach var="details" items="${listThree}">

												<c:if
													test="${details.hall eq student.hall and student.residenceType eq 'RESIDENT'}">


													<tr>
														<td>${details.candidateFirstName}</td>
														<td>${details.candidateSecondName}</td>
														<td>${details.position}</td>
														<td><img class="img-responsive" alt="a"
															height="100px" width="100px"
															src="<c:url value='/resources/image/${details.imageLink}'/>">
														</td>
														<td><input type="checkbox" name="hallgrc"
															onclick="selectOnlyThis3(this)"
															value="${details.candidateId}" height="200px"
															width="200px" /></td>



													</tr>
												</c:if>
											</c:forEach>

										</tbody>
									</table>
								</c:if>
								<hr>

								<h4 class="modal-title"
									style="color: #7E191B; text-align: center;">
									<b>FACULTY GRC</b>
								</h4>



								<table class="table table-striped table-bordered table-list">
									<thead>
										<tr>

											<th>FIRST NAME</th>
											<th>LAST NAME</th>


											<th>POSITION</th>
											<th>IMAGE</th>

											<th>VOTE</th>





										</tr>
									</thead>
									<tbody id="myTable">
										<c:forEach var="details" items="${listTwo}">

											<c:if test="${details.faculty eq student.faculty}">


												<tr>
													<td>${details.candidateFirstName}</td>
													<td>${details.candidateSecondName}</td>
													<td>${details.position}</td>
													<td><img class="img-responsive" alt="a" height="100px"
														width="100px"
														src="<c:url value='/resources/image/${details.imageLink}'/>">
													</td>
													<td><input type="checkbox" name="facultygrc"
														onclick="selectOnlyThis2(this)"
														value="${details.candidateId}" height="200px"
														width="200px" /></td>



												</tr>
											</c:if>
										</c:forEach>

									</tbody>
								</table>
								<c:if test="${student.sponsorship eq 'PRIVATE'}">


									<hr>
									<h4 class="modal-title"
										style="color: orange; text-align: center;">
										<b>PRIVATE STUDENTS' REPRESENTATIVE</b>
									</h4>




									<table class="table table-striped table-bordered table-list">
										<thead>
											<tr>

												<th>FIRST NAME</th>
												<th>LAST NAME</th>


												<th>POSITION</th>
												<th>IMAGE</th>

												<th>VOTE</th>





											</tr>
										</thead>
										<tbody id="myTable">
											<c:forEach var="details" items="${listFour}">

												<c:if test="${student.sponsorship eq 'PRIVATE'}">


													<tr>
														<td>${details.candidateFirstName}</td>
														<td>${details.candidateSecondName}</td>
														<td>${details.position}</td>
														<td><img class="img-responsive" alt="a"
															height="100px" width="100px"
															src="<c:url value='/resources/image/${details.imageLink}'/>">
														</td>
														<td><input type="checkbox" name="privategrc"
															onclick="selectOnlyThis4(this)"
															value="${details.candidateId}" height="200px"
															width="200px" /></td>



													</tr>
												</c:if>
											</c:forEach>

										</tbody>
									</table>
								</c:if>
								<hr>


								<c:if test="${student.sponsorship eq 'GOVERNMENT'}">


									<hr>
									<h4 class="modal-title"
										style="color: #7E191B; text-align: center;">
										<b>GOVERNMENT STUDENTS' REPRESENTATIVE</b>
									</h4>



									<table class="table table-striped table-bordered table-list">
										<thead>
											<tr>

												<th>FIRST NAME</th>
												<th>LAST NAME</th>


												<th>POSITION</th>
												<th>IMAGE</th>

												<th>VOTE</th>





											</tr>
										</thead>
										<tbody id="myTable">
											<c:forEach var="details" items="${listFive}">

												<c:if test="${student.sponsorship eq 'GOVERNMENT'}">


													<tr>
														<td>${details.candidateFirstName}</td>
														<td>${details.candidateSecondName}</td>
														<td>${details.position}</td>
														<td><img class="img-responsive" alt="a"
															height="100px" width="100px"
															src="<c:url value='/resources/image/${details.imageLink}'/>">
														</td>
														<td><input type="checkbox" name="governmentgrc"
															onclick="selectOnlyThis5(this)"
															value="${details.candidateId}" height="200px"
															width="200px" /></td>



													</tr>
												</c:if>
											</c:forEach>

										</tbody>
									</table>
								</c:if>
								<hr>


								<c:if test="${student.programType eq 'EVENING'}">


									<hr>
									<h4 class="modal-title"
										style="color: #7E191B; text-align: center;">
										<b>EVENING STUDENTS' REPRESENTATIVE</b>
									</h4>



									<table class="table table-striped table-bordered table-list">
										<thead>
											<tr>

												<th>FIRST NAME</th>
												<th>LAST NAME</th>


												<th>POSITION</th>
												<th>IMAGE</th>

												<th>VOTE</th>





											</tr>
										</thead>
										<tbody id="myTable">
											<c:forEach var="details" items="${listSix}">

												<c:if test="${student.programType eq 'EVENING'}">


													<tr>
														<td>${details.candidateFirstName}</td>
														<td>${details.candidateSecondName}</td>
														<td>${details.position}</td>
														<td><img class="img-responsive" alt="a"
															height="100px" width="100px"
															src="<c:url value='/resources/image/${details.imageLink}'/>">
														</td>
														<td><input type="checkbox" name="eveningrc"
															onclick="selectOnlyThis6(this)"
															value="${details.candidateId}" height="200px"
															width="200px" /></td>



													</tr>
												</c:if>
											</c:forEach>

										</tbody>
									</table>
								</c:if>
								<hr>

								<c:if test="${student.residenceType eq 'NON-RESIDENT'}">


									<hr>
									<h4 class="modal-title"
										style="color: orange; text-align: center;">
										<b>NON RESIDENTS STUDENTS' REPRESENTATIVE</b>
									</h4>


									<table class="table table-striped table-bordered table-list">
										<thead>
											<tr>

												<th>FIRST NAME</th>
												<th>LAST NAME</th>


												<th>POSITION</th>
												<th>IMAGE</th>

												<th>VOTE</th>





											</tr>
										</thead>
										<tbody id="myTable">
											<c:forEach var="details" items="${listSeven}">

												<c:if
													test="${details.residenceType eq student.residenceType}">


													<tr>
														<td>${details.candidateFirstName}</td>
														<td>${details.candidateSecondName}</td>
														<td>${details.position}</td>
														<td><img class="img-responsive" alt="a"
															height="100px" width="100px"
															src="<c:url value='/resources/image/${details.imageLink}'/>">
														</td>
														<td><input type="checkbox" name="nonresidencegrc"
															onclick="selectOnlyThis7(this)"
															value="${details.candidateId}" height="200px"
															width="200px" /></td>



													</tr>
												</c:if>
											</c:forEach>

										</tbody>
									</table>
								</c:if>
								<hr>



								<c:if test="${student.coordinator eq 'YES'}">


									<hr>
									<h4 class="modal-title"
										style="color: #7E191B; text-align: center;">
										<b>COORDINATOR STUDENTS' REPRESENTATIVE</b>
									</h4>


									<table class="table table-striped table-bordered table-list">
										<thead>
											<tr>

												<th>FIRST NAME</th>
												<th>LAST NAME</th>


												<th>POSITION</th>
												<th>IMAGE</th>

												<th>VOTE</th>





											</tr>
										</thead>
										<tbody id="myTable">
											<c:forEach var="details" items="${listEight}">

												<c:if test="${details.coordinator eq student.coordinator}">


													<tr>
														<td>${details.candidateFirstName}</td>
														<td>${details.candidateSecondName}</td>
														<td>${details.position}</td>
														<td><img class="img-responsive" alt="a"
															height="100px" width="100px"
															src="<c:url value='/resources/image/${details.imageLink}'/>">
														</td>
														<td><input type="checkbox" name="coordinatorgrc"
															onclick="selectOnlyThis8(this)"
															value="${details.candidateId}" height="200px"
															width="200px" /></td>



													</tr>
												</c:if>
											</c:forEach>

										</tbody>
									</table>
								</c:if>



								</hr>


								<c:if test="${student.pwd eq 'YES'}">


									<hr>
									<h4 class="modal-title"
										style="color: orange; text-align: center;">
										<b>PWD STUDENTS' REPRESENTATIVE</b>
									</h4>


									<table class="table table-striped table-bordered table-list">
										<thead>
											<tr>

												<th>FIRST NAME</th>
												<th>LAST NAME</th>


												<th>POSITION</th>
												<th>IMAGE</th>

												<th>VOTE</th>





											</tr>
										</thead>
										<tbody id="myTable">
											<c:forEach var="details" items="${listNine}">

												<c:if test="${details.pwd eq student.pwd}">


													<tr>
														<td>${details.candidateFirstName}</td>
														<td>${details.candidateSecondName}</td>
														<td>${details.position}</td>
														<td><img class="img-responsive" alt="a"
															height="100px" width="100px"
															src="<c:url value='/resources/image/${details.imageLink}'/>">
														</td>
														<td><input type="checkbox" name="pwdgrc"
															onclick="selectOnlyThis9(this)"
															value="${details.candidateId}" height="200px"
															width="200px" /></td>



													</tr>
												</c:if>
											</c:forEach>

										</tbody>
									</table>
								</c:if>
								<hr>

								<c:if test="${student.citizenship eq 'INTERNATIONAL'}">


									<hr>
									<h4 class="modal-title"
										style="color: orange; text-align: center;">
										<b>INTERNTIONAL STUDENTS' REPRESENTATIVE</b>
									</h4>

									<table class="table table-striped table-bordered table-list">
										<thead>
											<tr>

												<th>FIRST NAME</th>
												<th>LAST NAME</th>


												<th>POSITION</th>
												<th>IMAGE</th>

												<th>VOTE</th>





											</tr>
										</thead>
										<tbody id="myTable">
											<c:forEach var="details" items="${listTen}">

												<c:if test="${details.citizenship eq student.citizenship}">


													<tr>
														<td>${details.candidateFirstName}</td>
														<td>${details.candidateSecondName}</td>
														<td>${details.position}</td>
														<td><img class="img-responsive" alt="a"
															height="100px" width="100px"
															src="<c:url value='/resources/image/${details.imageLink}'/>">
														</td>
														<td><input type="checkbox" name="internationalgrc"
															onclick="selectOnlyThis10(this)"
															value="${details.candidateId}" height="200px"
															width="200px" /></td>



													</tr>
												</c:if>
											</c:forEach>

										</tbody>
									</table>
								</c:if>


								</hr>
								<br>



								<div class="modal-footer">
									<input type="text" name="voteToken" value="${voteId}" /> 
									<input
										type="text" name="studentNo" value="${student.studentNo}" />

									<button class="btn btn-warning" type="submit">Submit
										Vote</button>

								</div>
							</form>

						</div>
						<!--/col-span-9-->





































					</div>
				</div>
				</form>
			</div>
		</div>
		/
	</div>
</body>
</html>