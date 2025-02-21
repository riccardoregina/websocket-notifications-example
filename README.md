## How to use
1. Run the Spring application
2. Connect to `http://localhost:8080/signup`, signup a user and login.
3. Make a POST request on path `http://localhost:8080/listings` with a plain string in the body. 
At this point, you will see a new notification appear on the frontend.
4. (Optional) You can fetch the user's notification by making a GET request on path `http://localhost:8080/notifications/{user-id}`.
You will need the user-id: take it from the h2 console, available at `http://localhost:8080/h2-console` and insert the
h2 credentials specified in `src/main/resources/application.properties`.