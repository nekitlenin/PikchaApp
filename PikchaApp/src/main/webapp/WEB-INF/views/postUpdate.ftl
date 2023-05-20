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
<fieldset>
    <legend>Редактировать пост</legend>
    <form name="user" action="/users/${userId}/posts/${post.id}/update" method="post">
        Заголовок: <label>
            <input type="text" name="title" value="${post.title}"/>
        </label><br/>
        Содержание: <label>
            <input type="text" name="text" value="${post.text}"/>
        </label><br/>
        <input class="button" type="submit" value="Изменить ✅"/>
        <a href="/users/${userId}/posts">
            <input class="button" type="button" value="Отмена ❌">
        </a>
    </form>
</fieldset>
<br/>
</body>
</html>
