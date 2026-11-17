TOURIST RECORD UPDATE WITH TOKEN VALIDATION

Requirements:
- Java 17 or newer
- Maven (or import as an Existing Maven Project in Spring Tool Suite)

Import into STS:
1. Extract this ZIP file.
2. Open STS: File > Import > Maven > Existing Maven Projects.
3. Browse to the extracted tourist-token-validation folder.
4. Select the pom.xml project and click Finish.
5. Wait for Maven dependencies to download.
6. Right-click TouristApplication.java > Run As > Spring Boot App.

Swagger:
http://localhost:8080/swagger-ui/index.html

Sample existing record:
ID: 1
Name: Arun
Place: Chennai
Email: arun@example.com

Test PUT /api/tourist/{id}:
Path ID: 1
Header:
token: my-secret-token

JSON body:
{
  "name": "Jaswitha",
  "place": "Hyderabad",
  "email": "jaswitha@gmail.com"
}

Expected response: HTTP 200
Tourist updated successfully

Wrong or missing token: HTTP 401
Unknown tourist ID: HTTP 404

Note: This is a learning demo with an in-memory H2 database and a fixed demonstration token.
The data resets when the application restarts. Do not use this token approach in production.
