# multichoice-assessment
Multichoice Test Assessment

# MultiChoice Connected Video
# showmax.com  | now.dstv.com
__________________________________________


# Interview – Technical Assessment (Junior Java Developer – Backend)
# Your Requirement:
1. Create a repository, Commit your code to a GitHub repository (https://github.com/). Every
subsequent commit should be pushed to this repository. Invite the following participants
who will review your code:
 Justin.Reddy@multichoice.com
 phillip.makabe@multichoice.com
2. The REST Service must be built using Spring Boot Framework using the Spring Initializer that
will return responses in JSON format.
3. The root of the resource should be @RequestMapping(path = &quot;/customer&quot;)
4. You are required to build a REST Service must perform Crud operations for the following:
 INSERT a customer record into database
@PutMapping(&quot;/&quot;)
 UPDATE a customer Record into database
@PostMapping(path = &quot;/&quot;, consumes = &quot;application/json&quot;, produces = &quot;application/json&quot;)
 DELETE a customer Record from Database
@DeleteMapping(path = &quot;/{customernumber}&quot;, produces = &quot;application/json&quot;)
 GET a customer record by Customer Number
@GetMapping(path = &quot;/{customernumber}&quot;, produces = &quot;application/json&quot;)
 GET ALL Customers from database
@GetMapping(path = &quot;/&quot;, produces = &quot;application/json&quot;)
All data must be persisted to a local instance of MongoDb, no Authentication required:
spring.data.mongodb.uri=mongodb://localhost:27017/test-assessment

5. Write Unit tests and mock any calls to your database. Ensure all Rest Operations are
covered.

6. Provide some notes around the planning and technical decisions made during the
development of this service. Also, any ideas or features that could be added to this solution.
Your REST service should follow a Structure like the following (use this a guide, you don’t have to
build your solution exactly like this):
