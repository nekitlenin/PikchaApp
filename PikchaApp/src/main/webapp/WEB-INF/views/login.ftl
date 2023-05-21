<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Войти</title>
    <style>
        <#include "style.css" />
    </style>
</head>
<body>
<div class="container">
    <img class="logo-img" src="/resources/logo.png" alt="Логотип">
    <h1>Вход</h1>
    <fieldset>
        <form class="form" name="user" action="/login" method="post">
            <div class="form-group">
                <label class="label">Email:</label>
                <input class="input-field" type="email" name="email"/>
            </div>
            <div class="form-group">
                <label class="label">Пароль:</label>
                <input class="input-field" type="password" name="password"/>
            </div>
            <div class="form-group center">
                <input class="button" type="submit" value="Войти ✅"/>
            </div>
        </form>
        <div class="error">
            <#if error?has_content>
                <p>${error}</p>
            </#if>
        </div>
    </fieldset>
    <a class="top-right" href="/signup">
        <input class="button" type="submit" value="Зарегистрироваться">
    </a>
</div>
</body>
</html>