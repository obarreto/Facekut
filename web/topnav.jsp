<%-- 
    Document   : topnav
    Created on : Jun 4, 2020, 8:56:05 PM
    Author     : khwarizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- topnav -->
    <div class="navbar navbar-blue navbar-static-top">  
        <div class="navbar-header">
	  <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
	  </button>
	  <a href="http://usebootstrap.com/theme/facebook" class="navbar-brand logo">b</a>
        </div>
        
	<nav class="collapse navbar-collapse" role="navigation">
            <form class="navbar-form navbar-left">
                <div class="input-group input-group-sm" style="max-width:360px;">
                    <input class="form-control" placeholder="Search" name="srch-term" id="srch-term" type="text">
		<div class="input-group-btn">
		<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
		  </div>
			</div>
			</form>
			<ul class="nav navbar-nav">
                          <li>
				<a href="#"><i class="glyphicon glyphicon-home"></i> Home</a>
			  </li>
                              <li>
				<a href="#postModal" role="button" data-toggle="modal"><i class="glyphicon glyphicon-plus"></i> Post</a>
                              </li>
                                  <li>
                                    <a href="#"><span class="badge">badge</span></a>
				  </li>
                                    </ul>
					<ul class="nav navbar-nav navbar-right">
                                          <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i></a>
					<ul class="dropdown-menu">
					  <li><a href="">More</a></li>
					  <li><a href="">More</a></li>
					  <li><a href="">More</a></li>
					  <li><a href="">More</a></li>
					  <li><a href="">More</a></li>
                                        </ul>
    </li>                                            </ul>
    </nav>
</div>
						<!-- /top nav -->
