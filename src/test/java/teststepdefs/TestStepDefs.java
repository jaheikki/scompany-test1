package teststepdefs;

import common.CommonVars;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static common.Common.printMethodName;


public class TestStepDefs {

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
            Files.lines(Paths.get(filename)).limit(lastNumber/ CommonVars.numberRangeDivisionFactor).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

