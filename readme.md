
### Используемые технологии

- В данном проекте была применена clean архитектура с разбиением по модулям, как по слоям (app-data-domain). Это позволило правильно выстроить области видимости для данных слоёв.
- Presentation слой построен по принципу MVVM с использованием viewModel. Для передачи данных между view и viewModel использовался StateFlow. 
- Для получения данных из интернета исползовался retrofit, работа которого осуществляется через Use-Cases и репозиторий.
- Навигация между экранами осуществляется при помощи navigation component 
- Все стили для разных view прописывались через styles.xml, а строки через strings.xml - что позволяет проще локализовать приложение под другой язык
- Для DI использовался hilt, т.к. он позволяет удобно получать экземпляры viewModel, и в отличии от Koin сообщает об ошибках DI при компиляции а не в runtime



### Комментарии к выполнению

Реализовано:
- загрузка и отображение гифок по запросу в текстовое поле
- при клике на карточку гифку открывается страница с гифкой большого размера, и информацией о ней
- при долгом нажатии на гифку на страниуе с деталями, гифка сохраняется в галерею устройства
- во время загрузок крутится progress bar, а также реализован swipe-to-refresh для экрана поиска


### Демонстрация работы приложения 

Видеоролик, демонстрирующий работу приложения: https://disk.yandex.ru/i/J2wPwm3bmdSClA

