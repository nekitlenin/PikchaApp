<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Редактор</title>
    <style>
        <#include "style.css" />
    </style>
</head>
<body>
<img class="logo-img-top" src="/resources/logo.png" alt="Логотип">
<br>
<fieldset>
    <legend>Редактировать пользователей</legend>
    <form name="user" action="/users/update" method="post">
        Идентификатор: <label>
            <input type="number" name="id" value="${user.id}" readonly/>
        </label><br/>
        Имя: <label>
            <input type="text" name="name" value="${user.name}"/>
        </label><br/>
        Почта: <label>
            <input type="email" name="email" value="${user.email}"/>
        </label><br/>
        Пароль: <label>
            <input type="password" name="password" value="${user.password}"/>
        </label><br/>
        <input class="button" type="submit" value="Изменить 🔄"/>
        <a href="/users">
            <input class="button" type="button" value="Отмена ❌">
        </a>
    </form>
</fieldset>
<br/>
</body>
</html>
