## Дипломный проект по курсу по автоматизации тестирования от qa.guru  
В проекте представлены автотесты:  
* UI тесты на главную страницу tinkoff.ru
* API тесты на reqres.in
* UI тест на Android приложение Wikipedia  
В проекте использованы следующие технологии:  
<img src="images/logo/JAVA.svg" width="40" height="40"> | <img src="images/logo/Junit5.svg" width="40" height="40"> | <img src="images/logo/Gradle.svg" width="40" height="40"> | <img src="images/logo/Selenide.svg" width="40" height="40"> | <img src="images/logo/Rest-Assured.svg" width="40" height="40"> | <img src="images/logo/Intelij_IDEA.svg" width="40" height="40"> | <img src="images/logo/Appium.svg" width="40" height="40"> | <img src="images/logo/GitHub.svg" width="40" height="40"> | <img src="images/logo/Jenkins.svg" width="40" height="40"> | <img src="images/logo/Selenoid.svg" width="40" height="40"> | <img src="images/logo/Browserstack.svg" width="40" height="40"> | <img src="images/logo/Allure Report.svg" width="40" height="40"> | <img src="images/logo/Telegram.svg" width="40" height="40"> | <img src="images/logo/Allure TestOps.svg" width="40" height="40"> | <img src="images/logo/Jira.svg" width="40" height="40">  
--- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ---
Java | Junit5 | Gradle | Selenide | Rest-Assured | IntelliJ IDEA | Appium | Github |  Jenkins | Selenoid | BrowserStack | Allure Report | Telegram | AlLure TestOps | Atlassian Jira
### Запуск джобы в Jenkins  
  
![JenkinsJob](/images/JenkinsJob.jpg)  
  
Команда запуска тестов:  
> clean ${TESTS} -Dserver=${SERVER} -Dlogin=${LOGIN} -Dpassword=${PASS} -Dthreads=${THREADS}  

TESTS - тип запускаемых тестов (web/api/mobile)  
SERVER - удаленная машина для запуска тестов (Selenoid/BrowserStack)  
LOGIN - логин от Selenoid/BrowserStack  
PASS - пароль от Selenoid/BrowserStack  
THREADS - количество потоков

### Автотесты для главной страницы tinkoff.ru прогоняются в Selenoid, для android приложения Wikipedia - в BrowserStack  
  
![Selenoid1](/images/Selenoid1.gif)  
  
(видео прохождения теста в Selenoid)  
  
![BrowserStack1](/images/BrowserStack1.gif)  
  
(видео прохождения теста в BrowserStack)  
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
   
### В тасках Jira отображаются привязанные тест-кейсы и лончи из Allure TestOps  
![Jira1](/images/Jira1.jpg) 