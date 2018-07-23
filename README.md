

# BankTranByUserPOC using Spring Boot + Spring Security + JPA+Hibernate+REST API 

1.Prerequisites:- Java 8 +Maven+MySql DataBase+scripts.sql<br>
2.execute the queries on MySql command Line or open MySql Workbench and browse the script<br>
by clicking on the "file' menu and click on 'Run SQL Script'.<br>
3.Download the source code from Github.<br>
4.Run  "mvn clean install" from BankUserApplication and BankMetaDataApplication.<br>
5.Once jars are generated in the target folder, please run the jars by using the commands:<br>

6.App1 -> target -> java -jar BankUserApplication-0.0.1-SNAPSHOT.jar<br>
	App2 -> target -> java -jar BankMetaDataApplication-0.0.1-SNAPSHOT.jar<br>

7.Both applications are running using embedded tomcat.<br>
8.Open PostMan tool and browse the below mentioned URL's<br>
	http://localhost:8080/signup/signUpUser<br>
	http://localhost:8070/bank/getAccount<br>
9.Assumptions:<br>
	Both applications should be in same network, firewall <br>shouldnt block the maven repo to download the dependencies
