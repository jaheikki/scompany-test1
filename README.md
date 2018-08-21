# scompany-test1

Guide to run test & get test report on your browser:
1. git clone https://github.com/jaheikki/scompany-test1.git
2. mvn clean install #or by tag:  mvn clean install -Dcucumber.options="--tags @numbers
3. mvn allure:report #generate test report
4. mvn jetty:run #start web server locally
5. In browser: http://localhost:9899/ #should open test report main page 

