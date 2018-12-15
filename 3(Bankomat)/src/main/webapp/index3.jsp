<%@ page import="com.electricalweb.controllers.Check" %>
<%@ page import="com.electricalweb.controllers.Logs" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 08.10.2018
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href='style1.css' rel='stylesheet' type='text/css'>

</head>
<body>
 <%
     request.setAttribute("name",request.getParameter("name"));
     request.setAttribute("surname",request.getParameter("surname"));
     if(Check.flag){
         request.setAttribute("sum",(Object) Check.last);
     }
     request.setAttribute("list", Logs.list);
 %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
    <a class="navbar-brand" href="#">
        <img src="https://smart-lab.ru/uploads/company/00/23/37/thumbnail.png" width="30" height="30" alt="logo">
        MoskovkinBank
    </a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expended="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item-active">
                <a href="https://vk.com/moskovkin2013" class="nav-link">Основатель</a>
            </li>
            <li class="nav-item">
                <a href="https://www.google.by/maps/place/53%C2%B054'41.6%22N+27%C2%B035'45.3%22E/@53.911562,27.5943784,17z/data=!3m1!4b1!4m9!1m2!2m1!1z0JHQk9Cj0JjQoCDQutCw0YTQtdC00YDQsCDQmNCY0KI!3m5!1s0x0:0x0!7e2!8m2!3d53.9115625!4d27.5959259" class="nav-link" >Филиал</a>
            </li>
            <li class="nav-item">
                <a href="https://iit.bsuir.by/" class="nav-link">Генеральный Спонсор</a>
            </li>
        </ul>
        <a href="#" class="nav-link" data-toggle="modal">Приветствуем вас,${name} ${surname}</a>
        <a class="btn btn-primary" href="index.jsp"  role="button">Выход</a>
    </div>
</nav>

<div class="container-fluid p-0">
    <div id = "carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li class="active" data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li  data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            <li  data-target="#carouselExampleIndicators" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner" >
            <div class="carousel-item active">
                <img src="2.jpg" alt="" class="d-block w-100">
            </div>
            <div class="carousel-item">
                <img src="3.jpg" alt="" class="d-block w-100">
            </div><div class="carousel-item">
            <img src="1.jpg" alt="" class="d-block w-100">
        </div>
        </div>
        <a href="#carouselExampleIndicators" class="carousel-control-prev" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a href="#carouselExampleIndicators" class="carousel-control-next" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<div class="container-fluid wrapper">
    <div class="container">
        <div class="row text-center justify-content-center">

            <div class="col-xs-3 col-sm-4 col-lg-4"><button type="button" class="nav-link" data-toggle="modal" data-target="#exampleModal">
                <div class="card-deck">
                    <div class="card">
                        <img class="card-img-top" src="карта.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Перевод с карты на карту</h5>
                            <p class="card-text">Мы сотрудничаем с организациями  Visa и MasterCard</p>
                        </div>
                    </div>
                </div>

            </button>
            </div>
            <div class="col-xs-3 col-sm-4 col-lg-4"><button type="button" class="nav-link" data-toggle="modal" data-target="#exampleModal1">
                <div class="card-deck">
                    <div class="card">
                        <img class="card-img-top" src="карта.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Произвольный платеж</h5>
                            <p class="card-text">Здесь, вы можете перевести деньги на произволный лицевой счет</p>
                        </div>
                    </div>
                </div>

            </button>
            </div>
            <div class="col-xs-3 col-sm-4 col-lg-4"><button type="button" class="nav-link" data-toggle="modal" data-target="#exampleModal2">
                <div class="card-deck">
                    <div class="card">
                        <img class="card-img-top" src="карта.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Проверить баланс</h5>
                            <p class="card-text">Здесь вы можете узнать доступные вам на текущий момент средства </p>
                        </div>
                    </div>
                </div>

            </button>
            </div>
            <div class="col-xs-3 col-sm-4 col-lg-4"><button type="button" class="nav-link" data-toggle="modal" data-target="#exampleModal3">
                <div class="card-deck">
                    <div class="card">
                        <img class="card-img-top" src="карта.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">История платежей</h5>
                            <p class="card-text">Здесь вы можете проверить историю совершенных вами платежей </p>
                        </div>
                    </div>
                </div>
            </button>
            </div>
            <div class="col-xs-3 col-sm-4 col-lg-4"><button type="button" class="nav-link" data-toggle="modal" data-target="#exampleModal4">
                <div class="card-deck">
                    <div class="card">
                        <img class="card-img-top" src="карта.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Положить деньги на мобильный телефон</h5>
                            <p class="card-text">Здесь вы можете положить деньги на любой номер любого оператора</p>
                        </div>
                    </div>
                </div>

            </button>
            </div>
        </div>
        </div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleleModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Перевод на карту
                </h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/cardTransaction" method="post">
                <input placeholder="Введите номер карты" type="text" name="number_of_card_for_transaction" id="number_of_card_for_transaction" value="${number_of_card_for_transaction}">
                    <br>
                    <input placeholder="Введите cумму" type="text" name="sum_of_transaction" id="sum_of_transaction" value="${sum_of_transaction}">
                    <br>
                    <input type="submit" name="signin" value="Завершить">
                </form>
            </div>
        </div>

    </div>

</div>
<div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleleModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel1">Перевод на другой счет
                </h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/RandomPayTransaction" method="post">
                    <input placeholder="лицевой счет" type="text" name="number_of_check" id="number_of_check" value="${number_of_check}">
                    <br>
                    <input placeholder="Введите cумму" type="text" name="sum_of_transaction" id="sum_of_transaction1" value="${sum_of_transaction}">
                    <br>
                    <input type="submit" name="signin" value="Завершить">
                </form>
            </div>
        </div>

    </div>
</div>
 <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleleModal" aria-hidden="true">
     <div class="modal-dialog" role="document">
         <div class="modal-content">
             <div class="modal-header">
                 <h5 class="modal-title" id="exampleModalLabel2">Лицевой счет
                 </h5>
                 <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                 </button>
             </div>
             <div class="modal-body">
                 <h1>Вам доступно на данный момент ${sum}</h1>
             </div>
         </div>

     </div>
 </div>
 <div class="modal fade" id="exampleModal3" tabindex="-1" role="dialog" aria-labelledby="exampleleModal" aria-hidden="true">
     <div class="modal-dialog" role="document">
         <div class="modal-content">
             <div class="modal-header">
                 <h5 class="modal-title" id="exampleModalLabel3">История операция
                 </h5>
                 <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                 </button>
             </div>
             <div class="modal-body">
                 <p>
                        <c:forEach items="${list}" var="list">
                            <br>${list}
                        </c:forEach>

                 </p>
             </div>
         </div>

     </div>
 </div>
 <div class="modal fade" id="exampleModal4" tabindex="-1" role="dialog" aria-labelledby="exampleleModal" aria-hidden="true">
     <div class="modal-dialog" role="document">
         <div class="modal-content">
             <div class="modal-header">
                 <h5 class="modal-title" id="exampleModalLabel4">Оплата мобильного оператора
                 </h5>
                 <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                 </button>
             </div>
             <div class="modal-body">
                 <form action="${pageContext.request.contextPath}/phoneNumber" method="post">
                     <input placeholder="Введите номер телефона" type="text" name="phone_number" id="phone_number" value="${phone_number}">
                     <br>
                     <input placeholder="Введите cумму" type="text" name="sum_of_transaction" id="sum_of_transactionn" value="${sum_of_transaction}">
                     <br>
                     <input type="submit" name="signin" value="Завершить">
                 </form>
             </div>
         </div>

     </div>
 </div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script type="text/javascript"></script>
</body>
</html>