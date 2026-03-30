# 📌 Complaint Management System

## 📖 Project Description
The Complaint Management System is a console-based application that allows users to register complaints and enables administrators to manage and resolve them efficiently. The system ensures proper routing of complaints to departments, tracks their status, and includes a points-based mechanism to encourage meaningful contributions.

---

## 🎯 Features

### 👤 User Side
- Register complaints with:
  - Name  
  - Complaint description  
  - Department  
  - Social impact flag  
- Automatically generated Complaint ID  
- Check complaint status  
- View points earned  

---

### 👨‍💼 Admin Side
- Secure login system  
- View all complaints  
- Update complaint status:
  - Pending  
  - In Progress  
  - Resolved  
- Assign points for useful complaints  
- View social impact complaints  
- View department-wise complaints  

---

## 🧠 Key Concepts Used
- JDBC (Java Database Connectivity)  
- MySQL Database  
- Java OOP (Classes & Methods)  
- Menu-driven console application  
- Auto-increment primary key  

---

## 🛠️ Tech Stack
- Language: Java  
- Database: MySQL  
- Connectivity: JDBC  
- IDE: Eclipse  

---

## 🗂️ Project Structure
```
complaint-management-system/
│
├── dao/
│   ├── DBConnection.java
│   ├── AdminDAO.java
│   └── ComplaintDAO.java
│
├── ui/
│   └── Main.java
```

---

## 🗄️ Database Structure

### Admin Table
- id (Primary Key)  
- username  
- password  

### Complaints Table
- complaint_id (Primary Key, Auto Increment)  
- name  
- complaint_text  
- department  
- status  
- social_impact  
- points  

---

## ▶️ How to Run

1. Create database:
```sql
CREATE DATABASE complaint_system;
```

2. Create tables (admin and complaints)

3. Update DB credentials in `DBConnection.java`

4. Add MySQL Connector JAR in Eclipse

5. Run:
```
Main.java
```

---

## 🔄 System Flow

### User Flow
1. Register complaint  
2. Receive complaint ID  
3. Check status and points  

### Admin Flow
1. Login  
2. View complaints  
3. Update status  
4. Assign points  
5. Filter complaints  

---

## ⭐ Unique Features
- Department-wise complaint handling  
- Social impact prioritization  
- Points-based reward system  
- Simple console interface  

---

## 🚀 Future Enhancements
- GUI using Java Swing / JavaFX  
- Notification system  
- User authentication  
- Dashboard & analytics  
- Leaderboard  

---

## 🧪 Sample Admin Login
```
Username: admin
Password: 1234
```

---

## 🎓 Viva Summary
This project is a Complaint Management System built using Java, JDBC, and MySQL, supporting user complaint registration and admin-based resolution with features like department filtering, social impact tracking, and a points-based evaluation system.
