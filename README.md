# kata

This is how to test  user stories

1) US 1 
  POST http://localhost:8080/deposit
  Body param {
    "idAccount": 1999999991,
    "amount": 222
  }
  
 2.1) US 2 
  POST http://localhost:8080/retrieve
  Body param {
    "idAccount": 1999999991,
    "amount": 20
  }
  
 2.2) US 2 (to retrieve all)
  POST http://localhost:8080/retrieve
  Body param {
    "idAccount": 1999999991,
    all: true
  }

 3) US 3 
  GET http://localhost:8080/history/1999999991
  
  
  Data are stored in Map<Account, List AccountStatement > in the Util class History
