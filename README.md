# Automation_Yauheni_Vysotski

yauhenivysotski@MacBook-Air-Yauheni Automation_Yauheni_Vysotski % mvn versions:display-dependency-updates
[INFO] Scanning for projects...
[INFO]
[INFO] --------------< org.example:Automation_Yauheni_Vysotski >---------------
[INFO] Building Automation_Yauheni_Vysotski 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- versions:2.16.2:display-dependency-updates (default-cli) @ Automation_Yauheni_Vysotski ---
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ............... 4.15.0 -> 4.16.1
[INFO]   org.testng:testng ..................................... 7.8.0 -> 7.9.0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.467 s
[INFO] Finished at: 2024-01-01T12:48:50+01:00
[INFO] ------------------------------------------------------------------------


yauhenivysotski@MacBook-Air-Yauheni Automation_Yauheni_Vysotski % mvn clean test -Dsuite=Homework10 -Dconfig=saucedemo
[INFO] Scanning for projects...
[INFO]
[INFO] --------------< org.example:Automation_Yauheni_Vysotski >---------------
[INFO] Building Automation_Yauheni_Vysotski 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- clean:3.2.0:clean (default-clean) @ Automation_Yauheni_Vysotski ---
[INFO] Deleting /Users/yauhenivysotski/Documents/java/qa projects/Automation_Yauheni_Vysotski/target
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ Automation_Yauheni_Vysotski ---
[INFO] Copying 2 resources from src/main/resources to target/classes
[INFO]
[INFO] --- compiler:3.11.0:compile (default-compile) @ Automation_Yauheni_Vysotski ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 25 source files with javac [debug target 11] to target/classes
[WARNING] system modules path not set in conjunction with -source 11
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ Automation_Yauheni_Vysotski ---
[INFO] Copying 6 resources from src/test/resources to target/test-classes
[INFO]
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ Automation_Yauheni_Vysotski ---
[INFO] Changes detected - recompiling the module! :dependency
[INFO] Compiling 16 source files with javac [debug target 11] to target/test-classes
[WARNING] system modules path not set in conjunction with -source 11
[INFO]
[INFO] --- surefire:3.0.0-M4:test (default-test) @ Automation_Yauheni_Vysotski ---
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running TestSuite
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
янв. 01, 2024 12:59:42 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 120, returning the closest version; found: 119; Please update to a Selenium version that supports CDP version 120
Enter in :: [[ChromeDriver: chrome on mac (bf0398e82dab5a37f3e43c399bf35720)] -> id: user-name], next values :: [standard_user]
Enter in :: [[ChromeDriver: chrome on mac (bf0398e82dab5a37f3e43c399bf35720)] -> name: password], next values :: [secret_sauce]
Click on element :: [[ChromeDriver: chrome on mac (bf0398e82dab5a37f3e43c399bf35720)] -> css selector: input[value='Login']]
Enter in :: [[ChromeDriver: chrome on mac (bf0398e82dab5a37f3e43c399bf35720)] -> id: user-name], next values :: [standard_user]
Enter in :: [[ChromeDriver: chrome on mac (bf0398e82dab5a37f3e43c399bf35720)] -> name: password], next values :: [secret_sauce]
Click on element :: [[ChromeDriver: chrome on mac (bf0398e82dab5a37f3e43c399bf35720)] -> css selector: input[value='Login']]
Hello i'am finished with ::PropertyTests
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 8.31 s - in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.973 s
[INFO] Finished at: 2024-01-01T12:59:49+01:00
[INFO] ------------------------------------------------------------------------
