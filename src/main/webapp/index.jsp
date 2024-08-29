<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Мои задачи</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h2 {
            font-size: 24px;
        }
        .board {
            display: flex;
            gap: 20px;
        }
        .column {
            background-color: white;
            padding: 10px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            flex: 1;
        }
        .column h3 {
            margin-top: 0;
            font-size: 18px;
        }
        .task {
            background-color: #f9f9f9;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 6px;
            margin-bottom: 10px;
        }
        .task .labels {
            display: flex;
            gap: 5px;
            margin-top: 10px;
        }
        .label {
            font-size: 12px;
            padding: 2px 6px;
            border-radius: 4px;
            color: white;
        }
        .label.domashnie-dela { background-color: #b399d6; }
        .label.otdyh { background-color: #e0c080; }
        .label.rabota { background-color: #8ecf7f; }
        .task img {
            border-radius: 50%;
            width: 20px;
            height: 20px;
            margin-right: 5px;
        }
    </style>
</head>
<body>

<h2>Мои задачи</h2>
<div class="board">
    <div class="column">
        <h3>Not started <span>(2)</span></h3>
        <div class="task">
            <p>Погулять с моти</p>
            <div class="labels">
                <span class="label domashnie-dela">Домашние дела</span>
                <span class="label otdyh">Отдых</span>
            </div>
        </div>
        <div class="task">
            <p>Провести лекцию</p>
            <div class="labels">
                <span class="label rabota">Работа</span>
            </div>
        </div>
    </div>
    <div class="column">
        <h3>In progress <span>(2)</span></h3>
        <div class="task">
            <p>Проверить проекты</p>
            <div class="labels">
                <img src="path/to/profile-pic.jpg" alt="Anton Kupreychik">
                <span class="label rabota">Работа</span>
                <span class="label domashnie-dela">Домашние дела</span>
            </div>
        </div>
        <div class="task">
            <p>Запустить робот-пылесос</p>
            <div class="labels">
                <span class="label domashnie-dela">Домашние дела</span>
                <span class="label otdyh">Отдых</span>
            </div>
        </div>
    </div>
    <div class="column">
        <h3>Done <span>(1)</span></h3>
        <div class="task">
            <p>Сделать задачу по работе</p>
            <div class="labels">
                <img src="path/to/profile-pic.jpg" alt="Anton Kupreychik">
                <span class="label domashnie-dela">Домашние дела</span>
            </div>
        </div>
    </div>
</div>

</body>
</html>