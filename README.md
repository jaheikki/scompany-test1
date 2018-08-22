# scompany-test1

This project demoes running Java having BDD style test case descriptions (offered by Cucumber Java rel2)

Guide to run test & get test report on your browser:
1. Install git, Java 8 and Maven 3
2. git clone https://github.com/jaheikki/scompany-test1.git
3. mvn clean install #or by tag:  mvn clean install -Dcucumber.options="--tags @numbers"
4. mvn allure:report #generate test report
5. mvn jetty:run #start web server locally
6. In browser: http://localhost:9899/ #should open test report main page 

Hint1: With VM option: -Dnumber_range_division_factor you can affect which part of numbers are read from file:
e.g. mvn clean install -Dcucumber.options="--tags @numbers" -Dnumber_range_division_factor=2 #value 2 is default

Hint2: With VM option: -Denv=<env> you can specify which env property file is used to read settings
e.g. mvn clean install -Dcucumber.options="--tags @numbers" -Denv=local #local is also the default 

Recommend editing this project in latest IntelliJ IDEA IDE with Cucumber java plugin. If not, you can find relevant files from following directories:
1. BDD/Gherkin style test case description: src/test/resources/acceptancetests/number-handling.feature

```
@numbers
@all
Feature: Java tests

  @numbers_1
  Scenario: print numbers to file
    Given test file numbers.txt should not exist
    When i print numbers 1 to 100 to file numbers.txt
    Then i print half of the numbers from file numbers.txt having 100 as last number
```
2. Test step definitions (Java code)  matching .feature file: src/test/java/teststepdefs/TestStepDefs.java

```
package teststepdefs;

import common.CommonVars;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static common.Common.printMethodName;


public class TestStepDefs {

    @Given("^test file (.*) should not exist$")
    public void testFileShouldNotExist(String filename) {
        printMethodName();

        Path path = Paths.get(filename);
        try {
            Files.delete(path);
            System.out.println("File "+filename+ " from previous run deleted successfully.");
        } catch (IOException e) {
            if (!Files.exists(path)) {
                System.out.println("File "+filename+ " from previous run does not exist, ok.");
            } else {
                throw new RuntimeException("Failed to delete "+filename+" from previous run!");
            }
        }
    }

    @When("^i print numbers (.*) to (.*) to file (.*)$")
    public void iWriteNumbersToFile(int firstNumber,int lastNumber, String filename) {
        printMethodName();

        Path path = Paths.get(filename);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (int i = firstNumber; i < lastNumber + 1; i++) {
                System.out.println(i);
                writer.write(Integer.toString(i));
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^i print half of the numbers from file (.*) having (.*) as last number$")
    public void iPrintHalfOfTheNumbersFromFile(String filename, int lastNumber) {
        printMethodName();

        try {
            Files.lines(Paths.get(filename)).limit(lastNumber / CommonVars.numberRangeDivisionFactor).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

```

The test report (Suites tab) should look like this:

 <img src="https://raw.githubusercontent.com/jaheikki/scompany-test1/master/test-report.png" width="600" height="300">

