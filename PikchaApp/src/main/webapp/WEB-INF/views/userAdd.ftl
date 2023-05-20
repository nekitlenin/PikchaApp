<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Добавить пользователя</title>
    <style>
        <#include "style.css" />
    </style>
</head>
<body>
<img class="logo-img-top" src="/resources/logo.png" alt="Логотип">
<div id="header">
    <h1>Добавить</h1>
</div>
<fieldset>
    <legend>Добавить пользователя</legend>
    <form name="user" action="/users/add" method="post">
        Имя: <label>
            <input type="text" name="name"/>
        </label><br/>
        Почта: <label>
            <input type="email" name="email"/>
        </label><br/>
        Пароль: <label>
            <input type="password" name="password"/>
        </label><br/>
        <input class="button" type="submit" value="Добавить ✅"/>
        <a href="/users">
            <input class="button" type="button" value="Отмена ❌">
        </a>
    </form>
</fieldset>
</body>
</html>
