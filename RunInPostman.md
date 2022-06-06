
###Via onderstaande button kun je de verschillende endpoints in dit project direct testen in postman.


[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/19299932-68888a0e-153b-4fbc-9107-cc8e8459aca7?action=collection%2Ffork&collection-url=entityId%3D19299932-68888a0e-153b-4fbc-9107-cc8e8459aca7%26entityType%3Dcollection%26workspaceId%3D1f4624a7-0540-4fe4-9686-93a936aa5026)


Onderstaande API-endpoints zijn beschikbaar en worden gebruikt bij de postman tests.

POST http://localhost:8080/authenticate

GET http://localhost:8080/authenticated

GET http://localhost:8080/icecreamflavors/

GET http://localhost:8080/orderlines/

POST http://localhost:8080/orderlines/

PUT http://localhost:8080/orderlines/update/{{id}}

GET http://localhost:8080/orderlines/user/{{username}}

POST http://localhost:8080/orders/

GET http://localhost:8080/orders/user/{{username}}

GET http://localhost:8080/products/

POST http://localhost:8080/products/

GET http://localhost:8080/products/{{id}}

GET http://localhost:8080/sorbetflavors/

POST http://localhost:8080/users

GET http://localhost:8080/users/{{username}}