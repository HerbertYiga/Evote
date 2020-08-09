<!DOCTYPE html>
<head>
<meta charset="utf-8">
<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
<title>E-voting</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="resources/css/templatemo_main.css">


<style>

.ml2 {
  font-weight: 900;
  font-size: 3.5em;
}

.ml2 .letter {
  display: inline-block;
  line-height: 1em;
}


</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>

</head>
<body>
	<div id="main-wrapper">
		<div class="navbar navbar-inverse" role="navvoteigation">
			<div class="navbar-header">
				<div class="logo">
					<h1 class="ml2">
						<b>Welcome To the E-voting</b>
					</h1>
				</div>
			</div>
		</div>
		<div class="template-page-wrapper">
			<form class="form-horizontal templatemo-signin-form" role="form"
				action="checkvoter" method="get">
				<div class="form-group">
					<div class="col-md-12">
					
						<div class="col-sm-14">
							<input type="text" class="form-control" id="username"
								placeholder="ENTER YOUR VOTING ID" name="voteId">
								<h5 style="color: red; text-align: center;" >
									<b>${error}</b>
								</h5>
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