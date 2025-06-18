# Transaction_Reward_System_Springboot_Us

A Spring Boot application that provides APIs for managing and analyzing customer reward points based on transaction activity. This system allows tracking individual transactions, computing rewards, and generating summaries over specific time periods.

##  Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- MySQL
- Jakarta Validation
- SLF4J (Logging)
- Maven

---

##  Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL (or update `application.properties` for H2 in-memory DB)

# Transaction Reward System (Spring Boot)

A Spring Boot application that provides APIs for managing and analyzing customer reward points based on transaction activity. This system allows tracking individual transactions, computing rewards, and generating summaries over specific time periods.

## 🛠 Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- MySQL 
- Jakarta Validation
- SLF4J (Logging)
- Maven

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL (or configure H2 for in-memory DB in `application.properties`)

---

### 🔧 Setup Instructions

#### 1. Clone the repository:

```bash
git clone https://github.com/yourusername/Transaction_Reward_System_Springboot_Us.git
cd Transaction_Reward_System_Springboot_Us
```

---

**Endpoint:**
---

#### 2. Add Reward (POST)

**Endpoint:**

```
POST http://localhost:8085/rewords/addReword
```

**Request Body:**

```json
{
  "customerName":"Sunil Karde",
  "transactionAmount":130.00 ,
  "customer":{
    "id":6,
    "customerName":"Sunil Karde",
    "rewords":[]

  }
}
```
**Response Body:**

```json
{
  "transactionId": 5,
  "date": "2025-06-17",
  "customerName": "Sunil Karde",
  "transactionAmount": 130.0,
  "rewardPoints": 110,
  "customer": {
    "id": 6,
    "customerName": "Sunil Karde",
    "rewords": []
  }
}
```
---

#### 4. Running the Project

Start the service using your preferred IDE or CLI.

- Use **POST** endpoint to add reward transactions.
- Use **GET** endpoints to retrieve summaries.

---

#### 5. Application Properties

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

#### 6. Get Monthly Reward Summary for a Customer

**Endpoint:**

```
GET http://localhost:8084/reword/getRewordsByMonth/2?startDate=2025-03-01&endDate=2025-06-16
```

**Response:**

```json
{
  "customerName": "Akhilesh Magdum",
  "transactionList": [
    {
      "Amount": 190.0,
      "TransactionId": 2
    },
    {
      "Amount": 120.0,
      "TransactionId": 3
    },
    {
      "Amount": 130.0,
      "TransactionId": 4
    }
  ],
  "rewordPoints": [
    {
      "Points:": 110,
      "Month:": "Jun"
    },
    {
      "Points:": 230,
      "Month:": "Apr"
    },
    {
      "Points:": 90,
      "Month:": "May"
    }
  ],
  "totalSumOfAllRewards": 430
}
```

---

#### 7. Get Last 3 Months Reward Summary for All Customers

**Endpoint:**

```
GET http://localhost:8084/reword/getThreeMonthsRewordsSummeryForAllCustomer?startDate=2025-03-01&endDate=2025-06-17
```

**Response:**

```json
[
  {
    "customerName": "Adarsh Chimgaonakr",
    "transactionList": [
      {
        "Amount": 190.0,
        "TransactionId": 1
      }
    ],
    "rewordPoints": [
      {
        "Points:": 230,
        "Month:": "Jun"
      }
    ],
    "totalSumOfAllRewards": 230
  },
  {
    "customerName": "Akhilesh Magdum",
    "transactionList": [
      {
        "Amount": 190.0,
        "TransactionId": 2
      },
      {
        "Amount": 120.0,
        "TransactionId": 3
      },
      {
        "Amount": 130.0,
        "TransactionId": 4
      }
    ],
    "rewordPoints": [
      {
        "Points:": 110,
        "Month:": "Jun"
      },
      {
        "Points:": 230,
        "Month:": "Apr"
      },
      {
        "Points:": 90,
        "Month:": "May"
      }
    ],
    "totalSumOfAllRewards": 430
  },
  {
    "customerName": "Sunil Karde",
    "transactionList": [
      {
        "Amount": 130.0,
        "TransactionId": 5
      }
    ],
    "rewordPoints": [
      {
        "Points:": 110,
        "Month:": "Jun"
      }
    ],
    "totalSumOfAllRewards": 110
  },
  {
    "customerName": "Shivaji Karde",
    "transactionList": [
      {
        "Amount": 130.0,
        "TransactionId": 6
      },
      {
        "Amount": 130.0,
        "TransactionId": 7
      },
      {
        "Amount": 130.0,
        "TransactionId": 8
      }
    ],
    "rewordPoints": [
      {
        "Points:": 330,
        "Month:": "Jun"
      }
    ],
    "totalSumOfAllRewards": 330
  }
]
```

```
http://localhost:8084/customer/createCustomer?customerName=Shivaji Karde
```
```Request- Json
{
"customerName":"Shivaji Karde"
}
```
```Response 
{
    "id": 7,
    "customerName": "Shivaji Karde"
}
```

---

### 📫 Contact

For any issues or feature requests, feel free to create an issue on the repository.

---
