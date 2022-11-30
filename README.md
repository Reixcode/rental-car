# REST API application

Aplication REST API  to manage car rental


## Tools


    STS 4 Spring Boot
    H2
    Junit
    Mockito
    Postman


# REST API

    For a car rental system, create a API REST  for managing the rental administration with three primaries functions:
    • Have an inventory of cars
    • Calculate the price for rental
    • Keep the track of the customer loyalty points
    • Calculate surchage if exits, for return car


## Create a new rental

### Request

`POST http://localhost:8080/rentalcar/rentcar/{idCustomer}`

    curl --location --request POST 'http://localhost:8080/rentalcar/rentcar/1' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "CarRentList": [
        {
        "typeCar": "PREMIUM",
        "daysRent": 10
        },
        {
        "typeCar": "SMALL",
        "daysRent": 10
        },
        {
        "typeCar": "SUV",
        "daysRent": 9
        }
    ]
    }'

### Response

    Status: 201 Created
    Content-Type: application/json

    {
        "totalRent": 4730.00,
        "rentPoints": 9,
        "totalCustomerPoints": 18,
        "ListPriceRent": [
            {
                "typeCar": "PREMIUM",
                "priceRent": 3000.0,
                "pointsRent": 5
            },
            {
                "typeCar": "SMALL",
                "priceRent": 440.00,
                "pointsRent": 1
            },
            {
                "typeCar": "SUV",
                "priceRent": 1290.00,
                "pointsRent": 3
            }
            ]
    }
## Create a new return car

### Request

`POST /rentalcar/returncar/`

   curl --location --request POST 'http://localhost:8080/rentalcar/returncar' \
    --header 'Content-Type: application/json' \
    --data-raw '  {
        "typeCar": "SMALL",
        "extraDaysRent": 1
        }'

### Response

    Status: 201 Created
    Content-Type: application/json

    {
        "totalSurchage": 65.00
    }

## Get a List cars

### Request

`GET /cars`

    curl --location --request GET 'http://localhost:8080/cars'

### Response

    Status: 200 OK
    Content-Type: application/json
    
    [
        {
            "idCar": "0001CVB",
            "typeCar": "SUV"
        },
        {
            "idCar": "0002CVB",
            "typeCar": "SUV"
        },
        {
            "idCar": "0003CVB",
            "typeCar": "SUV"
        },
        {
            "idCar": "1000CVB",
            "typeCar": "PREMIUM"
        },
        {
            "idCar": "2000CVB",
            "typeCar": "PREMIUM"
        },
        {
            "idCar": "3000CVB",
            "typeCar": "PREMIUM"
        },
        {
            "idCar": "4000CVB",
            "typeCar": "PREMIUM"
        },
        {
            "idCar": "0100CVB",
            "typeCar": "SMALL"
        },
        {
            "idCar": "0200CVB",
            "typeCar": "SMALL"
        },
        {
            "idCar": "0300CVB",
            "typeCar": "SMALL"
        }
    ]

## Get a Customer points

### Request

`GET /customers/{idCustomer}`

    curl --location --request GET 'http://localhost:8080/customers/1'

### Response

    Status: 200 OK
    Content-Type: application/json
    {
        "idCustomer": 1,
        "points": 30
    }


