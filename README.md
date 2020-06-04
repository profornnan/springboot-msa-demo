# springboot-msa-demo



## User DB 생성

```bash
$ docker run -p 8101:27017 --name mongo_user -d mongo
$ docker exec -it mongo_user bash
root@33ef515645b2:/# mongo
```



```sql
> use user
> db.user.insert(...);
```



Sample Data

```
{
    "userId" : "123",
    "userName" : "alpha"
}

{
    "userId" : "124",
    "userName" : "beta"
}
```





## Support DB 생성

```bash
$ docker run -p 8105:27017 --name mongo_support -d mongo
$ docker exec -it mongo_support bash
root@e6288e46e915:/# mongo
```



```sql
> use support
> db.support.insert(...);
```



Sample Data

```
{
    "userId" : "123",
    "artistId" : "6",
    "amount" : "500",
    "datetime" : "2020-05-22 00:00:00",
    "uid" : "artist_6_1590109842492"
}

{
    "userId" : "123",
    "artistId" : "5",
    "amount" : "100",
    "datetime" : "2020-04-27 20:21:37",
    "uid" : "artist_3_1590109842492"
}

{
    "userId" : "124",
    "artistId" : "3",
    "amount" : "1000",
    "datetime" : "2020-04-30 20:21:37",
    "uid" : "artist_3_1590109842567"
}
```



## User, Support 서버 실행

intelliJ로 각각의 프로젝트를 Open => Run



## 결과 확인



http://localhost:8002/api/user/

```json
[
  {
    "id": "5ed86536a01bb7ebcb069352",
    "userId": "123",
    "userName": "alpha"
  },
  {
    "id": "5ed8653fa01bb7ebcb069353",
    "userId": "124",
    "userName": "beta"
  }
]
```



http://localhost:8002/api/user/123

```json
{
  "id": "5ed86536a01bb7ebcb069352",
  "userId": "123",
  "userName": "alpha"
}
```



http://localhost:8005/api/support/

```json
[
  {
    "id": "5ed865d3386f066568245ced",
    "userId": "123",
    "artistId": "6",
    "amount": "500",
    "datetime": "2020-05-22 00:00:00",
    "uid": "artist_6_1590109842492",
    "userName": ""
  },
  {
    "id": "5ed865dc386f066568245cee",
    "userId": "123",
    "artistId": "5",
    "amount": "100",
    "datetime": "2020-04-27 20:21:37",
    "uid": "artist_3_1590109842492",
    "userName": ""
  },
  {
    "id": "5ed865e4386f066568245cef",
    "userId": "124",
    "artistId": "3",
    "amount": "1000",
    "datetime": "2020-04-30 20:21:37",
    "uid": "artist_3_1590109842567",
    "userName": ""
  }
]
```



http://localhost:8005/api/support/user/123

```json
[
  {
    "id": "5ed865d3386f066568245ced",
    "userId": "123",
    "artistId": "6",
    "amount": "500",
    "datetime": "2020-05-22 00:00:00",
    "uid": "artist_6_1590109842492",
    "userName": "alpha"
  },
  {
    "id": "5ed865dc386f066568245cee",
    "userId": "123",
    "artistId": "5",
    "amount": "100",
    "datetime": "2020-04-27 20:21:37",
    "uid": "artist_3_1590109842492",
    "userName": "alpha"
  }
]
```

