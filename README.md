# Quarkus Gateway Service

A simple API gateway service built with Quarkus that routes requests to the Task and File Services.

## Environment Variables

This service requires the following environment variables:

| Variable | Description |
|----------|-------------|
| `KEYCLOAK_URL` | Base URL of your Keycloak server |
| `KEYCLOAK_REALM` | Keycloak realm name |
| `KEYCLOAK_CLIENT_ID` | Client ID for your application in Keycloak |
| `KEYCLOAK_CLIENT_SECRET` | Client secret for your application in Keycloak |
| `KEYCLOAK_SCOPE` | OAuth scope for the client |
| `TASK_API_URL` | URL of the Task Service API |
| `FILE_API_URL` | URL of the File Service API |

## Dependencies

- Task Service must be running and accessible at the URL specified in `TASK_API_URL`
- File Service must be running and accessible at the URL specified in `FILE_API_URL`

## Quick Start

1. Set the environment variables listed above
2. Ensure Task Service and File Service are running
3. Build the application: `./mvnw clean package`
4. Run the application: `./mvnw quarkus:dev`

## API Endpoints

The Gateway Service proxies requests to the Task and File Services, as follows:

### Task Service Endpoints

| Method | Endpoint                  | Description |
|--------|---------------------------|-------------|
| GET | `/api/gateway/tasks`      | List all tasks |
| GET | `/api/gateway/tasks/{id}` | Get a specific task by ID |
| POST | `/api/gateway/tasks`      | Create a new task |
| PUT | `/api/gateway/tasks/{id}` | Update an existing task |
| DELETE | `/api/gateway/tasks/{id}` | Delete a task |

### File Service Endpoints

| Method | Endpoint                              | Description |
|--------|---------------------------------------|-------------|
| POST | `/api/gateway/document/task/{taskId}` | Upload a file to a specific task |
| GET | `/api/gateway/document/task/{taskId}` | Get all files associated with a task |
| GET | `/api/gateway/document/{taskFileId}`  | Get details of a specific file |


All endpoints require authentication via Keycloak.