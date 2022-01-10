To run
1) In govtech folder -> `mvn spring-boot:run`
2) In new cmd window -> curl localhost:8080/users or curl localhost:8080/upload
    - Use query params to pass in parameters
    - Sample command - curl "localhost:8080/users?min=0&max=0&offset=0&limit=0&sort=NAME"
                     - curl -X POST "localhost:8080/upload?file=src/main/resources/upload_file_1.txt"
    - Supported params:     /users  - min       - float
                                    - max       - float
                                    - offset    - int
                                    - limit     - int
                                    - sort      - string. "NAME" or "SALARY" // ascending
                            /upload - filepath  - string
For unit testing



Background
Develop a web application with 2 endpoints, returning json content-type, HTTP_OK. If error: return body {"error":"msg"}
    - /users - GET - Return list of users in json
        - min=0.0 - min salary
        - max=4000.0 - max salary
        - offset=0 - starting offset
        - limit - num results
        - sort - "NAME" or "SALARY". Ascending
    - /upload - POST - Upload csv data. Return status
        - CSV has 2 columns
            - NAME - text
            - SALARY - Float, no dp requirement. > 0.0
        - First row ignored
        - If formatting error, return error (salary parse err, wrong # cols)
        - Salary <0 are skipped/ignored
        - NAME unique. Overwrite dupes

Acceptance criteria
1) Pre-load some data into the DB. Able to call /users on it
2) Upload properly structured CSV file, which will be used for /upload, and then /users
    Negative rows should be ignored in the input and 0.0 should be updated and returned.
3) Upload improperly structured CSV file. Should be rejected and /users unchanged
