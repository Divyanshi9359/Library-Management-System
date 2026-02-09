# 📚 Library Management System

A Java-based Library Management System developed using **Java Swing**, **MySQL**, and **Maven**.  
This project helps manage books, students, and book issuing/returning operations in a library.

> This project was inspired by online learning resources, and extended with additional features, validations, and database integration by me.

---

## ✨ Features

### 🔐 Authentication
- Login system for secure access

### 📖 Book Management
- Add new books
- View all books
- Issue books
- Return books

### 👨‍🎓 Student Management
- Add students
- View all registered students
- Search students by name
- Remove students (with validation)

### 🧠 Smart / Validation Features
- Prevent issuing books to non-registered students
- Prevent deleting students who have issued books
- Recommended book display (basic AI logic)
- Dashboard statistics (total students)

---

## 🛠️ Technologies Used

- **Java (Swing)** – for GUI
- **MySQL** – for database
- **JDBC** – database connectivity
- **Maven** – dependency management
- **IntelliJ IDEA** – IDE
- **Git & GitHub** – version control

---
src/
├── ui/ → All UI forms (Login, Dashboard, Add Book, etc.)
├── model/ → Model classes (Book, Student)
├── service/ → Business logic & database operations
└── util/ → Database connection


---

## 🧪 Database Setup

1. Create a MySQL database:
   ```sql
   CREATE DATABASE library_db;
2.Create required tables:

students

books

issued_books

3.Update database credentials in DBConnection.java

## 🗂️ Project Structure

