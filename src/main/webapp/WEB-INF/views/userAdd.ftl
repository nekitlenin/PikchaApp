<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Добавить пользователя</title>
    <link rel="stylesheet" href="/resources/style.css" />
</head>
<body>
<img class="logo-img-top" src="/resources/logo.png" alt="Логотип">
<div id="header">
    <h1>Добавить</h1>
</div>
<fieldset>
    <legend>Добавить пользователя</legend>
    <form class="form" name="user" action="/users/add" method="post">
        <div class="form-group">
            <label class="label">Имя:</label>
            <input class="input-field" type="text" name="name"/>
        </div>
        <div class="form-group">
            <label class="label">Почта:</label>
            <input class="input-field" type="email" name="email"/>
        </div>
        <div class="form-group">
            <label class="label">Пароль:</label>
            <input class="input-field" type="password" name="password"/>
        </div>
        <input class="button" type="submit" value="Добавить ✅"/>
        <a href="/users">
            <input class="button" type="button" value="Отмена ❌">
        </a>
    </form>
</fieldset>
</body>
</html>
