<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/style.css">
  <title>Insert title here</title>
</head>

<body>
  <form action="/vdMa/LoginController" method='POST'>
    <div ng-app="App" class="page-container">
      <div class="form-container" ng-class="done">
        <div class="login-form">

          <h3>管理系统</h3>
          <div>
            <input type="text" placeholder="账号" name="account">
          </div>

          <div>
            <input type="password" placeholder="密码" name="password">
          </div>
          <input class="myBtn" type='submit' value='登录'>
        </div>

        <div class="credits">
          Create by <a href="#">Charlie</a>
        </div>

      </div>
    </div>
    </div>
  </form>
</body>

</html>