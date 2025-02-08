SpringBoot app to showcase Java skills 
Endpoints: 
POST /authors - create a new author
GET /authors - get a page of authors (?size=<number of authors returned, ?page=<page number you want returned>)
GET /authors/{id} - get a specific author using their id
PUT /authors/{id} - full update for an author
PATCH /authors/{id} - partial update for an author
DELETE /authors/{id} - delete an author with id

GET /books - get a page of books (?size=<number of books returned, ?page=<page number you want returned>)
GET /books/{isbn} - get a specific book using their isbn
PUT /books/{isbn} - full update for an book
PATCH /books/{isbn} - partial update for an book
DELETE /books/{isbn} - delete an book with id
