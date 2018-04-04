

### client_secrect 만들기

- com.femto.auth.config.BeanConfigTest 참고.

```mysql
use community_db;
INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`)
VALUES ('game', 'oauth2-resource', '$2a$10$9TbTlKmHkcIfcVYegLxvheYvYBPIyU63E.FhmkE4CYaxlAYjgj4dy', 'read', 'authorization_code,password,refresh_token,implicit', null, 'ROLE_CLIENT, ROLE_TRUSTED_CLIENT', 900, null, '{}', null);

```



# Spring security OAuth2


## /oauth/token

/oauth/token 엔드포인트는 클라이언트 인증 후 access_token을 발급한다. client_id, client_secret(Basic Auth로 요청), grant_type이 필수 파라메터로 요구된다.

- request token
```bash
 curl -u client:client localhost:9999/oauth/token \
     -d grant_type=password \
     -d client_id=client \
     -d username=<email> \
     -d password=<password>
```
     
- response
```json
{
  "access_token": "ce1714b1-1511-4862-b6b0-25ac48a0af4d",
  "token_type": "bearer",
  "refresh_token": "de9f3df8-d0e2-4396-8381-3524254001ee",
  "expires_in": 898,
  "scope": "read"
}
```

## /oauth/check_token


/oauth/check_token 엔드포인트는 요청 파라메터의 access_token의 유효 여부와 유효시 해당 클라이언트 정보를 응답한다.(현재 막아놨음)

- request

```bash
curl -X POST 'http://localhost:9999/oauth/check_token' \
    -d 'token=ce1714b1-1511-4862-b6b0-25ac48a0af4d'
```

- response

```json
{
  "aud": [
    "oauth2-resource"
  ],
  "exp": 1519713753,
  "user_name": "n74rqxzi6641f98bd8736f20916371235bc3899d",
  "client_id": "client",
  "scope": [
    "read"
  ]
}
```


## refresh token

```bash
curl -v --data "grant_type=refresh_token&client_id=femto&refresh_token=ea89554f-0c28-4eeb-a790-a0bdc593958f" http://192.168.222.45:9999/oauth/token
```


### The most important fields from the oauth_client_details we should focus on are:

- client_id – to store the id of newly registered clients
- client_secret – to store the password of clients
- access_token_validity – which indicates if client is still valid
- authorities – to indicate what roles are permitted with particular client
- scope – allowed actions, for example writing statuses on Facebook etc.
- authorized_grant_types, which provides information how users can login to the particular client (in our example case it’s a form login with password)

