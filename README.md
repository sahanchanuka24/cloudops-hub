# CloudOps Hub

A DevOps portfolio project demonstrating REST API development, Docker containerization, CI/CD automation, container image publishing, and Infrastructure as Code (IaC) using Terraform and AWS.

## Project Overview

CloudOps Hub is a Java 21 and Spring Boot REST API application built to demonstrate practical DevOps and cloud engineering skills.

The application is containerized with Docker, tested through GitHub Actions, and published to GitHub Container Registry (GHCR). Terraform configuration is included to define AWS networking resources.

The API has been deployed as a Docker container on an existing Amazon EC2 instance. Both the application status endpoint and Spring Boot health endpoint were tested successfully during deployment verification.

## Architecture

```text
Developer
   |
   v
GitHub Repository
   |
   v
GitHub Actions CI
   |-- Build and Test
   |-- Docker Image Build
   |-- Terraform Validation
   |
   v
GitHub Container Registry
   |
   v
Amazon EC2 Instance
   |
   v
Docker Container
   |
   v
Spring Boot REST API
   |-- GET /api/v1/status
   |-- GET /actuator/health
```

## Technology Stack

| Category | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot |
| Build Tool | Maven |
| Containerization | Docker |
| CI/CD | GitHub Actions |
| Container Registry | GitHub Container Registry |
| Infrastructure as Code | Terraform |
| Cloud Platform | Amazon Web Services |
| Version Control | Git and GitHub |

## Key Features

### 1. REST API

- Built a REST API using Spring Boot.
- Implemented an application status endpoint.
- Enabled Spring Boot Actuator health monitoring.
- Added automated application tests.

### 2. Docker Containerization

- Created a Docker image for the application.
- Configured container health checks.
- Published the container image to GitHub Container Registry.
- Deployed and ran the container on an AWS EC2 instance.

### 3. CI/CD with GitHub Actions

The repository includes workflows for:

- Application build and test automation.
- Docker image building and publishing.
- Terraform formatting and validation.
- Terraform configuration planning checks.

### 4. Infrastructure as Code

Terraform configuration is provided for AWS networking resources, including:

- Virtual Private Cloud (VPC).
- Public subnet.
- Internet Gateway.
- Public route table and route association.
- Security group rules.

The Terraform configuration has been validated. The networking resources defined in Terraform have not been applied to AWS; the API deployment uses an existing EC2 instance.

## Deployment Status

- [x] Spring Boot REST API implemented.
- [x] Automated tests and CI workflow configured.
- [x] Docker image built.
- [x] Docker image published to GHCR.
- [x] Terraform configuration validated.
- [x] API container deployed to an existing AWS EC2 instance.
- [x] Application status endpoint tested successfully.
- [x] Actuator health endpoint returned `UP`.
- [x] Temporary public access to port 8080 removed after testing.
- [ ] HTTPS and domain configuration.
- [ ] Automated AWS deployment through GitHub Actions.
- [ ] Terraform-managed AWS networking deployment.

**Important:** The API was successfully tested through the EC2 public IP during a temporary HTTP test. Public access to port 8080 was subsequently removed. The API should not currently be considered publicly accessible.

## API Endpoints

### Application Status

`GET /api/v1/status`

Example response:

```json
{
  "project": "CloudOps Hub",
  "status": "UP",
  "message": "CloudOps Hub API is running"
}
```

### Application Health

`GET /actuator/health`

Example response:

```json
{
  "status": "UP"
}
```

## Run Locally

### Prerequisites

- Git
- Java 21
- Docker
- Internet access to download dependencies

### Clone the Repository

```bash
git clone https://github.com/sahanchanuka24/cloudops-hub.git
cd cloudops-hub
```

### Run Tests

```bash
./mvnw test
```

### Build the Application

```bash
./mvnw package
```

### Run with Spring Boot

```bash
./mvnw spring-boot:run
```

### Test the API

```bash
curl -i http://localhost:8080/api/v1/status
```

```bash
curl -i http://localhost:8080/actuator/health
```

### Build the Docker Image

```bash
docker build -t cloudops-hub-api:latest .
```

### Run the Docker Container

```bash
docker run --rm -p 8080:8080 cloudops-hub-api:latest
```

## Pull the Published Docker Image

The published image is available from GitHub Container Registry:

```bash
docker pull ghcr.io/sahanchanuka24/cloudops-hub:latest
```

Run the image locally:

```bash
docker run --rm -p 8080:8080 \
  ghcr.io/sahanchanuka24/cloudops-hub:latest
```

Then test:

```bash
curl http://localhost:8080/api/v1/status
```

## Terraform Validation

Terraform configuration is located in `infra/terraform/`.

```bash
cd infra/terraform
terraform fmt -recursive
terraform init -backend=false
terraform validate
terraform plan
```

Review the planned changes, AWS permissions, and potential costs before applying infrastructure changes.

**Note:** `terraform init -backend=false` is suitable for configuration validation workflows. It does not configure remote state or verify a plan against deployed AWS infrastructure.

## Repository Structure

```text
cloudops-hub/
├── .github/
│   └── workflows/
│       ├── ci.yml
│       ├── publish-image.yml
│       ├── terraform-ci.yml
│       └── terraform-plan.yml
├── infra/
│   └── terraform/
│       ├── main.tf
│       ├── outputs.tf
│       ├── provider.tf
│       ├── variables.tf
│       ├── versions.tf
│       └── .terraform.lock.hcl
├── Dockerfile
├── pom.xml
├── mvnw
└── README.md
```

## Skills Demonstrated

- Java and Spring Boot REST API development.
- Automated testing.
- Docker image creation and container execution.
- GitHub Actions CI/CD.
- GitHub Container Registry.
- AWS EC2 deployment.
- AWS networking fundamentals.
- Terraform and Infrastructure as Code.
- Git-based version control.

## Future Improvements

- Configure HTTPS using a reverse proxy and a domain name.
- Automate deployment through GitHub Actions with AWS OIDC authentication.
- Configure secure remote Terraform state.
- Improve application logging, monitoring, and alerting.
- Implement deployment verification and rollback procedures.
- Add architecture diagrams and deployment evidence.

## Author

**Sahan Chanuka**

- GitHub: https://github.com/sahanchanuka24
- Repository: https://github.com/sahanchanuka24/cloudops-hub
