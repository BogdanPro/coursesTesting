<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 27.04.2015
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Groups</title>
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

  <script type="text/javascript" src="/res/js/groups.js"> </script>
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
      <h3>Create new group</h3>
      <form role="form">
        <div class="form-group" style="width:400px;">
          <label for="registerName">Name:</label>
          <input type="text" class="form-control" id="registerName">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerComment">Comment:</label>
          <input type="text" class="form-control" id="registerComment">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerCoach">Coach:</label>
          <select id="registerCoach" class="form-control" style="width: 400px">
            <option value="None">None</option>
          </select>
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerPlace">Place:</label>
          <select id="registerPlace" class="form-control" style="width: 400px">
            <option value="None">None</option>
          </select>
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerCourse">Course:</label>
          <select id="registerCourse" class="form-control" style="width: 400px">
            <option value="None">None</option>
          </select>
        </div>

        <button type="button" class="btn btn-default" onclick="saveGroup()">Save</button>
      </form>
    </div>
  </div>

  <div id="panel2" class="tab-pane fade">
    <h3>Searching...</h3>

    <div class="input-group">

      <input id="name" type="text" class="form-control" placeholder="Name" style="width: 150px">

      <button type="button" class="btn btn-primary btn-md" onclick="findGroupByCondition()">Search</button>
    </div>

    <button type="button" class="btn btn-primary btn-md" onclick="findAllGroups()">Find All</button>
    <table class="table" id="groupsTable">
      <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Comment</th>
        <th>Coach</th>
        <th>Place</th>
        <th>Course</th>
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
          <h2>Edit group</h2>
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
                  <label for="updateCoach">Coach:</label>
                  <select id="updateCoach" class="form-control" style="width: 400px">
                    <option value="None">None</option>
                  </select>
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updateCourse">Course:</label>
                  <select id="updateCourse" class="form-control" style="width: 400px">
                    <option value="None">None</option>
                  </select>
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updatePlace">Place:</label>
                  <select id="updatePlace" class="form-control" style="width: 400px">
                    <option value="None">None</option>
                  </select>
                </div>

                <div class="modal-footer">
                  <button type="button" class="btn btn-primary" onclick="deleteGroup()">Delete</button>
                  <button type="button" class="btn btn-primary" onclick="updateGroup()">Update</button>
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

      getListOfCoahes();
      getListOfCourses();
      getListOfPlaces();

      $("#groupsTable").on("click", "tr", function() {
        $("#updateId").val($(this).find("td:eq(0)").text());
        $("#updateName").val($(this).find("td:eq(1)").text());
        $("#updateComment").val($(this).find("td:eq(2)").text());
        $("#updateCoach").val($(this).find("td:eq(3)").text());
        $("#updtatePlace").val($(this).find("td:eq(4)").text());
        $("#updateCourse").val($(this).find("td:eq(5)").text());
      });
    });
  </script>
</body>
</html>
