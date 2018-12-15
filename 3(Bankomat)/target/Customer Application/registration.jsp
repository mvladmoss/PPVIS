<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>
    <link href='for_registration.css' rel='stylesheet' type='text/css'>
<body>
<style>
    ::-webkit-input-placeholder {color:white; opacity:1;}/* webkit */
</style>
<div class="body">
    <div class="main">
        <h2><em>Регистрация пользователя</em></h2>
        <form action="${pageContext.request.contextPath}/Registration" method="post">
            <div class="share-inputs-wrapper">
                <div class="share-inputs-container">
                    <div class="text">
                        <div class="Password">
                            <div for="Login:">Логин: </div>
                        </div>
                        <div>
                            <input  placeholder="ваш номер карточки"  class = "share-input1" type="text" name="login" id="login" value="${login}">
                        </div>
                    </div>

                    <div class="text">
                        <div class="Password">
                            <div for="Password">Пароль : </div>
                        </div>
                        <div>
                            <input placeholder="придумайте пароль" class = "share-input1" type="password" name="password" id="password" value="${password}">
                        </div>
                    </div>
                    <div class="text">
                        <div class="Password">
                            <div for="Password">Ваше Имя </div>
                        </div>
                        <div>
                            <input placeholder="имя" class = "share-input1" type="text" name="name" id="name" value="${name}">
                        </div>
                    </div>
                    <div class="text">
                        <div class="Password">
                            <div for="Password">Ваше Фамилия </div>
                        </div>
                        <div>
                            <input placeholder="фамилия" class = "share-input1" type="text" name="surname" id="surname" value="${surname}">
                        </div>
                    </div>
                    <input type="submit" name="signin" value="Завершить">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</head>
</html>