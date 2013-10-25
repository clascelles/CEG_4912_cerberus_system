<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<div class="span2 main-menu-span">
	<div class="well nav-collapse sidebar-nav">
		<ul class="nav nav-tabs nav-stacked main-menu">
			<li class="nav-header hidden-tablet">Menu</li>
			<li><a class="ajax-link" href="/webappserver/home/index"><i class="icon-home"></i><span class="hidden-tablet"> Dashboard</span></a></li>
			<li><a class="ajax-link" href="/webappserver/outlets/index"><i class="icon-film"></i><span class="hidden-tablet"> Outlets</span></a></li>
			<li><a class="ajax-link" href="/webappserver/account/index"><i class="icon-user"></i><span class="hidden-tablet"> Account</span></a></li>
			<c:if test="${isSysAdmin}"><li><a class="ajax-link" href="/webappserver/system/index"><i class="icon-wrench"></i><span class="hidden-tablet"> System</span></a></li></c:if>
			<li><a class="ajax-link" href="/webappserver/schedules/index"><i class="icon-time"></i><span class="hidden-tablet"> Scheduling</span></a></li>
			<li><a class="ajax-link" href="/webappserver/usage/index"><i class="icon-signal"></i><span class="hidden-tablet"> Usage</span></a></li>
		</ul>
	</div><!--/.well -->
</div><!--/span-->
