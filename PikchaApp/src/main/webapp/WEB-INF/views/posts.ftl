<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Посты</title>
    <link rel="stylesheet" href="/resources/style.css" />
</head>
<body>
<img class="logo-img-top" src="/resources/logo.png" alt="Логотип">
<div id="header">
    <h1>Профиль пользователя ${user.name}</h1>
</div>
<div id="content">
    <h3>Ваши публикации:</h3>
    <br>
    <br>
    <br>
    <#list postList as post>
        <div class="post">
            <div class="post-title">${post.title}</div>
            <div class="post-content">${post.text}</div>
            <div class="post-date">${post.dateCreate}</div>
            <div class="post-actions">
                <div class="mini-menu">
                    <button class="mini-menu-button">...</button>
                    <div class="mini-menu-actions">
                        <a href="posts/${post.id}/update">
                            <button class="button">Изменить 🔄</button>
                        </a>
                        <a href="posts/${post.id}/delete">
                            <button class="button">Удалить ❌</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</div>
<a class="fixed-bottom" href="/users/${user.id}/posts/add">
    <input class="button" type="submit" value="Добавить пост">
</a>
<a class="top-right" href="/users">
    <input class="button" type="submit" value="Админ-панель">
</a>
</body>
</html>
