<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Добавить пост</title>
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
    <legend>Добавить пост</legend>
    <form name="post" action="/users/${userId}/posts/add" method="post">
        Заголовок: <label>
            <input type="text" name="title"/>
        </label><br/>
        Содержание: <label>
            <input type="text" name="text"/>
        </label><br/>
        Дата создания: <label>
            <input type="date" name="dateCreate"/>
        </label><br/>
        <input type="hidden" name="userId" value="${userId}"/><br/>
        <input class="button" type="submit" value="Добавить ✅"/>
        <a href="/users/${userId}/posts">
            <input class="button" type="button" value="Отмена ❌">
        </a>
    </form>
</fieldset>
</body>
</html>