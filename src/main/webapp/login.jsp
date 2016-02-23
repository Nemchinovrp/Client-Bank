<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8">
    <style>
        <%@include file="/WEB-INF/css/bootstrap.css"%>
    </style>
    <title>Login</title>
</head>
<body>
<div class="container" style="padding:200px 0">

    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <section class="login-form">
                <form method="post" action="LoginServlet">

                    <input type="email" name="email" placeholder="Email" required class="form-control input-lg"/>
                    <input type="password" name="password" class="form-control input-lg"
                           placeholder="Password"
                           required=""/>

                    <div class="pwstrength_viewport_progress"></div>
                    <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
                    <div>
                        <a href="AdminUserListController?action=insert">Registration</a>
                    </div>
                </form>
            </section>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>
