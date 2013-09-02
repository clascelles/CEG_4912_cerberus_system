<div class="navbar">
	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse"> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
			</a> <a class="brand" href="index"> <img alt="Cerberus Logo"
				src="/webappserver/resources/img/logo20.png" /> <span>Cerberus</span></a>

			<!-- user dropdown starts -->
			<div class="btn-group pull-right">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="icon-user"></i><span class="hidden-phone">${topBarBackingObject.name}</span>
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="/webappserver/account/profile">Profile</a></li>
					<li class="divider"></li>
					<li><a href="/webappserver/logout">Logout</a>
				</ul>
			</div>
			<!-- user dropdown ends -->

		</div>
	</div>
</div>