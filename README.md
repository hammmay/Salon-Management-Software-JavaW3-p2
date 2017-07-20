# Salon Management Software

#### By Laura Hamilton

## Description

This application is a demonstration of CRUD - creating, reading, updating, and destroying Java objects that exist as a one-to-many relationship within a database. The page will allow users to create new stylists on a salon management page, add service details to that stylist, view all the stylists that were created, add new clients with contact details to those stylists, view all clients assigned to a stylist, update a stylist's services, update a client's contact information, and delete any record of a stylist or client.

## Code Specs

|Behavior - Plain English|Input|Output|
|---|---|---|
|On the homepage, a user adds a stylist using the "Add Stylist" button and they are taken to a success page that tells them the stylist was added and gives them the option to go back to the homepage or the option to look at a list of all the stylists|User enters "Stylist 1" in the "Stylist's Name" field|The user is taken to a success page letting them know the stylist was added|
|On the success page for a stylist addition, the user clicks on the "Return Home" link and is taken back to the homepage where the stylist they just added is listed|User clicks on "Return Home" after adding a stylist called "Stylist 1"|The user is taken to the homepage and sees Stylist 1 listed as a stylist|
|On the success page for a stylist addition, the user clicks on the "View All Stylists" link and is taken to a page where the stylist they just added is listed and any others that were already added|User clicks on "View All Stylists" after adding a stylist called "Stylist 1"|The user is taken to the all stylist page and sees Stylist 1 listed as a stylist|
|On the homepage, a user clicks on the name of a stylist and is taken to a page where they can see the name of the stylist and a list of the clients assigned to that stylist, if any have been added already, and is given the option to return home|User clicks on "Stylist 1"|The user is taken to the Stylist 1 page and a they see a blank list of clients and a link to return to the homepage|
|On the homepage, a user adds a new client to a stylist using the "Select a Stylist" drop down and using the "Add This Client" button after filling out the name field, and they are taken to a success page that tells them the client was added and gives them the option to go back to the homepage|User selects "Stylist 1" from the dropdown and enters "Client A" in the name field before pressing the "Add This Client" button|The user is taken to a success page letting them know the client was added and is given a link to return home|
|On the success page for a client addition, the user clicks on the "Return Home" link and is taken back to the homepage|User clicks on "Return Home" after adding a client called "Client A"|The user is taken to the homepage|
|On a client page, the user clicks on the "Delete This Client" button and is taken to a delete page that lists the name of the stylist the client was deleted from and a list of that stylist's current clients which is missing the client that was just deleted, and is given a link to go to the homepage|User clicks on a "Delete This Client" button|The user is taken to a new page displaying the stylist name the client was just removed from and displays the remaining client list, and a "Return Home" link is available|
|On a client page, a user updates the client name using the "Update Name" button and filling out the "Update Name of Client" field, and the name is automatically updated on the client's page|User is on a page where the client is named "Client A" and enters "Client B" in the "Update Name of Client" field before pressing the "Update Name" button|The name of the client is changed from "Client A" to "Client B"|
|On a stylist's page, a user clicks on the "Delete This Stylist" button and are taken back to the homepage|User clicks on a "Delete This Stylist" button on a stylist's page|The user is redirected to the homepage|

## Setup
|This application uses a database, so begin by creating this database using the following commands in PSQL|
|---|
|CREATE DATABASE hair_salon;|
|\c hair_salon;|
|CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);|
|CREATE TABLE clients (id serial PRIMARY KEY, name varchar, stylistId int);|

Once the table is set up, clone this repository. Run it through the terminal with the command $ gradle run. Once running, follow the listening path provided through the terminal and view it through your browser in localhost:
(Note: you must have the right programs installed on your computer already to run the program. Please refer to the Technologies Used section below for the program list)

## Technologies Used

Java
Gradle
JUnit
Spark
VelocityTemplateEngine

### Legal

Copyright (c) 2017 Laura Hamilton laurahamilton9@gmail.com

This software is licensed under the MIT license.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
