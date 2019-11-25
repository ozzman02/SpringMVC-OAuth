<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<%@ include file = "header.jsp" %>
 
  <body id="page-top">

    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
     
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" >Login</a>
          </li>
        </ul>
      </div>
    </nav>

    <div class="container-fluid p-0">

      <section class="resume-section p-3 p-lg-5 d-flex d-column">
        <div class="my-auto">
          <h1 class="mb-0">Social Login
            <span class="text-primary"></span>
          </h1>
               <div class="login-form">
                  <c:forEach var="uri" items="${uriMap}">
                  	<tr>
                  		<td>
                  			<a class="btn btn-primary btn-sm" href="${uri.value}">${uri.key}</a>
                  		</td>
                  	</tr>
                  </c:forEach>
               
               </div>
          </div>  
      </section>
    </div>

 
	<%@ include file = "footer.jsp" %>
  </body>
</html>