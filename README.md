# API Socket 
## CRUD (Create - Read - Update - Delete)
> Java Intranet API project using ``Sockets``.

* **JAVA 1.8**
* **MySQL 8.0.23**
* **MySQL Connector 8.0.23**
* **JetBrains - Intellij IDEA**

> **It can't work on JAVA (JKD) > 1.8** 

Before running the program, you need to config the database:
- inside ``src/ConnectionSingleton``, replace ``???`` by _your own database password_.
> ---
- The Client side can't work before the Server. So, you need first to start
    - ``api_socket_crud/src/AppAddProduct`` for adding a product
    - ``api_socket_crud/src/AppGetProduct`` for getting a product
    - ``api_socket_crud/src/AppGetProducts`` for getting a list of products
- Then, you can start the client by running:
    - ``api_socket_crud/client_api_socket/src/AppAddProduct`` for adding a product
    - ``api_socket_crud/client_api_socket/src/AppAddProduct`` for getting a product
    - ``api_socket_crud/client_api_socket/src/AppAddProduct`` for getting a list of products

> ### Enjoy it!