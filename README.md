# DatabaseProject

Disaster Relief

Disaster Relief Demo App for Database access.

This simple app shows how to build a REST API for the backend of a database application using Spring. The Database engine is PostgreSQL. The data is managed from six tables which are Category, Resources, Customer, Supplier, Town and Region
The Controller, Handlers and DAOs organize the data.

Controller - the main class runs the Spring framework.
Handlers - the handler communicates with the data base.The handlers rely upon the Data Access Objects (DAOs) to extract data from the database. The handlers encode the responses to the client with JSON and provide the appropriate HTTP response code.
DAOs - the Data Access Objects (DAOs) take care of moving data in and out of the database engine by making SQL queries and wrapping the results in the objects and object list of appropriate types.

Requirements
You need the following software installed to run this application:

PostgreSQL - database engine
Pyscopg2 - library to connect to PostgreSQL form Python
PgAdmin3 - app to manage the databases
Spring - web bases framework to implement the REST API.

This App was made by:
Elnois Norat : elnois.norat@upr.edu
Stephanie Garcia : stephanie.garcia8@upr.edu
Luis Santiago : luis.santiago56@upr.edu

Instructions
For using this App you will need to run "As Java Application" the main class called MainApp.java. After this you will open your internet browser and type as URL localhost:8080 for accessing the main page of the App. To see what other routes you can use to access the information of the different tables please read the ER Report to see the different URLs.
