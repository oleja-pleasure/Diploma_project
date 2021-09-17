## Дипломный проект по курсу по автоматизации тестирования от qa.guru  
В проекте представлены автотесты:  
* UI тесты на главную страницу tinkoff.ru
* API тесты на reqres.in
* UI тест на Android приложение Wikipedia  
Автотесты реализованы с использованием технологий:  
Java<img src="images/logo/JAVA.svg" width="40" height="40">, Junit5<img src="images/logo/Junit5.svg" width="40" height="40">, Gradle<img src="images/logo/Gradle.svg" width="40" height="40">, Selenide<img src="images/logo/Selenide.svg" width="40" height="40">, Rest-Assured, IntelliJ IDEA Appium  
VCS - Github<img src="images/logo/GitHub.svg" width="40" height="40">  
Запуск и прогон автотестов - Jenkins<img src="images/logo/Jenkins.svg" width="40" height="40">, Selenoid<img src="images/logo/Selenoid.svg" width="40" height="40">, BrowserStack  
Отчетность - Allure Report <img src="images/logo/Allure Report.svg" width="40" height="40">  
Нотификация - Telegram<img src="images/logo/Telegram.svg" width="40" height="40">  
TMS - Allure TestOps<img src="images/logo/Allure TestOps.svg" width="40" height="40">  
Task managment system - Atlassian Jira  

### Запуск джобы в Jenkins  
  
![JenkinsJob](/images/JenkinsJob.jpg)  
  
Команда запуска тестов:  
> clean test -Dserver=${SERVER} -Dlogin=${LOGIN} -Dpassword=${PASS}  

TESTS - тип запускаемых тестов (web/api/mobile)  
SERVER - удаленная машина для запуска тестов (Selenoid/BrowserStack)  
LOGIN - логин от Selenoid/BrowserStack  
PASS - пароль от Selenoid/BrowserStack  

### Автотесты для главной страницы tinkoff.ru прогоняются в Selenoid, для android приложения Wikipedia - в BrowserStack  
  
![Selenoid1](/images/Selenoid1.gif)  
  
(видео прохождения одного из тестов)  
### По результатам прогона формируется Allure отчет  
В Allure отчете к каждому из тестов (кроме API) прикрепляются:
* скриншот последней проверки
* код страницы
* логи браузера (только web)
* видео прохождения теста  
  
![AllureReport](/images/AllureReport.jpg)  


### В Telegram приходят уведомления с результатами прохождения автотестов  
  
![telegramNotification](/images/telegramNotification.jpg)
  
### После прогона отчет и автотесты добавляются в Allure TestOps  
  
![TestOps2](/images/TestOps2.jpg)  
![TestOps](/images/TestOps.jpg) 
  
### В Allure TestOps хранятся как ручные, так и автоматизированные тесты  

### В тест-кейсах отображаются связанные таски из Jira  