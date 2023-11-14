


Run example test by executing command from the root of the project folder:
- Linux/MacOS: ./gradlew clean test -Denv=desktop.chrome -DincludeGroups=ui.test.example
- Windows: ./gradlew.bat clean test -Denv="desktop.chrome" -DincludeGroups="ui.test.example"
- API: ./gradlew clean test -Denv=petstore.api -DincludeGroups=api.test.example





UI tests use Page Object Models Pattern
(https://martinfowler.com/bliki/PageObject.html)

(https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)

- The benefit is that if the UI changes for the page, the tests themselves don’t need to change, only the code within the page object needs to change. Subsequently, all changes to support that new UI are located in one place.




API tests use Client Object Models Pattern - basically same thing as UI tests

https://luizcostatech.medium.com/quick-test-reports-using-allure-testng-github-actions-6cc9eab66a2f
