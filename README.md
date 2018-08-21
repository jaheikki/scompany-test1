# scompany-test1

This project demoes running Java having BDD style test case descriptions (offered by Cucumber Java rel2)
Guide to run test & get test report on your browser:
1. git clone https://github.com/jaheikki/scompany-test1.git
2. mvn clean install #or by tag:  mvn clean install -Dcucumber.options="--tags @numbers
3. mvn allure:report #generate test report
4. mvn jetty:run #start web server locally
5. In browser: http://localhost:9899/ #should open test report main page 

Recommend editing this project in latest IntelliJIdea IDE with Cucumber java plugin. If not, you can find relevant files from following directories:
1. BDD/Gherkin style test case description: src/test/resources/acceptancetests/number-handling.feature
2. Test step definitions (Java code)  matching .feature file: src/test/java/teststepdefs/TestStepDefs.java

The test report (Suites tab) should look like this:

 <img src="https://raw.githubusercontent.com/jaheikki/scompany-test1/master/test-report.png" width="600" height="300">

