# Tranzaction_Reward_System_Springboot_Us
1-This project is a microservice which calculates rewards for tranzaction amount.
  Logic - over $100 - 2 reward points per doller. 
  In range of $50-100 - 1 reward point per doller.

2- The project follows the controller - service - repository layer artechiture .

3- sample request - responce Models.

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


4- Add Reword POst EntPoint - http://localhost:8085/rewords/addReword

 {
  "customerName":"Adarsh",
  "tranzationAmount":10000.00,
   "customerId":10
 }

5- Running the Project 
   Strart the servic for endpoints to working state .
   Hit post endpoint to create the reword .
   Get Endpoint for getting reword summery.

