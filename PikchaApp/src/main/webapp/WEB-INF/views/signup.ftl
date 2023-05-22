<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Регистрация</title>
    <link rel="stylesheet" href="/resources/style.css" />
</head>
<body>
<div class="container">
    <img class="logo-img" src="/resources/logo.png" alt="Логотип">
    <h1>Регистрация</h1>
    <fieldset>
        <form name="user" action="/signup" method="post">
            <div class="form-group">
                <label for="name" class="label">Имя:</label>
                <input id="name" class="input-field" type="text" name="name" placeholder="Ваше имя"/>
            </div>
            <div class="form-group">
                <label for="email" class="label">Email:</label>
                <input id="email" class="input-field" type="email" name="email" placeholder="Ваша почта"/>
            </div>
            <div class="form-group">
                <label for="password" class="label">Пароль:</label>
                <input id="password" class="input-field" type="password" name="password" placeholder="Ваш пароль"/>
            </div>
            <div class="form-group center">
                <input class="button" type="submit" value="Зарегистрироваться ✅"/>
            </div>
        </form>
    </fieldset>
    <a class="top-right" href="/login">
        <input class="button" type="button" value="Войти">
    </a>
</div>
</body>
</html>