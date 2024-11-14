Tests can be executed by running pytest from a terminal in this folder.
- The unit tests check the component's methods directly
- The api tests check the component's HTTP API running on a FastAPI test server
- The integration tests check the HTTP API of the containerised component within the context of the all-up PYRAMIDRoutingSolution application (which must be run using docker compose).