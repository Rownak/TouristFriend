#Tourist Friend

**Project for Therap Java Fest-2014**

**Project Proposal and User Guidelines**

##How to Deploy

 **Step 1 (Clone)**
 
Clone this Repository to your computer or Download the master zip file

**Step 2 (Setup Environment)**

To Deploy this project you need the following environment on your computer

* Netbeans 8.0  
* Oracle JDK 1.8
* Apache Tomcat 8.0.3
* MySQL 5.6
* MySQL Connector (JDBC) [version: 5.1.23]
* ADT Bundle(android development tools)
* Google-play-services_lib

**Step 3 (Setup Database)**
Create a Database named **touristfriend_db** on your MySQL

After creating the Database import the below SQL File to create and seed the tables



[Download Database SQL File](https://github.com/sajjadIslam2619/TouristFriend/tree/master/Servlets/Resources)


**Step 4 (Start Server)**

Start Apache Tomcat and MySQL

**Step 5 (Import project)**

Import the **TouristFriend_BackEnd**  project in Netbeans 

Import the **google-play-services_lib** & **MainProjectTherapTest** (from android folder) in eclipse 

In eclipse AndroidManifest.xml change the android:value (you can get the api key for your device from google api console)

    <meta-data
            android:name="com.google.android.maps.v2.API_KEY"
            android:value="AIzaSyAKjukdexxEHJby_vQE7HbkSIG3Jr-oSys" />
  
In Config.java file change SERVER_URL and set your SERVER_URL address

    public class Config {
	
	public static String SERVER_URL = "http://192.168.2.108:8084/TouristFriend_BackEnd/";

}
**Step 6 (Setup Database Username and Password)**

In Servlet
TouristFriend_BackEnd >>default package>> hibernate.cfg.xml

you have to set mysql username and password 

     <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/touristfriend_db?zeroDateTimeBehavior=convertToNull</property>
    <property name="hibernate.connection.username">root</property>
    <property name="hibernate.connection.password"></property>
Sample Demo Login Details

email : rownak.sust@gmail.com

password : 12345

#Development Credit
**SUST_ClassNotFound**
* Ahnaf Farhan (Rownak)
* K.M.Sajjadul Islam

Department of Computer Science and Engineering,Shahjalal University of Science and Technology,Sylhet
