# CollinsonAPITest
Collinson RestAssured Cucumber BDD project for CityBikes Api testing

**CollinsonRestAssuredAssignment**: This is a sample API based automation project for Collinson using Rest Assured-Cucumber BDD with Java and Maven Framework.

API under test: http://api.citybik.es/v2/networks

The BDD scenarios are written in CityBike.feature file and the step definitions for it are present under (src\test\java\stepDefinitions\StepDefsIntegration.java) file
Steps to run the project : Clone the git repository:  https://github.com/adarda/CollinsonAPITest.git

**HOW TO RUN:**
Once downloaded we can run the following commands
1)	mvn clean test (to clean and run the tests)
2)	in case of any missing resource - run the mvn install (to install any missing files) (This is also trigger the cucumberrunner and our feature file would start executing) The above is way to run the feature via maven commands.
We can also run the feature file by importing the project in an IDE and then run the CucumberRunner.java file (\src\test\java\runners\CucumberRunner.java)

**Output**: After we run the tests we can see the output of the feature file in the console but we also have cucumber.htmlfile (target\cucumber.html) for the results
