# Тестовое задание на позицию Junior java разработчика
## Условия задания:
Создать сервис, который обращается к сервису курсов валют, и отображает gif:
если курс по отношению к USD за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich
если ниже - отсюда https://giphy.com/search/broke
Ссылки
REST API курсов валют - https://docs.openexchangerates.org/
REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide
Must Have
Сервис на Spring Boot 2 + Java / Kotlin
Запросы приходят на HTTP endpoint (должен быть написан в соответствии с rest conventions), туда передается код валюты по отношению с которой сравнивается USD
Для взаимодействия с внешними сервисами используется Feign
Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки
На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)
Для сборки должен использоваться Gradle
Результатом выполнения должен быть репо на GitHub с инструкцией по запуску
Nice to Have
Сборка и запуск Docker контейнера с этим сервисом.

## Как собрать и запустить
Выполните команды по очереди:
1) ```cd your_work_dir```

2) ```git clone https://github.com/Eldar1163/CurrencyTracker.git```

3) ```cd CurrencyTracker```

4) ```./gradlew bootJar```

5) ```docker build --tag currencytracker .```

6) ```docker run -p 8080:8080 currencytracker```

После этого приложение будет запущено и доступно по адресу http://localhost:8080


Запросы можно сделать даже из браузера. С сервисом Giphy.com могут быть проблемы с доступом из России, поэтому может понадобиться VPN.

## Примеры запросов

http://localhost:8080/api/check/default

http://localhost:8080/api/check?currency_code=AZN
