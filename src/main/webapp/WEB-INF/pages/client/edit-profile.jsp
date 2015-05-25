<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 21.05.2015
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="/res/css/bootstrap.min.css">
  <link rel="stylesheet" href="/res/css/bootstrap-theme.min.css">
  <script type="text/javascript" src="/res/js/jquery.js"></script>
  <script type="text/javascript" src="/res/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/res/js/edit_profile.js"> </script>

    <title>Edit profile</title>
</head>
<body>

  <%
    String username = (String)request.getAttribute("username");
    String phone = (String)request.getAttribute("phone");
  %>
  <%--<h5><%=username%></h5>--%>
  <div class="alert alert-danger" role="alert" id="alert_message" style="display: none">
    <%--<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>--%>
    <%--<span class="sr-only">Error:</span>--%>
    <%--<p id="message"/>--%>
  </div>

  <a href="/client/cabinet">Back to cabinet</a>
  <div style="margin: 5%">
    <h2>Edit profile</h2>

    <hr>
    <h4>Edit name</h4>
    <h5>Username:</h5>
    <div class="input-group">
      <input type="text" id="username" class="form-control" style="width: 300px">
    </div>
    <h5>First name:</h5>
    <div class="input-group">
      <input type="text" id="first_name" class="form-control" style="width: 300px">
    </div>
    <h5>Last name:</h5>
    <div class="input-group">
      <input type="text" id="last_name" class="form-control" style="width: 300px">
    </div>
    <button class="btn btn-primary btn-md" id="save_names" style="margin-top: 10px">Save</button>

    <hr>
    <h4>Edit phone</h4>
    <h5>Phone 1:</h5>
    <div class="input-group">
      <input type="text" id="phone1" class="form-control" style="width: 300px">
    </div>
    <h5>Phone 2:</h5>
    <div class="input-group">
      <input type="text" id="phone2" class="form-control" style="width: 300px">
    </div>
    <h5>Phone 3:</h5>
    <div class="input-group">
      <input type="text" id="phone3" class="form-control" style="width: 300px">
    </div>
    <button class="btn btn-primary btn-md" id="save_phones" style="margin-top: 10px">Save</button>

    <hr>
    <h4>Edit e-mail</h4>
    <div class="input-group">
      <input type="text" id="email" class="form-control" style="width: 300px">
    </div>

    <button class="btn btn-primary btn-md" id="save_email" style="margin-top: 10px">Save</button>

    <hr>
    <h4>Edit social links</h4>
    <div class="input-group">
      <input type="text" id="social_links" class="form-control" style="width: 300px">
    </div>
    <button class="btn btn-primary btn-md" id="save_social" style="margin-top: 10px">Save</button>

    <hr>
    <h4>Change password</h4>
    <h5>Old password:</h5>
    <div class="input-group">
      <input type="text" id="old_pass" class="form-control" style="width: 300px">
    </div>
    <h5>New password:</h5>
    <div class="input-group">
      <input type="text" id="new_pass" class="form-control" style="width: 300px">
    </div>
    <h5>Confirm new password:</h5>
    <div class="input-group">
      <input type="text" id="conf_new_pass" class="form-control" style="width: 300px">
    </div>
    <button class="btn btn-primary btn-md" id="change_pass" style="margin-top: 10px">Save</button>
  </div>
</body>
</html>
