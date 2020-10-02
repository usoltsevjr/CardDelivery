#### Проверка сборки

# Домашнее задание к занятию «2.2. Selenide»

## Задача №1 - Заказ доставки карты

Вам необходимо автоматизировать тестирование формы заказа доставки карты:

![](pic/order.png)

Требования к содержимому полей:
1. Город - [один из административных центров субъектов РФ](https://ru.wikipedia.org/wiki/%D0%90%D0%B4%D0%BC%D0%B8%D0%BD%D0%B8%D1%81%D1%82%D1%80%D0%B0%D1%82%D0%B8%D0%B2%D0%BD%D1%8B%D0%B5_%D1%86%D0%B5%D0%BD%D1%82%D1%80%D1%8B_%D1%81%D1%83%D0%B1%D1%8A%D0%B5%D0%BA%D1%82%D0%BE%D0%B2_%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D0%B9%D1%81%D0%BA%D0%BE%D0%B9_%D0%A4%D0%B5%D0%B4%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D0%B8)
1. Дата - не ранее трёх дней с текущей даты
1. Поле Фамилия и имя - разрешены только русские буквы, дефисы и пробелы
1. Поле телефон - только цифры (11 цифр), символ + (на первом месте)
1. Флажок согласия должен быть выставлен

Тестируемая функциональность: отправка формы.

Поля Город и Дата заполняются через прямой ввод значений (без использования выбора из выпадающего списка и всплывающего календаря).

Условия: если все поля заполнены корректно, то форма переходит в состояние "Загрузки":

![](pic/loading.png)

Важно: состояние загрузки не должно длиться более 15 секунд.

После успешной отправки формы (завершения бронирования) появится всплывающее окно об успешном завершении бронирования:

![](pic/popup.png)

Вам необходимо самостоятельно изучить элементы на странице, чтобы подобрать правильные селекторы. Обратите внимание, что элементы могут быть как скрыты, так и динамически добавляться/удаляться из DOM.