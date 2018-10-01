You Need:
•	Java 8 (JDK)
•	Spring Boot 1.5.2.RELEASE
•	Maven 3.3

1.	On your Eclipse IDE, go into Window > Preferences > Java > Installed JREs > and check your installed JREs. You should have an entry with a JDK 1.8 there.

2.	Select the Execution Env as show below. Click OK

3.	Then Right-Click on your Project -> Maven -> Update Project 

4.  Right Click Maven project  and Execute ‘Maven Install’,  rebuild

5.  Select Java 8 JDK in Execution Envoriment in Eclipse context menu : Window >> Preferences

6.  Install plug-in HSQLDB in eclipse.

7.  Change configuration file: spring-boot-demo/src/main/resources/application.properties
    set local embedded data base and set password and login for data base acess;
    
8.  Change database type, change local comments of the file:

    avenueCode / spring-boot-demo / src / main / resources / persistence.xml