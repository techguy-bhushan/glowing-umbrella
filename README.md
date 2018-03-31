# glowing-umbrella
Redis with spring-boot sample app

**Required Setup:**

* Maven
* Redis (https://redis.io/download)
* Java 

Up your redis server:
(instruction are here :https://redis.io/download)


In this sample we perform curd operation on book entity using redis cache and rest api.

**Run RedisSampleApplication.java**

Here are Apis sample:

**Create Book :**
Url:
http://localhost:8080/book

Request Method: Post

Header :
Content-Type = application/json

Row body :

``{
    "name": "A Tale of Two Cities",
    "description": "A Tale of Two Cities (1859) is a historical novel by Charles Dickens, set in London and Paris before and during the French Revolution.",
    "isbn": "1523478292"
}``


Response eg:

``{
    "id": 1,
    "name": "A Tale of Two Cities",
    "description": "A Tale of Two Cities (1859) is a historical novel by Charles Dickens, set in London and Paris before and during the French Revolution.",
    "isbn": "1523478292"
}``


**Find All Book**

Url :http://localhost:8080/book
Request Method : GET

Response eg:

``[
    {
        "id": 2,
        "name": "The Lord of the Rings",
        "description": "The Lord of the Rings is a must-read for all fantasy genre fans. Those who have previously read The Hobbit will find The Lord of the Rings as a familiar time and place to return to. This epic fantasy book centers on a hobbit named Frodo Baggins and his loyal group of companions, called The Fellowship of the Ring.",
        "isbn": "116-1749849-2513827"
    },
    {
        "id": 1,
        "name": "A Tale of Two Cities",
        "description": "A Tale of Two Cities (1859) is a historical novel by Charles Dickens, set in London and Paris before and during the French Revolution.",
        "isbn": "1523478292"
    }
]``




**Retrieve Book**

Url : http://localhost:8080/book/2
Request Method : Get


``{
    "id": 2,
    "name": "The Lord of the Rings",
    "description": "The Lord of the Rings is a must-read for all fantasy genre fans. Those who have previously read The Hobbit will find The Lord of the Rings as a familiar time and place to return to. This epic fantasy book centers on a hobbit named Frodo Baggins and his loyal group of companions, called The Fellowship of the Ring.",
    "isbn": "116-1749849-2513827"
}``



Delete:
http://localhost:8080/book/2

