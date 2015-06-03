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
    <script type="text/javascript" src="/res/js/clients.js"> </script>
</head>
<body>

    <div>
        <a class="btn btn-large btn-info" href="/client/cabinet">Back to Cabinet</a>
    </div>

  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#panel1">Crate new client</a></li>
    <li><a data-toggle="tab" href="#panel2">Search...</a></li>
    <%--<li><a data-toggle="tab" href="#panel3">Панель 3</a></li>--%>
    <%--<li><a data-toggle="tab" href="#panel4">Панель 4</a></li>--%>
  </ul>

  <div class="tab-content">
    <div id="panel1" class="tab-pane fade in active">

        <div class="container">
            <h3>Create new client</h3>
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
                    <label for="registerOtherNames">Other names:</label>
                    <input type="text" class="form-control" id="registerOtherNames">
                </div>

                <div class="form-group" style="width:400px;">
                    <label for="registerTags">Tags:</label>
                    <input type="text" class="form-control" id="registerTags">
                </div>

                <div class="form-group" style="width:400px">
                    <label for="registerComment">Comment:</label>
                    <input type="text" class="form-control" id="registerComment" style=" eight: 100px">
                </div>

                <div class="form-group" style="width:400px;">
                    <label for="registerId1">Id 1:</label>
                    <input type="text" class="form-control" id="registerId1">
                </div>

                <div class="form-group" style="width:400px;">
                    <label for="registerId2">Id 2:</label>
                    <input type="text" class="form-control" id="registerId2">
                </div>

                <div class="form-group" style="width:400px;">
                    <label for="registerId3">Id 3:</label>
                    <input type="text" class="form-control" id="registerId3">
                </div>

                <div class="form-group" style="width:400px;">
                    <label for="registerPassword">Password:</label>
                    <input type="text" class="form-control" id="registerPassword">
                </div>

                <div class="form-group" style="width:400px;">
                    <label for="registerGroup">Group:</label>
                    <select id="registerGroup" class="form-control" style="width: 400px">
                        <option value="None">None</option>
                    </select>
                </div>

                <button type="button" class="btn btn-default" onclick="saveClient()">Save</button>
            </form>
        </div>
    </div>

    <div id="panel2" class="tab-pane fade">
      <h3>Searching...</h3>

        <div class="input-group">
          <select id="groupSelection" class="form-control" style="width: 150px">
            <option>Group 1</option>
            <option>Group 2</option>
            <option>All</option>
            <option>None</option>
          </select>

          <input id="name" type="text" class="form-control" placeholder="Name" style="width: 150px">

          <input id="surname" type="text" class="form-control" placeholder="Surname" style="width: 150px">

          <input id="phone" type="text" class="form-control" placeholder="Phone" style="width: 150px">

          <input id="email" type="text" class="form-control" placeholder="Email" style="width: 150px">

          <input id="tags" type="text" class="form-control" placeholder="Tags" style="width: 150px">

          <button type="button" class="btn btn-primary btn-md" onclick="findByCondition()">Search</button>
        </div>

      <button type="button" class="btn btn-primary btn-md" onclick="findAllClients()">Find All</button>
      <table class="table" id="clientsTable">
        <thead>
        <tr>
          <th>Id</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Group</th>
          <th>Phone</th>
          <th>Phone 2</th>
          <th>Phone 3</th>
          <th>Email</th>
          <th>Social links</th>
          <th>Other names</th>
          <th>Tags</th>
          <th>Comment</th>
          <th>Id 1</th>
          <th>Id 2</th>
          <th>Id 3</th>
          <th>Creation time</th>
          <th>Modification time</th>
          <th>Password</th>
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
                                  <label for="updatePhone">Phone:</label>
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
                                  <label for="updateOtherNames">Other names:</label>
                                  <input type="text" class="form-control" id="updateOtherNames">
                              </div>

                              <div class="form-group" style="width:400px;">
                                  <label for="updateTags">Tags:</label>
                                  <input type="text" class="form-control" id="updateTags">
                              </div>

                              <div class="form-group" style="width:400px">
                                  <label for="updateComment">Comment:</label>
                                  <input type="text" class="form-control" id="updateComment" style=" eight: 100px">
                              </div>

                              <div class="form-group" style="width:400px;">
                                  <label for="updateId1">Id 1:</label>
                                  <input type="text" class="form-control" id="updateId1">
                              </div>

                              <div class="form-group" style="width:400px;">
                                  <label for="updateId2">Id 2:</label>
                                  <input type="text" class="form-control" id="updateId2">
                              </div>

                              <div class="form-group" style="width:400px;">
                                  <label for="updateId3">Id 3:</label>
                                  <input type="text" class="form-control" id="updateId3">
                              </div>

                              <div class="form-group" style="width:400px;">
                                  <label for="updatePassword">Password:</label>
                                  <input type="text" class="form-control" id="updatePassword">
                              </div>

                              <div class="modal-footer">
                                  <button type="button" class="btn btn-primary" onclick="deleteClient()">Delete</button>
                                  <button type="button" class="btn btn-primary" onclick="updateClient()">Udate</button>
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

              getListOfGroups();

              $("#clientsTable").on("click", "tr", function() {
                  $("#updateId").val($(this).find("td:eq(0)").text());
                  $("#updateName").val($(this).find("td:eq(1)").text());
                  $("#updateSurname").val($(this).find("td:eq(2)").text());
                  $("#updateGroup").val($(this).find("td:eq(3)").text());
                  $("#updatePhone").val($(this).find("td:eq(4)").text());
                  $("#updatePhone2").val($(this).find("td:eq(5)").text());
                  $("#updatePhone3").val($(this).find("td:eq(6)").text());
                  $("#updateEmail").val($(this).find("td:eq(7)").text());
                  $("#updateSocialLinks").val($(this).find("td:eq(8)").text());
                  $("#updateOtherNames").val($(this).find("td:eq(9)").text());
                  $("#updateTags").val($(this).find("td:eq(10)").text());
                  $("#updateComment").val($(this).find("td:eq(11)").text());
                  $("#updateId1").val($(this).find("td:eq(12)").text());
                  $("#updateId2").val($(this).find("td:eq(13)").text());
                  $("#updateId3").val($(this).find("td:eq(14)").text());
                  $("#updatePassword").val($(this).find("td:eq(17)").text());
              });
          });
      </script>
</body>
</html>
