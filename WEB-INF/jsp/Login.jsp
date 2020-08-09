<!DOCTYPE html>
<head>
<meta charset="utf-8">
<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
<title>E-VOTING</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="resources/css/templatemo_main.css">
<!-- 
Dashboard Template 
http://www.templatemo.com/preview/templatemo_415_dashboard
-->
</head>
<body>
	<div id="main-wrapper">
		<div class="navbar navbar-inverse" role="navigation">
			<div class="navbar-header">
				<div class="logo">
					<h1>
						<b>E-VOTING</b>
					</h1>
				</div>
			</div>
		</div>
		<div class="template-page-wrapper">
			<form class="form-horizontal templatemo-signin-form" role="form"
				action="perform_login" method="post">
				<div class="form-group">
					<div class="col-md-12">
						<label for="username" class="col-sm-2 control-label">Username</label>
						<div class="col-sm-10">
							<input name="username" type="text" class="form-control" id="username"
								placeholder="Username">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<label for="password" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password"
								placeholder="Password" name="password">
								<h6><b style="color:red">${error}</b></h6>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="col-sm-offset-2 col-sm-10">
						
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-warning" type="submit" onClick="">Submit</button>
					<button class="btn btn-default" data-dismiss="modal" type="button">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>