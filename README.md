
### Please make sure you update version of the below<br>
Java version:11+<br>
Maven version: 3.6.3<br>
Git version 2.23.0 or higher<br>
Intellij Plugins: Cucumber for Java
                  Gherkin

### Project settings: To generate cummumber-html-report suscesully make sure you have have the below settings:

### Step1:
Mac OS: InteliJ IDEA ->Preference->Build,Execution,Deployment->Compiler->Java complier->Project bytecode version select 11 on drop down  then Target bytecode version select 11 then click OK<br>
Windows OS: File-> Settings-> Build, Execution, Deployment->Compiler->Java compiler->Project bytecode version select 11 on drop down  then Target bytecode version select 11 then click OK

### Step2:
Mac OS: file->Project Structure->Project->select 11 Project SDK and select 11 Project language level 11 Then click on modules->language level select 11 then click on SDKs and select 11 finally click on OK<br>
Note: After completing your settings do not forget re start your IntelliJ.

### Use this command to run the tests:
mvn clean test verify -Dcucumber.options="--tags @Login" -Dbrowser=chrome -DtestType=UI 

### Finally, If you run from runners class, use this command to generate advance cucumber report:
mvn verify

### Hooks with the tags
 @Before(‘@Web’)
 @Before(@dev,@wip) 
 @Before(@dev,~@wip)
 @After(‘@Web’)
 @After(@dev,@wip) 
 @After(@dev,~@wip)