🔐 AES Encryption & Decryption Platform (Spring Boot) :-
-------------------------------------------------------

A secure, end-to-end AES-256 Encryption and Decryption platform built using Java Spring Boot, demonstrating real-world cryptographic practices, RESTful API design, and a modern frontend interface.

This project showcases how sensitive data can be securely encrypted, transmitted, decrypted, and validated using industry-standard cryptography.

🚀 Key Features  :-
-----------------
✅ AES-256 Encryption using CBC mode with PKCS5Padding

✅ Secure REST APIs built with Spring Boot

✅ Clean layered architecture (Controller, Service, Utility)

✅ Robust exception handling for invalid encrypted input

✅ Detailed logging for encryption & decryption flow

✅ Modern, responsive frontend UI

✅ User-friendly error messages for failed decryption

✅ Production-ready project structure

🛠️ Technology Stack :-
---------------------
Layer	Technology
Backend	Java 17, Spring Boot
Cryptography	AES-256 (CBC, PKCS5Padding)
Frontend	HTML, CSS, JavaScript
Build Tool	Maven
Logging	SLF4J + Logback
Version Control	Git & GitHub
🔑 Cryptography Details :-
-------------------------
Algorithm: AES (Advanced Encryption Standard)

Key Size: 256-bit

Mode: CBC (Cipher Block Chaining)

Padding: PKCS5Padding

Encoding: Base64 (for safe data transfer)

AES/CBC/PKCS5Padding

📂 Project Structure :-
----------------------
AES_Encryption_Decryption
│
├── controller
│   └── AESController.java
├── service
│   └── AESService.java
├── util
│   └── AESUtil.java
├── exception
│   ├── GlobalExceptionHandler.java
│   └── InvalidEncryptedDataException.java
├── resources
│   └── static/index.html
└── pom.xml

🔄 Application Flow :-
--------------------
User enters data in the frontend UI

Data is sent to Spring Boot REST API

AES-256 encryption/decryption is performed

Output is returned securely to the UI

Invalid input is handled gracefully with custom messages

🖥️ UI & Use Case Screenshots :-
------------------------------

🔐 Encryption – Success

🔓 Decryption – Success

❌ Decryption – Failed (Invalid Input)

⚠️ Error Handling :-
---------------------
Invalid encrypted input is detected and handled

User-friendly messages are shown on UI

Backend exceptions are logged securely

No stack traces are exposed to the frontend

Example:

Invalid encrypted input. Please provide a valid encrypted value.

▶️ How to Run the Project :-
---------------------------
1️⃣ Clone the Repository
git clone https://github.com/<your-username>/AES-Encryption-Decryption-SpringBoot.git

2️⃣ Navigate to Project
cd AES_Encryption_Decryption

3️⃣ Run the Application
mvn spring-boot:run

4️⃣ Open Browser
[http://localhost:8080/index.html]

🔐 Security Notes
------------------
⚠️ For demo purposes only:

Secret Key & IV are hardcoded

In real applications:

Use environment variables

Rotate keys periodically

Use secure key management (Vault, KMS)

📌 Future Enhancements  :-
-------------------------
JWT-based authentication

Dynamic key generation

Database encryption support

HTTPS & TLS configuration

Cloud deployment (AWS / Azure)
