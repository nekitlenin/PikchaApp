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
    <form class="form" name="user" action="/users/update" method="post">
        <div class="form-group">
            <label class="label">Идентификатор:</label>
            <input class="input-field" type="number" name="id" value="${user.id}" readonly/>
        </div>
        <div class="form-group">
            <label class="label">Имя:</label>
            <input class="input-field" type="text" name="name" value="${user.name}"/>
        </div>
        <div class="form-group">
            <label class="label">Почта:</label>
            <input class="input-field" type="email" name="email" value="${user.email}"/>
        </div>
        <div class="form-group">
            <label class="label">Пароль:</label>
            <input class="input-field" type="password" name="password" value="${user.password}"/>
        </div>
        <input class="button" type="submit" value="Изменить 🔄"/>
        <a href="/users">
            <input class="button" type="button" value="Отмена ❌">
        </a>
    </form>
</fieldset>
</body>
</html>
