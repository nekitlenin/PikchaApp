<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Посты</title>
    <link rel="stylesheet" href="/resources/style.css"/>
</head>
<body>
<img class="logo-img-top" src="/resources/logo.png" alt="Логотип">
<div id="header">
    <h1>Профиль пользователя ${user.name}</h1>
</div>
<div id="content">
    <h3>Ваши публикации:</h3>
    <div class="right">
        <form action="/users/${userId}/posts" method="get">
            <p><label for="pageSize">Показать:</label>
                <select id="pageSize" name="pageSize">
                    <option value=5 <#if pageSize == 5>selected</#if>>5</option>
                    <option value=10 <#if pageSize == 10>selected</#if>>10</option>
                    <option value=15 <#if pageSize == 15>selected</#if>>15</option>
                    <option value=20 <#if pageSize == 20>selected</#if>>20</option>
                    <option value=-1 <#if pageSize == -1>selected</#if>>Все</option>
                </select>
                из ${totalPosts} &nbsp;&nbsp;&nbsp;&nbsp;

                <label for="page">Страница:</label>
                <select id="page" name="page">
                    <option value=0 <#if page == 0>selected</#if>>1</option>
                    <option value=1 <#if page == 1>selected</#if>>2</option>
                    <option value=2 <#if page == 2>selected</#if>>3</option>
                    <option value=-1 <#if page == -1>selected</#if>>Все</option>
                </select>
                из ${totalPages} &nbsp;&nbsp;&nbsp;&nbsp;

                <label for="sortType">Сортировать:</label>
                <select id="sortType" name="sortType">
                    <option value="default" <#if sortType == "default">selected</#if>>none</option>
                    <option value="date" <#if sortType == "date">selected</#if>>По дате</option>
                    <option value="title" <#if sortType == "title">selected</#if>>По заголовку</option>
                </select>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input class="button" type="submit" value="Применить">
            </p>
            <div class="error">
                <#if error?has_content>
                    <p>${error}</p>
                </#if>
            </div>
        </form>
    </div>
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
    <input class="button" type="submit" value="➕">
</a>
<a class="top-right" href="/users">
    <input class="button" type="submit" value="Админ-панель">
</a>
</body>
</html>
