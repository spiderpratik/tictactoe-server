# Game Server

Rest based Tic Tac Toe game server

Build / Run files in `run/`

API Contract
-

- Ping - Check if game server is alive \
  Request: GET /ping \
  Response: 200 OK \
  pong

- Register - Start a game \
  Request: POST /game \
  {"x":{"type":"human"}, "o":{"type":"bot", "server":"http://localhost:8001/game"}} \
  Response: 201 Created \
  {"id":"1"}

- Turn - Move played by a player \
  Request: POST /game/:id/:side?secret=xyz \
  {"move":"c3"} \
  Response: 202 Accepted

- Status - Get the current status of a game \
  Request: GET /game/:id \
  Response: 200 OK \
  {"position": "xo-/ox-/--x", "completed":true, "winner":"x",
  "moves": [{"x":"b2","o":"b1"}, {"x":"b2","o":"b1"}, {"x":"b2","o":"b1"}],
  "players":{"x":{"type":"human"}, "o":{"type":"bot", "server":"http://localhost:8001/game/1"}}}

- Deregister - Clear game \
  Request: DELETE /game/:id \
  Response: 204 No Content

