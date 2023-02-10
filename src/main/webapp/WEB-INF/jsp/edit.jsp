<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
      <link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"	rel="stylesheet">
   </head>
   <body>
      <div class="container">
      <div class="row">
         <div class="col-md-4"></div>
         <div class="col-md-4" style="top:120px">
            <div class="panel panel-primary">
               <div class="panel-heading">
                  <h3 class="panel-title">create Todo</h3>
               </div>
               <div class="panel-body">
                  <form:form method="POST" action="/add" modelAttribute="mytodos">
                  <div class="form-group">
                        <form:label path="id">Task Name</form:label>
                        <form:input path="id" />
                  </div>
                     <div class="form-group">
                        <form:label path="taskName">Task Name</form:label>
                        <form:input path="taskName" />
                     </div>
                     <div class="form-group">
                        <form:label path="status">Select Status</form:label>
                        <form:select path="status">
                           <form:option value="NONE" label="Select" />
                           <form:options items="${statusList}" />
                        </form:select>
                     </div>
                     <input type="submit" value="Submit" class="btn btn-danger" />
                  </form:form>
               </div>
            </div>
         </div>
      </div>
   </body>
   <script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   <script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
</html>
