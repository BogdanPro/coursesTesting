<%--
  Created by IntelliJ IDEA.
  User: Khemrayev A.K.
  Date: 27.04.2015
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <!-- Bootstrap -->
  <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">--%>
  <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">--%>
  <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.5.4/bootstrap-select.min.css">--%>
  <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.5.4/bootstrap-select.min.js"></script>--%>
  <%--<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.js"></script>--%>
  <%--<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>--%>
  <link rel="stylesheet" href="/res/css/bootstrap.min.css">
  <link rel="stylesheet" href="/res/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="/res/css/bootstrap-select.min.css">
  <script src="/res/js/bootstrap-select.min.js"></script>
  <script type="text/javascript" src="/res/js/jquery.js"></script>
  <script type="text/javascript" src="/res/js/bootstrap.min.js"></script>

  <script type="text/javascript" src="/res/js/courses.js"> </script>
</head>
<body>

<div>
  <a class="btn btn-large btn-info" href="/client/cabinet">Back to Cabinet</a>
</div>

<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#panel1">Crate new course</a></li>
  <li><a data-toggle="tab" href="#panel2">Search...</a></li>
  <%--<li><a data-toggle="tab" href="#panel3">Панель 3</a></li>--%>
  <%--<li><a data-toggle="tab" href="#panel4">Панель 4</a></li>--%>
</ul>

<div class="tab-content">
  <div id="panel1" class="tab-pane fade in active">

    <div class="container">
      <h3>Create new course</h3>
      <form role="form">
        <div class="form-group" style="width:400px;">
          <label for="registerName">Name:</label>
          <input type="text" class="form-control" id="registerName">
        </div>
        <div class="form-group" style="width:400px;" >
          <label for="registerComment">Comment:</label>
          <input type="text" class="form-control" id="registerComment">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerLessons">Lessons:</label>
          <input type="text" class="form-control" id="registerLessons">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerPrice1">Price 1:</label>
          <input type="text" class="form-control" id="registerPrice1">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerPrice2">Price 2:</label>
          <input type="text" class="form-control" id="registerPrice2">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerPrice3">Price 3:</label>
          <input type="text" class="form-control" id="registerPrice3">
        </div>

        <button type="button" class="btn btn-default" onclick="saveCourse()">Save</button>
      </form>
    </div>
  </div>

  <div id="panel2" class="tab-pane fade">
    <h3>Searching...</h3>

    <div class="input-group">

      <input id="name" type="text" class="form-control" placeholder="Name" style="width: 150px">

      <button type="button" class="btn btn-primary btn-md" onclick="findCourseByCondition()">Search</button>
    </div>

    <button type="button" class="btn btn-primary btn-md" onclick="findAllCourses()">Find All</button>
    <table class="table" id="coursesTable">
      <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Comment</th>
        <th>Lessons</th>
        <th>Price 1</th>
        <th>Price 2</th>
        <th>Price 3</th>
        <th>Groups</th>
        <th>Creation time</th>
        <th>Modification time</th>
      </tr>
      </thead>
      <tbody>
      <tr></tr>
      </tbody>
    </table>
  </div>
  <%--<div id="panel3" class="tab-pane fade">--%>
  <%--<h3>Панель 3</h3>--%>
  <%--<p>Содержимое 3 панели...</p>--%>
  <%--</div>--%>
  <%--<div id="panel4" class="tab-pane fade">--%>
  <%--<h3>Панель 4</h3>--%>
  <%--<p>Содержимое 4 панели...</p>--%>
  <%--</div>--%>

  <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true" data-replace="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h2>Edit course</h2>
          <div class="modal-body">
            <form class="form-horizontal">
              <fieldset id="modal_form">
                <div class="form-group" style="width:400px;">
                  <label for="updateId">Id:</label>
                  <input type="text" class="form-control" id="updateId" readonly>
                </div>
                <div class="form-group" style="width:400px;">
                  <label for="updateName">Name:</label>
                  <input type="text" class="form-control" id="updateName">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updateComment">Comment:</label>
                  <input type="text" class="form-control" id="updateComment">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updateLessons">Lessons:</label>
                  <input type="text" class="form-control" id="updateLessons">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updatePrice1">Price 1:</label>
                  <input type="text" class="form-control" id="updatePrice1">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updatePrice2">Price 2:</label>
                  <input type="text" class="form-control" id="updatePrice2">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updatePrice3">Price 3:</label>
                  <input type="text" class="form-control" id="updatePrice3">
                </div>

                <div class="modal-footer">
                  <button type="button" class="btn btn-primary" onclick="deleteCourse()">Delete</button>
                  <button type="button" class="btn btn-primary" onclick="updateCourse()">Update</button>
                  <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                </div>
              </fieldset>
            </form>

          </div>
        </div>
      </div>
    </div>
  </div>

  <script type="text/javascript">
    $(document).ready(function(){
      $("#coursesTable").on("click", "tr", function() {
        $("#updateId").val($(this).find("td:eq(0)").text());
        $("#updateName").val($(this).find("td:eq(1)").text());
        $("#updateComment").val($(this).find("td:eq(2)").text());
        $("#updateLessons").val($(this).find("td:eq(3)").text());
        $("#updatePrice1").val($(this).find("td:eq(4)").text());
        $("#updatePrice2").val($(this).find("td:eq(5)").text());
        $("#updatePrice3").val($(this).find("td:eq(6)").text());
      });
    });
  </script>
</body>
</html>
