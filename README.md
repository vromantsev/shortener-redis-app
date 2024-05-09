How to use application:

Run Redis in Docker using the following command:

`docker run -d --name redis-stack-server -p 6379:6379 redis/redis-stack-server:latest`

<b>Example of POST request:</b>
###
<b>POST</b> `http://localhost:8080/api/urls`

`Content-Type: application/json`

{
  "initialUrl": "https://bobocode.com"
}`

<b>Example of GET request:</b>
###
<b>GET</b> `http://localhost:8080/api/urls/qsxiebDvhj`
