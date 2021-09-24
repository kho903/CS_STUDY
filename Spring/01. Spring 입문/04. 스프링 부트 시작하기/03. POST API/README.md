# JSON
- string : value
- number : value
- boolean : value {}
- object : value
- array : value [ ]
- 보통은 snake case, 가끔 camel case로 제공되는 경우도 있다.
```json
{
  "phoneNumber" : "", 
  "phone_number" : "010-1111-2222",
  "age" : 10,
  "isAgree" : false,
  "account": {
    "email" : "a@gmail.com",
    "password": "1234"
  }
}
```
// user 조회하는 경우
```json
{
  "user_list" : [
    {
      "account" : "abcd",
      "password" : "1234"
    },
    {
      "account" : "aaaa",
      "password" : "1111"
    },
    {
      "account" : "bbbb",
      "password" : "2222"
    }
  ]
}
```
```json
{
  "account" : "abcd",
  "password" : "1234"
}
```

- 예제
```json
{
  "account" : "",
  "email" : "",
  "password" : "",
  "address" : ""
}
```

## Annotation
- @RestController : REST API 설정
- @RequestMapping : 리소스를 설정 (method로 구분 가능)
- @PostMapping : POST Resource 설정
- @RequestBody : Request Body 부분 Parsing
- @JsonProperty : json naming
- @JsonNaming : class json naming
