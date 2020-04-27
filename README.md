# Emergency Spot - REST API

Backend server with REST API provided for EmergencySpot App. Built with Spring Boot Web and secured with JWT authorization.


### REST API - endpoints:

#### Overview:

* [/hospitals GET](#list-hospitals)
* [/hospitals/{id} GET](#find-one-hospital)
* [/hospitals/nearest GET](#find-nearest-hospital)
* [/hospitals POST](#create-hospital)
* [/hospitals PUT](#update-hospital)
* [/hospitals DELETE](#delete-hospital)
+ [/wards GET](#list-wards)
+ [/wards/{id} GET](#find-one-ward)
+ [/wards POST](#create-ward)
+ [/wards PUT](#update-ward)
+ [/wards DELETE](#delete-ward)
* [/reviews GET](#list-reviews)
* [/reviews/{id{ GET](#find-one-review)
* [/reviews POST](#create-review)
* [/reviews PUT](#update-review)
* [/reviews DELETE](#delete-review)


#### List hospitals:

List all hospital matching applied filters

`GET /hospitals`

Filter params: (*Optional*)

| Param       | Description                         | Type            |
| ----------- | ----------------------------------- | --------------- |
| `name`      | hospital name                       | `String`        |
| `longitude` | longitude where hospital is located | `Double`        |
| `latitude`  | latitude where hospital is located  | `Double`        |
| `country`   | country where hospital is located   | `String`        |
| `city`      | city where hospital is located      | `String`        |
| `wards`     | wards which are located in hospital | `Array<String>` |

Usage:

+ `GET /hospitals`
+ `GET /hospitals?name=X`
+ `GET /hospitals?name=X&city=Y&longitude=30.4516`

Sample response:

```json
[
  {
    "id": 1,
    "name": "Hospital 1",
    "description": "Hospital Description",
    "longitude":3 0.5689,
    "latitude": 70.2391,
    "country": "US",
    "city": "New York",
    "street": "10th Street",
    "streetNumber": 1092,
    "wards": [
      {
        "id": 3,
        "wardType": "ICU", 
        "capacity": 200
      },
      {
        "id": 4,
        "wardType": "ICU",
        "capacity": 200
      }
    ],
    "reviews": []
   }
]
```