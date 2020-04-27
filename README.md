# Emergency Spot - REST API

Backend server with REST API provided for EmergencySpot App. Built with Spring Boot Web and secured with JWT authorization.


### REST API - endpoints:

### Overview:

* [/hospitals GET](#list-hospitals)
* [/hospitals/{id} GET](#find-one-hospital)
* [/hospitals/nearest GET](#find-nearest-hospital)
+ [/wards GET](#list-wards)
+ [/wards/{id} GET](#find-one-ward)
* [/reviews GET](#list-reviews)
* [/reviews/{id} GET](#find-one-review)
* [/reviews POST](#create-review)
* [/reviews/{id} PUT](#update-review)
* [/reviews/{id} DELETE](#delete-review)

---

### List hospitals:

Returns all hospitals matching to applied filters

`GET /hospitals`

Request params:

| Param       | Description                         | Type            | Required |
| ----------- | ----------------------------------- | --------------- | -------- |
| `name`      | hospital name                       | `String`        | *No*     |
| `longitude` | longitude where hospital is located | `Double`        | *No*     |
| `latitude`  | latitude where hospital is located  | `Double`        | *No*     |
| `country`   | country where hospital is located   | `String`        | *No*     |
| `city`      | city where hospital is located      | `String`        | *No*     |
| `wards`     | wards which are located in hospital | `Array<String>` | *No*     |

Usage:

+ `GET /hospitals`
+ `GET /hospitals?name=X`
+ `GET /hospitals?name=X&city=Y&longitude=30.4516&wards=[ICU,ER]`

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

---

### Find one hospital

Returns hospital with given ID.

`GET /hospitals/{id}`

+ `id` - hospital ID

Usage:

+ `GET /hospitals/981341`
+ `GET /hospitals/24141`

Sample response:

```json
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
```

---

### Find nearest hospital

Returns hospital nearest given longitude and latitude.

`GET /hospitals/nearest`

Request params:

| Param       | Description                     | Type            | Required |
| ----------- | ------------------------------- | --------------- | -------- |
| `longitude` | longitude where user is located | `Double`        | *Yes*    |
| `latitude`  | latitude where user is located  | `Double`        | *Yes*    |

Usage:

+ `GET /hospitals/nearest?longitude=20.8391&latitude=19.2003`

---

### List wards

Returns all hospital wards matching to applied filters

`GET /wards`

Request params:

| Param           | Description                         | Type            | Required |
| --------------- | ----------------------------------- | --------------- | -------- |
| `wards`         | hospital ward types                 | `String`        | *No*     |
| `min_capacity`  | minimum hospital ward capacity      | `Double`        | *No*     |
| `max_capacity`  | maximum hospital capacity           | `Double`        | *No*     |
| `hospital`      | hospital ID                         | `Long`          | *No*     |

Usage:

+ `GET /wards`
+ `GET /wards?min_capacity=20`
+ `GET /wards?max_capacity=50&wards=[ICU,ER]

---

### Find one ward

Returns hospital ward with given ID.

`GET /wards/{id}`

+ `id` - hospital ward ID

Usage:

+ `GET /wards/90111298`
+ `GET /wards/5993210`

---

### List reviews

Return all reviews matching to applied filters.

`GET /reviews`

Request params:

| Param           | Description                         | Type            | Required |
| --------------- | ----------------------------------- | --------------- | -------- |
| `min_rating`    | minimum review rating               | `Double`        | *No*     |
| `max_rating`    | maximum review rating               | `Double`        | *No*     |
| `hospital`      | hospital ID associated with review  | `Long`          | *No*     |

Usage:

+ `GET /reviews`
+ `GET /reviews?min_rating=4.5`
+ `GET /reviews?min_rating=8.0&hospital=9013314`

---

### Find one review

Return review with given ID.

`GET /reviews/{id}`

+ `id` - review ID

Usage:

+ `GET /review/71401298`
+ `GET /review/3613210`

---

### Create review

Create new review

`POST /reviews`

Request body:

```json
{
  "userId": [userId],
  "review": [review],
  "rating": [rating],
  "hospitalId": [hospitalId]
}
```

| Param           | Description                         | Type            | Required |
| --------------- | ----------------------------------- | --------------- | -------- |
| `userId`        | user associated with review         | `Long`          | *Yes*    |
| `review`        | review description                  | `String`        | *Yes*    |
| `rating`        | review rating                       | `Double`        | *Yes*    |
| `hospitalId`    | hospital ID associated with review  | `Long`          | *Yes*    |

---

### Update review

Updates exisiting review.

`PUT /reviews/{id}`

+ `id` - review ID

Request params:

| Param           | Description                         | Type            | Required |
| --------------- | ----------------------------------- | --------------- | -------- |
| `review`        | review description                  | `String`        | *No*     |
| `rating`        | review rating                       | `Double`        | *No*     |

Usage:

+ `PUT /reviews/1940380?rating=9.0`
+ `PUT /reviews/193755113?review=X&rating=5.6`

---

### Delete review

Deletes review with given ID

`DELETE /reviews/{id}`

+ `id` - review ID

Usage:

+ `DELETE /reviews/1748391`
+ `DELETE /reviews/6382649001`

