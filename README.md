# ImageStore
This simple Spring Boot app, handles upload of images with meta data, by exposing the following REST endpoints to
- Get all images.
- Post image.
- Delete image.

The uploaded images are kept in an array, in the controller (no use of JPA).
Note: When the server app is stopped, the data is cleared.
