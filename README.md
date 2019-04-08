It's maven project.

## Install Dependencies
Use maven to install all dependencies.

## Run
Run project using Java 1.8 and Grizzly

command:
/opt/maven/apache-maven-3.5.4/bin/mvn clean compile exec:java

## Check
Use http://localhost:8080/management/greeting URL

# Headers
### Part of nginx config
Strict-Transport-Security: max-age=31536000; includeSubDomains
Content-Security-Policy:
X-Frame-Options: SAMEORIGIN
X-XSS-Protection: 1; mode=block
X-Content-Type-Options: nosniff
Referrer-Policy:
Feature-Policy:
X-Download-Options: noopen
X-Powered-By: api.test.com
X-Runtime:

### Cross Domain Access
