# pruebaTecnica - rama test2 (correcta a falta implementar controller Party)
creacion API REST completa de un proyecto

## URL
```
pruebatecnica-test2.herokuapp.com
```
## Cadena conexion clearDB Heroku (apunto a la misma bbdd que rama prueba)
mysql://be28341129a6ad:75a46995@eu-cdbr-west-03.cleardb.net/heroku_21096d0df0eb796?reconnect=true

## API GAME

#### GET
```
pruebatecnica-test2.herokuapp.com/api/games
pruebatecnica-test2.herokuapp.com/api/games/{id}
pruebatecnica-test2.herokuapp.com/api/games/{title}
```

#### POST
```
pruebatecnica-test2.herokuapp.com/api/games
```
#### PUT
```
pruebatecnica-test2.herokuapp.com/api/games/{id}
```
#### DELETE
```
pruebatecnica-test2.herokuapp.com/api/games/{id}
```

## API Message

#### GET
```
pruebatecnica-test2.herokuapp.com/api/message
pruebatecnica-test2.herokuapp.com/api/message/{id}
pruebatecnica-test2.herokuapp.com/api/message/player  - con body
pruebatecnica-test2.herokuapp.com/api/message/party   - con body

```
#### POST
```
pruebatecnica-test2.herokuapp.com/api/message
```
#### PUT
```
pruebatecnica-test2.herokuapp.com/api/message/{id}
```
#### DELETE
```
pruebatecnica-test2.herokuapp.com/api/message/{id}
```

## API Player
#### GET
```
pruebatecnica-test2.herokuapp.com/api/player/
pruebatecnica-test2.herokuapp.com/api/player/{id}
pruebatecnica-test2.herokuapp.com/api/player/username/{username}
pruebatecnica-test2.herokuapp.com/api/player/nickname/{nickname}
pruebatecnica-test2.herokuapp.com/api/player/friends/   - con body
pruebatecnica-test2.herokuapp.com/api/player/party/     - con body
```
#### POST
```
pruebatecnica-test2.herokuapp.com/api/player
```
#### PUT
```
pruebatecnica-test2.herokuapp.com/api/player/{id}
```
#### DELETE
```
pruebatecnica-test2.herokuapp.com/api/player/{id}
```

## API Party - sin implementar el controllerParty
#### GET
#### POST
#### PUT
#### DELETE
