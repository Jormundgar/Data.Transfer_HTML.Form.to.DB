
## Data Transfer (from HTML Form to DB)

>Using: `PostgreSQL`, `Lombok`, `JSP`, `Servlet API`, `JSTL`

For creating table for your DB please use `sql_script.sql` | Settings for your DB set in `application.properties`

### Pattern MVC 

- `View` JSP files
- `Controller` Servlets
- `DTO` From Servlet layer to Service layer 
- `Service` Validation, mapping and creation Entity
- `DAO` SQL request and saving object to DB
  

### Description

- `../info` - target page
- This project is a web application that features an authorization system for user sessions. Upon accessing the application, the user's session is checked for an active session. If no session exists, the user is redirected to the `../login` page. Once on the login page, the user enters their login and password. The application sends a request to the database to check if the user exists. If the user does not exist, an error message is displayed, indicating that the login or password is incorrect. In such a scenario, the user is given the option to register for a new account `../registration`. Upon successful registration, the user is redirected back to the login page.
- If the correct login and password are entered, the user is granted access to the target page. The application includes a `Sign out` button for users to end their session. Furthermore, the application provides users with a `language selection feature`, with English, Russian, and Hebrew as available options.

### Commits:
+ `v.1.0` 
+ `v.2.0`
