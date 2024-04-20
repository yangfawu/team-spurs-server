# team-spurs-server

### Connecting Codespace with Mongo
Run `curl ipinfo.io/ip` to get the IP address of the current Codespace container. Then whitelist this IP on MongoDB's Network Access. Note that if your Codespace goes down, it may be assigned a new IP by GitHub. 

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

### About Caching
We have caching enabled for a lot of service methods because the data we are returing is never changing. By default, we have confugred cache to be stored on the heap. This is fine, but can be a problem when the machine does not have decent RAM to store caches for things like our GeoJSON responses. For this reason, you can use the `.env` file to control whether or not caching should be used in your environment. Change the value of `CACHE_TYPE` to `none` for no caching. Change it to `simple` for caching.

### Terminology
1. **DAO** - Data Access Object
    > we use them to define complex or custom Mongo operations that are not supported by MongoRepository out of the box
2. **DTO** - Data Transfer Object
    > we use them to transfer non-model-like data (they do not resemble internal models) between layers 
