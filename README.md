# PhoneArena
----
M. Umar Saleem, Nathan Robinson, Tyler Berndt, Brendan McAntosh

Mobile phone comparison application

## Description
----
Project Phone Feud is a native applet designed to manage data for phones, users, and allow for users to compare phones, so that they can make meaningful ratings for each product. The goal of the applet is to provide a convenient way for users to compare phones, and make easy selections. 
Our program has three modules. The first module allows for access to the database via login and allows for the creation of a new user. Based on login name, the login page leads admins to an access page that allows them view and edit all tables in the database. Users are lead to a page that allows them enquire the features of a specific phone. Using the third module users can rate different devices. 
2. SYSTEM STUDY
2.1. Proposed system 
The system is very simple in design and to implement. The system requires very low system resources and the system will work in almost all configurations. It has got following features:
●	Ensure data accuracy.
●	Records are efficiently maintained by DBMS.
●	DBMS also provides security for the information.
●	Any person across the world, having internet can access this service.
●	Features of phones can be compared very easily.
●	Users can also rate their favorite phones.
2.2. Introduction about the front end (JAVA)
This proposed software is going to be development using the latest technology from Java and it is the software that connects information, people, systems, and devices. It spans clients, servers, and developer tools, consists of:
●	The Java Framework used for building and running all kinds of software, including Web-based applications, smart client applications, Mobile applications etc.
●	Development tools, such as Net Beans, which provides an integrated development environment (IDE) for maximizing development productivity with the Java  Framework.
2.3. Introduction about the back end (MySQL)
MySQL is comprehensive, integrated data management and analysis software that enables organizations to reliably manage mission-critical information and confidently run today’s increasingly complex business applications. MySQL allows companies to gain greater insight from their business information and achieve faster results for a competitive advantage.
●	MySQL is the fastest growing Database and Business Intelligence vendor.
●	MySQL is more secure than Oracle. Since July 2003 more than 100 critical Oracle database security vulnerabilities have been identified, compared to ZERO for MySQL for that period.
3. SYSTEM SPECIFICATION 
3.1. Hardware Requirements:
●	PC with intel core processor(or more config).
●	512 MB RAM or above.
●	40 GB Hard Disk or above.
3.2. Software Requirements:
●	Operating system                   : Any running JVM
●	Front end                                : Java 8.0
●	Platform                                  : ASP.NET (.NET web platform 3.0 or above)
●	IDE 				    : Net Beans
●	Back end                                : MySQL
4. DATABASE DESIGN 
4.1. Conceptual design
a.)   Requirement Analysis: 
What data is needed?
List of Entities:
●	phone
●	rating
●	search
●	comparison
●	login
List of attributes:
phone:
1.	make
2.	model
3.	rating
4.	price
Comparison:
1.	rating
2.	price
3.	make
4.	model
login information:
1.	username
2.	password

b.) ER-MODEL:
 

4.2. Logical design:
1. phone: Keeps record of phones.

.S.no	Field name	Data type	Description	Constraints
1	make	text	Phone id	
2	model	text	Model of phone	Primary key
3	price	text	Price for phone	
4	RAM	text	Amount of ram	
5	screen	text	Screen size of phone	
6	mem	text	Memory capacity	
7	avgRating	Integer	The rating for phone	
CREATE TABLE `phone` (
  `make` text,
  `model` varchar(25) NOT NULL,
  `price` text,
  `ram` text,
  `screen` text,
  `mem` text,
  `avgRating` int(11) DEFAULT NULL,
  PRIMARY KEY (`model`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

2. rating: Keeps record of the rating of phones. 
S.no	Field name	Data type	Description	Constraints
1	id	Integer	The index for all ratings	Primary key
2	make	text	The make of the rated phone	
2	model	text	The model of the rated phone	
3	username	text	Identifies who has rated the phone	
4	userRating	Integer	The rating that the user gives the phone	
Schema definition: 
CREATE TABLE `rating` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `make` text,
  `model` text,
  `username` text,
  `userRating` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=801 DEFAULT CHARSET=utf8;

3. users: keep record of users
S.no	Field name	Data type	Description	Constraints
1	username	text	Username of member	Primary key
2	password	text	Password of the user	
3	firstname	text	First name of the user	
4	lastname	text	Last name of the user	
5	email	text	The users email	
6	phoneNum	text	The users phone number	
7	createTime	timestamp	The time the record was created	
Schema definition: 
CREATE TABLE `users` (
  `username` varchar(25) NOT NULL,
  `password` text,
  `firstname` text,
  `lastname` text,
  `email` text,
  `phoneNum` text,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



5. IMPLEMENTATION
Login Screen to allow access to the database as a admin or user base on login name credentials, because username is a primary key for Users.

If a user does not exist in the database they cannot connect unless they register as a new user first on this screen (via login screen “Register” button)

If user is identified as an admin they are granted access to the database and the ability to access and edit any tuple  of any table: 
 

The next three pages are accessible via buttons in the bottom left of each screen. Each provides search, scroll, insert, delete, and update function for each of the three tables:



If you are signed in as a user, instead you are granted limited access to the phones and rating tables, allowing for you to browse phones based on model and search, insert, delete and update rating that belong to you only:
 


6. ADDITIONAL COMMENTS (optional)
I am happy with the basic functions I implemented for the database. They are fast, effective, and require only a basic implementation my SQL statements. I wish we had been able to compare phones side-by-side in a table or combo box, 
