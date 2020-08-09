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
<!-- Styles -->
<style>
.example1 {
 height: 50px;	
 overflow: hidden;
 position: relative;
}
.example1 h3 {
 font-size: 3em;
 color: orange;
 position: absolute;
 width: 100%;
 height: 100%;
 margin: 0;
 line-height: 50px;
 text-align: center;
 /* Starting position */
 -moz-transform:translateX(100%);
 -webkit-transform:translateX(100%);	
 transform:translateX(100%);
 /* Apply animation to this element */	
 -moz-animation: example1 7s linear infinite;
 -webkit-animation: example1 7s linear infinite;
 animation: example1 7s linear infinite;
}
/* Move it (define the animation) */
@-moz-keyframes example1 {
 0%   { -moz-transform: translateX(100%); }
 100% { -moz-transform: translateX(-100%); }
}
@-webkit-keyframes example1 {
 0%   { -webkit-transform: translateX(100%); }
 100% { -webkit-transform: translateX(-100%); }
}
@keyframes example1 {
 0%   { 
 -moz-transform: translateX(100%); /* Firefox bug fix */
 -webkit-transform: translateX(100%); /* Firefox bug fix */
 transform: translateX(100%); 		
 }
 100% { 
 -moz-transform: translateX(-100%); /* Firefox bug fix */
 -webkit-transform: translateX(-100%); /* Firefox bug fix */
 transform: translateX(-100%); 
 }
}
</style>



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
		<br>
		<div class="template-page-wrapper">
			

			<form class="form-horizontal templatemo-signin-form" role="form"
				action="studentPanel" method="post">
				<div class="example1">
					<b><h3 class="modal-title">Thanks For casting your vote...</h3></b>
				</div>
				<br><br>

				<div class="col-md-8 center-block">
					<button id="singlebutton" name="singlebutton"
						class="btn btn-success center-block">Home</button>
				</div>

			</form>
		</div>
	</div>
</body>
</html>