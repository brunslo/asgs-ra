# ASGS-RA
This is a simple microservice wrapping the Australian Statistical Geography Standard - Remoteness Area (ASGS-RA) geopackage. It is written in Spring Boot and makes use of a companion repository `brunslo/asgs-ra-postgis` to query the contents of the geopackage.

## Deployment
Deployment is straightforward using the included `docker-compose.yml`. For most setups you can simply type the following in the projects root directory:
```
docker-compose up
```

## Usage
There is currently only one endpoint, `GET /remoteness-area` that performs a remoteness area look-up when provided latitude and longitude coordinates:
```
GET http://localhost:8080/remoteness-area?latitude=-27.003687&longitude=150.6013999&system=WGS84
```
```
{
    "coordinates": {
        "latitude": -27.003687,
        "longitude": 150.6013999,
        "system": {
            "name": "WGS84",
            "srid": 4326
        }
    },
    "remotenessArea": {
        "code": 32,
        "state": {
            "name": "QUEENSLAND",
            "code": 3
        },
        "category": {
            "name": "OUTER_REGIONAL_AUSTRALIA",
            "code": 2
        }
    }
}
```
*NB: By default, the service binds to port `8080` on the host so the examples above has assumed a hostname of `localhost:8080`.*

The endpoint accepts 3 manadatory query parameters: `latitude`, a decimal value between -90.0 and 90.0 (inclusive); `longitude`, a decimal value between -180.0 and 180.0 (inclusive); and `system`, a string specifiying which of the two valid spatial reference systems the coordinates are in (`WGS84` and `GDA94`).

If the coordinates fall within a defined remotness area, the response contains a copy of the coordinates passed through the query parameters and the remoteness area assigned to those coordinates. Otherwise the service will return a `400: BAD_REQUEST` response.

The `remotnessArea` object contains the raw two-digit code used to designate the remoteness area, the corresponding state name and code, and the category name and code. These values are all based on the definitions described in the *Australian Statistical Geography Standard (ASGS): Volume 5 - Remoteness Structure* [definitions document](https://www.abs.gov.au/ausstats/abs@.nsf/Latestproducts/1270.0.55.005Main%20Features15July%202016?opendocument&tabname=Summary&prodno=1270.0.55.005&issue=July%202016&num=&view=). A list of all the possible returned values can be found in the within the codebase, on the `RemotenessStructure` class.
