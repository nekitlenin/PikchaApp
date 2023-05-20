<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Регистрация</title>
    <style>
        <#include "style.css" />
    </style>
</head>
<body>
<div class="container">
    <img class="logo-img" src="/resources/logo.png" alt="Логотип">
    <h1>Регистрация</h1>
    <fieldset>
        <form name="user" action="/signup" method="post">
            Имя: <label>
                <input type="text" name="name"/>
            </label><br/>
            Email: <label>
                <input type="email" name="email"/>
            </label><br/>
            Пароль: <label>
                <input type="password" name="password"/>
            </label><br/>
            <input class="button" type="submit" value="Зарегистрироваться ✅"/>
        </form>
    </fieldset>
    <a class="top-right" href="/login">
        <input class="button" type="button" value="Войти">
    </a>
</div>
</body>
</html>