# Tranzaction_Reward_System_Springboot_Us

# Transaction Reward System - Spring Boot

A Spring Boot application that provides APIs for managing and analyzing customer reward points based on transaction activity. This system allows tracking individual transactions, computing rewards, and generating summaries over specific time periods.

##  Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- MySQL or H2 (for development)
- Jakarta Validation
- SLF4J (Logging)
- Maven

---

##  Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL (or update `application.properties` for H2 in-memory DB)

### Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Transaction_Reward_System_Springboot_Us.git
   cd Transaction_Reward_System_Springboot_Us


 Request - Get Endpoint request customer id for rewords By Month - http://localhost:8085/rewords/getRewordsByMonth/10
 Responce-
  {
  "customerName": "Adarsh",
  "customerId": 10,
  "rewordPoints": {
  "2025-07": 850,
  "2025-06": 39700,
  "2025-08": 9850
  },
  "totalSumOfAllRewards": 50400
  }


2- Add Reword Post EntPoint - http://localhost:8085/rewords/addReword

 {
  "customerName":"Adarsh",
  "tranzationAmount":10000.00,
   "customerId":10
 }

3- Running the Project 
   Strart the servic for endpoints to working state .
   Hit post endpoint to create the reword .
   Get Endpoint for getting reword summery.

4-Application Properties
  spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
  spring.datasource.username=root
  spring.datasource.password=your_password
  spring.jpa.hibernate.ddl-auto=update

5-Get Call Monthly Rewords For Customer - http://localhost:8084/reword/getRewordsByMonth/4?startDate=2025-03-01&endDate=2025-06-16
Response-
{
"customerName": "Adarsh Chimgaonakr",
"customerId": 4,
"rewordPoints": {
"2025-Jun": 230
},
"totalSumOfAllRewards": 230
}


6- Get All Reword Points Last 3 Months For Each Customer Date Range - http://localhost:8084/reword/getThreeMonthsRewordsSummeryForAllCustomer?startDate=2025-03-01&endDate=2025-06-17
[
{
"customerName": "Adarsh Chimgaonakr",
"customerId": 4,
"rewordPoints": {
"2025-Jun": 230
},
"totalSumOfAllRewards": 230
},
{
"customerName": "Akhilesh Magdum",
"customerId": 2,
"rewordPoints": {
"2025-May": 90,
"2025-Jun": 110,
"2025-Apr": 230
},
"totalSumOfAllRewards": 430
},
{
"customerName": "Sunil Karde",
"customerId": 6,
"rewordPoints": {
"2025-Jun": 110
},
"totalSumOfAllRewards": 110
}
]