# AmaysimTestProject

* This Webdriver project demonstrates design and development of functional test using  page object pattern.

### Features covered ###  

1. Enable call forward
2. Disable call forward

### HOW To RUN THE TEST ### 

* Right click pom.xml and select Run As -> Maven test.
* Alternatively, Right click testng.xml (src/main/resources/testng.xml) and 
  select Run As -> TestNG Suite.

### Project details ###

It's a maven project with testng.xml test suite added as a dependency to pom.xml.File testng.xml has two test cases
and input test data configured.Tests configured to run on Chrome.

### Test class ###  

MySettingsTestcases.java

### Assumption ##
The test user has callforward disabled 

##TestData##
Test data is  taken in GetTestData.java class.

### Dependency ###
All the dependency like  ChromeDriver.exe are bundled in lib/ dir
