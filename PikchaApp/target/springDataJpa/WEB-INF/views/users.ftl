<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователи</title>
    <link rel="stylesheet" href="/resources/style.css" />
</head>
<body>
<img class="logo-img-top" src="/resources/logo.png" alt="Логотип">
<div id="header">
    <h1>Админ-панель</h1>
</div>
<div id="content">
    <table class="datatable">
        <tr>
            <td>Идентификатор</td>
            <td>Имя</td>
            <td>Почта</td>
            <td>Действие</td>
        </tr>
        <h3>Список пользователей:</h3>
        <#list userList as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>
                    <a href="/users/${user.id}/posts">
                        <button class="button">Посты</button>
                    </a>
                    <a href="/users/update/${user.id}">
                        <button class="button">Изменить 🔄</button>
                    </a>
                    <a href="/users/delete/${user.id}">
                        <button class="button">Удалить ❌</button>
                    </a>
                </td>
            </tr>
        </#list>
    </table>
</div>

<a class="top-right" href="/users/add">
    <input class="button" type="submit" value="Добавить пользователя">
</a>
</body>
</html>
