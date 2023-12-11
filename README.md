# Agile (Project Management System)
## Project Goal

The goal of the Agile project is to develop a comprehensive project management system focused on flexibility, 
efficiency, and ease of team collaboration. The system is designed for organizations and teams of all 
sizes that need a tool to plan, track and manage projects and tasks in real time.

## Scope

The Agile system is designed as a web-based application that supports multiple users 
with different access levels and roles in a project. It provides functionality 
to create and manage projects, assign tasks, track progress, communicate between 
participants and analyze performance.

The system will be useful in various business areas including IT, construction, 
education, marketing and many other areas where centralized project and task management is important.

## Core Functions

- Project Management: Create, edit and delete projects, assign roles to participants.
- Task Management: Create, assign and track tasks within projects.
- Communication: Messaging and notifications to ensure effective communication within the team.
- Reporting and analytics: Generate reports and analytics on the progress of projects and tasks.
- Security and Access: Access is limited based on user roles and authorizations.

## Technologies

The project is implemented using Java and Spring Framework for backend and SQL for database management. 
One of the modern JavaScript frameworks (React, Angular or Vue) will be used for the frontend.

## System Architecture

#### Architecture Overview

The Agile system is built on a client-server model, where the backend is implemented in Java using Spring Framework and the frontend is implemented on one of the modern JavaScript frameworks (e.g. React, Angular or Vue.js). The system provides interaction between the client and the server through a RESTful API.

#### System components
1. backend (Server Part):
- Based on Spring Boot for easy customization and deployment.
- Spring Security is used for authentication and authorization.
- Spring Data JPA for interacting with the database.

2.	Frontend (Client Part) [To be developed in the future]

3. Database:
- Using SQL database (MySQL) to store data about users, projects, tasks and other entities.
- The database schema is designed to support relationships between the various elements of the system.

4.	API (Application Programming Interface):
- RESTful API to enable communication between client and server.
- JSON is used for the data exchange format.
- API documentation (e.g. using Swagger) to simplify development and integration.

5. Deployment Model
- Use of containerization (Docker) to facilitate deployment.
- Ability to deploy in the cloud or on local servers.

6. Security
- Backup and restore data to ensure data integrity and availability.

## Database Model and Structure

#### Database Model Overview

The Agile system uses a relational database to store and manage all data related to projects, tasks, users and other entities. The database structure is designed to ensure efficient data storage and optimal performance.

#### Description of Tables
The database consists of several main tables including:
1. *User*: Stores information about the users of the system.
2. *Project*: Contains data about projects.
3. *Task*: Reflects the tasks assigned to projects.
4. *Comment*: Contains user comments on tasks.
5. *Role*: Defines the roles in the project. 
6. *ProjectMember*: Manage project members and their roles. 
7. *Attachment*: Storing attachments to tasks. 
8. *TimeLog*: Record the time spent on tasks. 9.
9. *Notification*: User notifications.