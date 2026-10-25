# CloudOps Hub

A DevOps portfolio project demonstrating REST API development, Docker containerization, CI/CD automation, container image publishing, and Infrastructure as Code (IaC) with Terraform for AWS networking.

## Project Overview

CloudOps Hub is a Spring Boot REST API application packaged with Docker and automated using GitHub Actions. The project includes Terraform configuration for defining AWS network infrastructure.

The goal is to demonstrate practical skills in application development, containerization, automated testing, CI/CD pipelines, and cloud infrastructure provisioning.

## Technology Stack

- **Programming Language:** Java 21
- **Framework:** Spring Boot
- **Build Tool:** Maven
- **Containerization:** Docker
- **CI/CD:** GitHub Actions
- **Container Registry:** GitHub Container Registry (GHCR)
- **Infrastructure as Code:** Terraform
- **Cloud Platform:** Amazon Web Services (AWS)
- **Version Control:** Git and GitHub

## Key Features

### 1. REST API

- Status endpoint: `GET /api/v1/status`
- Application health endpoint: `/actuator/health`
- Automated application tests

### 2. Docker Containerization

- Docker image build configuration
- Container health checks
- Containerized application execution

### 3. CI/CD Automation

GitHub Actions workflows automate the following tasks:

- Application build and test execution
- Docker image publishing to GHCR
- Terraform formatting and validation
- Terraform configuration plan workflow

### 4. Terraform Infrastructure

The Terraform configuration defines the following AWS networking resources:

- Virtual Private Cloud (VPC)
- Public subnet
- Internet Gateway
- Public route table and route association
- Security group rules for HTTP and HTTPS traffic

**Current deployment status:** Terraform configuration and GitHub Actions checks have been validated. AWS infrastructure deployment has not yet been completed.

## Run the Application Locally

### Prerequisites

- Java 21
- Git
- Docker
- Internet connection for downloading dependencies

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

### Start the Application

```bash
./mvnw spring-boot:run
```

### Test the API

Open another terminal and execute:

```bash
curl http://localhost:8080/api/v1/status
```

Check application health:

```bash
curl http://localhost:8080/actuator/health
```

### Build the Docker Image

```bash
docker build -t cloudops-hub-api .
```

### Run the Docker Container

```bash
docker run --rm -p 8080:8080 cloudops-hub-api
```

## Terraform Validation

Navigate to the Terraform directory:

```bash
cd infra/terraform
```

Format the configuration:

```bash
terraform fmt -recursive
```

Initialize Terraform:

```bash
terraform init -backend=false
```

Validate the configuration:

```bash
terraform validate
```

Review the proposed infrastructure changes:

```bash
terraform plan
```

Review AWS credentials, infrastructure changes, and potential costs before deploying resources.

## Project Structure

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
│       └── versions.tf
├── Dockerfile
├── pom.xml
└── README.md
```

## Skills Demonstrated

- Java and Spring Boot
- REST API development
- Automated testing
- Docker containerization
- Git and GitHub
- GitHub Actions CI/CD
- GitHub Container Registry
- Terraform
- AWS networking fundamentals
- Infrastructure as Code

## Future Improvements

- Configure secure GitHub Actions authentication to AWS using OIDC.
- Configure remote Terraform state with appropriate access controls.
- Deploy the application to an AWS hosting service.
- Implement application monitoring and centralized logging.
- Extend the CI/CD pipeline with automated deployment.

## Author

**Sahan Chanuka**

GitHub: https://github.com/sahanchanuka24

Project Repository: https://github.com/sahanchanuka24/cloudops-hub
