<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>MoskovkinBank</title>
    <link href='style.css' rel='stylesheet' type='text/css'>
<body>
<c:if test="${violations != null}">
    <c:forEach items="${violations}" var="violation">
        ${violation}
    </c:forEach>
</c:if>
<style>
    ::-webkit-input-placeholder {color:white; opacity:1;}/* webkit */
</style>
<div class="body">
    <div class="main">
        <h1>MoskovkinBank</h1>
        <hr>
        <h2><em>The Best Condiotions are here</em></h2>
        <h3>Connnect To Us</h3>
        <form action="${pageContext.request.contextPath}/processcustomer" method="post">
            <div class="share-inputs-wrapper">
                <div class="share-inputs-container">
                    <div class="text">
                        <div class="Password">
                            <div for="Login:">Login : </div>
                        </div>
                        <div>
                            <input  placeholder="Enter your login"  class = "share-input1" type="text" name="login" id="login" value="${login}">
                        </div>
                    </div>

                    <div class="text">
                        <div class="Password">
                            <div for="Password">Password : </div>
                        </div>
                        <div>
                            <input placeholder="Enter your password" class = "share-input1" type="password" name="password" id="password" value="${password}">
                        </div>
                    </div>
                    <input type="submit" name="signin" value="Войти">
                </div>
            </div>
        </form>
        <form action="registration.jsp" method="post">
            <input type="submit" name="signin" value="Регистрация">
        </form>
    </div>
</div>
</body>
</head>
</html>