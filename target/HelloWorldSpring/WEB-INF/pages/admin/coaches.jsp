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

  <script type="text/javascript" src="/res/js/coaches.js"> </script>
</head>
<body>

<div>
  <a class="btn btn-large btn-info" href="/client/cabinet">Back to Cabinet</a>
</div>

<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#panel1">Crate new coach</a></li>
  <li><a data-toggle="tab" href="#panel2">Search...</a></li>
  <%--<li><a data-toggle="tab" href="#panel3">Панель 3</a></li>--%>
  <%--<li><a data-toggle="tab" href="#panel4">Панель 4</a></li>--%>
</ul>

<div class="tab-content">
  <div id="panel1" class="tab-pane fade in active">

    <div class="container">
      <h3>Create new coach</h3>
      <form role="form">
        <div class="form-group" style="width:400px;">
          <label for="registerName">Name:</label>
          <input type="text" class="form-control" id="registerName">
        </div>
        <div class="form-group" style="width:400px;" >
          <label for="registerSurname">Surname:</label>
          <input type="text" class="form-control" id="registerSurname">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerEmail">Email:</label>
          <input type="text" class="form-control" id="registerEmail">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerEmail2">Email 2:</label>
          <input type="text" class="form-control" id="registerEmail2">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerPhone">Phone:</label>
          <input type="text" class="form-control" id="registerPhone">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerPhone2">Phone 2:</label>
          <input type="text" class="form-control" id="registerPhone2">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerPhone3">Phone 3:</label>
          <input type="text" class="form-control" id="registerPhone3">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerSocialLinks">Social links:</label>
          <input type="text" class="form-control" id="registerSocialLinks">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerCurrency">Currency:</label>
          <input type="text" class="form-control" id="registerCurrency">
        </div>

        <div class="form-group" style="width:400px;">
          <label for="registerRate">Rate:</label>
          <input type="text" class="form-control" id="registerRate">
        </div>

        <button type="button" class="btn btn-default" onclick="saveCoach()">Save</button>
      </form>
    </div>
  </div>

  <div id="panel2" class="tab-pane fade">
    <h3>Searching...</h3>

    <div class="input-group">

      <input id="name" type="text" class="form-control" placeholder="Name" style="width: 150px">

      <input id="surname" type="text" class="form-control" placeholder="Surname" style="width: 150px">

      <input id="phone" type="text" class="form-control" placeholder="Phone" style="width: 150px">

      <input id="email" type="text" class="form-control" placeholder="Email" style="width: 150px">

      <button type="button" class="btn btn-primary btn-md" onclick="findCoachByCondition()">Search</button>
    </div>

    <button type="button" class="btn btn-primary btn-md" onclick="findAllCoaches()">Find All</button>
    <table class="table" id="coachesTable">
      <thead>
      <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone</th>
        <th>Phone 2</th>
        <th>Phone 3</th>
        <th>Email</th>
        <th>Email 2</th>
        <th>Social Links</th>
        <th>Currency</th>
        <th>Rate</th>
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
          <h2>Edit Client</h2>
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

                <div class="form-group" style="width:400px;" >
                  <label for="updateSurname">Surname:</label>
                  <input type="text" class="form-control" id="updateSurname">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updateEmail">Email:</label>
                  <input type="text" class="form-control" id="updateEmail">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updateEmail2">Email 2:</label>
                  <input type="text" class="form-control" id="updateEmail2">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="registerPhone">Phone:</label>
                  <input type="text" class="form-control" id="updatePhone">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updatePhone2">Phone 2:</label>
                  <input type="text" class="form-control" id="updatePhone2">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updatePhone3">Phone 3:</label>
                  <input type="text" class="form-control" id="updatePhone3">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updateSocialLinks">Social links:</label>
                  <input type="text" class="form-control" id="updateSocialLinks">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updateCurrency">Currency:</label>
                  <input type="text" class="form-control" id="updateCurrency">
                </div>

                <div class="form-group" style="width:400px;">
                  <label for="updateRate">Rate:</label>
                  <input type="text" class="form-control" id="updateRate">
                </div>

                <div class="modal-footer">
                  <button type="button" class="btn btn-primary" onclick="deleteCoach()">Delete</button>
                  <button type="button" class="btn btn-primary" onclick="updateCoach()">Update</button>
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
      $("#coachesTable").on("click", "tr", function() {
        $("#updateId").val($(this).find("td:eq(0)").text());
        $("#updateName").val($(this).find("td:eq(1)").text());
        $("#updateSurname").val($(this).find("td:eq(2)").text());
        $("#updatePhone").val($(this).find("td:eq(3)").text());
        $("#updatePhone2").val($(this).find("td:eq(4)").text());
        $("#updatePhone3").val($(this).find("td:eq(5)").text());
        $("#updateEmail").val($(this).find("td:eq(6)").text());
        $("#updateEmail2").val($(this).find("td:eq(7)").text());
        $("#updateSocialLinks").val($(this).find("td:eq(8)").text());
        $("#updateCurrency").val($(this).find("td:eq(9)").text());
        $("#updateRate").val($(this).find("td:eq(10)").text());
      });
    });
  </script>
</body>
</html>
