# team-spurs-server

### About Packages in `cse416.teamspurs.server`
1. `config` -  files responsible for configuring the server (ex: CORS settings)
2. `constant` - files where enums are stored
3. `controller` - files where controller logic is defined for each available endpoint
4. `converter` - files responsible for converting strings into enums when a request reaches a controller
5. `dao` - files where **complex or custom** Mongo operations are implemented (ex: aggregations with custom non-model-like projections)
6. `exception` - files where exception handling are stored
7. `model` - files where Mongo models are located
8. `projection` - files that contains structures Mongo projections can use
9. `repository` - files where **simple** Mongo operations are defined
10. `service` - files where service files are stored

### Terminology
1. **DAO** - Data Access Object
    > we use them to define complex or custom Mongo operations that are not supported by MongoRepository out of the box
2. **DTO** - Data Transfer Object
    > we use them to transfer non-model-like data (they do not resemble internal models) between layers 
