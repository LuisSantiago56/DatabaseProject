# DatabaseProject

PartsApp

Parts Demo App for Database access.

This simple app shows how to build a REST API for the backend of a database application using Spring. The Database engine is PostgreSQL. the application manages data from three tables:

The application is organized in three broad layers:

Controller - the main app module takes care to setup the routes for the REST API and calling the proper handler objects to process the request.
Handlers - the handler modules takes care of implementing the logic of each REST call. In this sense, a handler is a Facade for accessing a given operation on a data collection. Each object handles a particular type of request for a data collection (e.g. Parts). The handlers rely upon the Data Access Objects (DAOs) to extract data from the database. The handlers encode the responses to the client with JSON and provide the appropriate HTTP response code.
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