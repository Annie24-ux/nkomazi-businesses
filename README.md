# Nkomazi Businesses

## 📌 Project Overview
This project is a **Spring Boot** application that performs **CRUD (Create, Read, Update, Delete) operations** on a database of businesses located in **Nkomazi, Mpumalanga**. The goal of this project is to allow users to manage business listings efficiently.
Users can:

- Get a list of all businesses.
- Retrieve a business by its ID.
- Add a new business.
- Update an existing business.
- Delete a business by its ID.
- Get all businesses owned by a specific person.

This project is part of a **learning series** focused on mastering **Spring Boot** development. Future implementations will include **authentication** for user login and logout functionalities.

---

## 🛠️ Tech Stack

The project is built using the following technologies:

- **Java 17** - Primary programming language
- **Spring Boot** - Backend framework
- **Spring Data JPA** - ORM framework for database interaction
- **H2 Database** - In-memory database for development
- **SQL** - Query language for handling database operations
- **HTML & JavaScript** - Frontend for adding new businesses
- **Postman** - API testing tool
- **Maven** - Dependency management

---

## 🚀 Installation & Setup

To run this project locally, follow these steps:

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Annie24-ux/nkomazi-businesses.git
   cd nkomazi-businesses
   ```

2. **Run the Application**
   Ensure you have Java and Maven installed, then execute:
   ```bash
   mvn spring-boot:run
   ```

3. **Access the Application**
   - The API will be available at `http://localhost:8080`
   - The frontend (HTML page for adding businesses) can be accessed at `http://localhost:8080/add-business`
   - Use **Postman** to test API endpoints.

---

## 📜 API Endpoints

| Method | Endpoint | Description |
|--------|---------|-------------|
| GET | `/businesses` | Get all businesses |
| GET | `/businesses/{id}` | Get a business by ID |
| POST | `/businesses` | Add a new business |
| PUT | `/businesses/{id}` | Update an existing business |
| DELETE | `/businesses/{id}` | Delete a business by ID |
| GET | `/businesses/owner/{ownerName}` | Get all businesses owned by a specific person |

To test the API, import the **Postman collection** from the project folder.

---

## 🌐 Frontend (HTML & JavaScript)
The project includes an HTML page that allows users to **add new businesses** through a form. This form interacts with the backend to persist business data in the H2 database.

---

## 📌 Future Implementations

- 🔐 **Authentication System** - Users will be able to log in and log out.
- 📊 **Enhanced UI** - Improved frontend design with better user experience.
- 📍 **Location-based Search** - Find businesses based on geolocation.


---

## 📩 Contact Information
For questions, suggestions, or collaborations, feel free to reach out:
- 📧 **Email**: sibiyasa24@gmail.com
- 📂 **GitHub**: [Annie24-ux](https://github.com/Annie24-ux)

