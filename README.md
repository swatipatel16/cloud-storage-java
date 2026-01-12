☁️ Cloud Storage API
Spring Boot + JWT + File Upload/Download

A secure backend application that allows users to Register, Login, Upload files, Download files, List uploaded files, and Delete files using JWT authentication.

📌 Features
🔐 Authentication

Register new users

Login and generate JWT token

Auth guard on all file APIs

📁 File Handling

Upload any document/image

Download stored files

List user files

Delete files

🧰 Technical

Stateless Spring Security

BCrypt password encryption

Supports MySQL & H2 (Dev mode)

Swagger UI API documentation

🏗️ Tech Stack

Area	Technology
Language	Java 17+

Framework	Spring Boot 3.x

Security	JWT + Spring Security

Database	H2 (default) or MySQL

Build	Maven

Testing/Docs	Swagger UI 


📂 Project Structure


src/main/java/com/example/cloud_storage
│
├── auth/          → Register/Login controllers
├── config/        → Security & JWT filter
├── entity/        → User model
├── repository/    → User repo
├── services/      → JwtService & FileService
└── controller/    → FileController (upload/download/list/delete)
