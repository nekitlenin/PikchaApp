<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Добавить пост</title>
    <link rel="stylesheet" href="/resources/style.css"/>
</head>
<body>
<img class="logo-img-top" src="/resources/logo.png" alt="Логотип">
<fieldset>
    <legend><h1>Добавить пост</h1></legend>
    <form class="form" name="post" action="/users/${userId}/posts/add" method="post">
        <div class="form-group">
            <label class="label">Заголовок:</label>
            <input class="input-field" type="text" name="title"/>
        </div>
        <div class="form-group">
            <label class="label">Содержание:</label>
            <input class="input-field" type="text" name="text"/>
        </div>
        <input class="button" type="submit" value="Добавить ✅"/>
        <a href="/users/${userId}/posts">
            <input class="button" type="button" value="Отмена ❌">
        </a>
    </form>
</fieldset>
</body>
</html>
