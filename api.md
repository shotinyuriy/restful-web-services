# RESTful web services

Users -* Posts

- Retrieve all Users 	- GET /users
- Create a User			- POST /users
- Retrieve one User		- GET /users/{id} -> /users/1
- Delete a User			- DELETE /users/{id} -> /users/1

- Retrieve all posts for a User - GET /users/{id}/posts
- Create a post for a User - POST /users/{id}/posts
- Details of a post - GET /users/{userId}/posts/{postId}
- Delete a post of a user - DELETE /users/{userId}/posts/{postId}