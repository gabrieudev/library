# Library REST API

![Java](https://img.shields.io/badge/Java-21-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green) ![Spring Security](https://img.shields.io/badge/Spring%20Security-6-green) [![LinkedIn](https://img.shields.io/badge/Connect%20on-LinkedIn-blue)](https://www.linkedin.com/in/gabrieudev) ![GPL License](https://img.shields.io/badge/License-GPL-blue)

Welcome to my **Library REST API** project. 

Please select your preferred language:

- [English](README.md)
- [Português (Brasil)](README.pt-br.md)

This project serves as the backend for the service.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Contributions](#contributions)
- [Contact](#contact)

## Introduction

The **Library REST API** project was created to provide CRUD operations for books, categories, loans, authors, reviews, and system users. Additionally, the project implements authentication with JWTs and authorization through roles for users, using the best and most updated market practices to ensure the integrity of sensitive data.

## Features

- User registration confirmation via email.
- Search functionality with pagination.
- Endpoints documentation using Swagger.
- User login with JWT authentication.
- Role-based authorization to control access to different API endpoints.
- Password encryption following industry best practices.
- Integration with PostgreSQL database.

## Technologies

- ![Java](https://img.shields.io/badge/Java-21-orange): Programming language.
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green): Framework for building production-ready applications.
- ![Spring Security](https://img.shields.io/badge/Spring%20Security-6-green): Security framework for Spring applications.
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue): Relational database.

## Getting Started

Follow these steps to run the project on your machine:

1. Clone the repository: `git clone https://github.com/gabrieudev/library.git`
2. Navigate to the project directory: `cd <path>`
3. Update general settings in `application.properties`.
4. Build the project: `./mvnw clean install` (for Windows: `mvnw.cmd clean install`)
5. Run the application: `./mvnw spring-boot:run` (for Windows: `mvnw.cmd spring-boot:run`)

## Configuration

- Database and JavaMailSender: Update the `application.properties` file with your PostgreSQL database and JavaMailSender information.

## Usage

1. When the project starts, an admin user is automatically inserted into the database in `AdminDataLoader.java`. You can change its information either there or in `application.properties`.
2. Use an admin role user to access protected endpoints.

## Endpoints

Author:

- `ADMIN Role` `POST /authors`: Saves an author.
- `BASIC Role` `GET /authors/{id}`: Retrieves an author by id.
- `BASIC Role` `GET /authors`: Retrieves all authors.
- `ADMIN Role` `PUT /authors/{id}`: Updates an author.
- `ADMIN Role` `DELETE /authors/{id}`: Deletes an author.

Book:

- `ADMIN Role` `POST /books`: Saves a book.
- `BASIC Role` `GET /books/{id}`: Retrieves a book by id.
- `BASIC Role` `GET /books`: Retrieves all books.
- `ADMIN Role` `PUT /books/{id}`: Updates a book.
- `ADMIN Role` `DELETE /books/{id}`: Deletes a book.
- `BASIC Role` `GET /books/by-author/{authorId}`: Retrieves all books by an author.
- `BASIC Role` `GET /books/by-category/{categoryId}`: Retrieves all books by a category.
- `BASIC Role` `GET /books/best-rated`: Retrieves the best-rated books.
- `BASIC Role` `GET /books/most-borrowed`: Retrieves the most borrowed books.

Category:

- `ADMIN Role` `POST /categories`: Saves a category.
- `BASIC Role` `GET /categories/{id}`: Retrieves a category by id.
- `BASIC Role` `GET /categories`: Retrieves all categories.
- `ADMIN Role` `PUT /categories/{id}`: Updates a category.
- `ADMIN Role` `DELETE /categories/{id}`: Deletes a category.

Loan:

- `BASIC Role` `POST /loans`: Saves a loan.
- `BASIC Role` `GET /loans/{id}`: Retrieves a loan by id.
- `ADMIN Role` `GET /loans`: Retrieves all loans.
- `BASIC Role` `PUT /loans/{id}`: Updates a loan.
- `BASIC Role` `DELETE /loans/{id}`: Deletes a loan.

Review:

- `BASIC Role` `POST /reviews`: Saves a review.
- `BASIC Role` `GET /reviews/{id}`: Retrieves a review by id.
- `BASIC Role` `GET /reviews`: Retrieves all reviews.
- `BASIC Role` `PUT /reviews/{id}`: Updates a review.
- `BASIC Role` `DELETE /reviews/{id}`: Deletes a review.

User:

- `POST /register`: Registers a user and sends a confirmation email.
- `GET /check/{userId}/{verificationId}`: Verifies if the provided id matches the id sent to the email upon user registration.
- `ADMIN Role` `GET /users`: Retrieves all users.
- `BASIC Role` `PUT /update-password`: Updates a user's password if the provided email belongs to the caller.

Access the full documentation at the `/swagger-ui.html` endpoint.

## Contributions

Contributions are welcome! If you wish to contribute, fork the repository and create a pull request.

## Contact

If you have any suggestions or questions, contact me on [LinkedIn](https://www.linkedin.com/in/gabrieudev).

---

**License:** This project is licensed under the terms of the [GNU General Public License (GPL)](LICENSE).