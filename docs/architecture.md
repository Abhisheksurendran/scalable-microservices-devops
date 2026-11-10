# System Architecture – Scalable Microservices DevOps Project

## 1. Project Overview

This project demonstrates a Java Spring Boot microservices application supported by DevOps practices.

The application consists of four independent services and uses Docker, Jenkins, Kubernetes, Terraform and Ansible.

## 2. Application Architecture

| Microservice | Responsibility |
|---|---|
| User Service | User information |
| Product Service | Product catalogue |
| Order Service | Order management |
| Payment Service | Simulated payment processing |

All services expose REST APIs and use Java 17, Spring Boot and Maven.

Application data is currently stored in memory.

## 3. DevOps Tools

| Tool | Purpose |
|---|---|
| Git and GitHub | Version control |
| Jenkins | CI pipeline |
| Maven | Application build |
| Docker | Containerization |
| Docker Hub | Image registry |
| Kubernetes | Container orchestration |
| Minikube | Local Kubernetes cluster |
| Envoy Gateway | API routing |
| Terraform | AWS infrastructure provisioning |
| Ansible | Server configuration |

## 4. CI Pipeline

1. Source code is maintained in GitHub.
2. Jenkins checks out the repository.
3. Maven builds the four microservices.
4. Docker images are created.
5. Images are pushed to Docker Hub.
6. Kubernetes images are updated manually.

Jenkins does not currently perform automatic Kubernetes deployment.

## 5. Kubernetes Architecture

The four microservices run as Kubernetes Deployments with ClusterIP Services.

Envoy Gateway provides external HTTP routing.

| API Path | Backend |
|---|---|
| /api/users | User Service |
| /api/products | Product Service |
| /api/orders | Order Service |
| /api/payments | Payment Service |

## 6. AWS Infrastructure

Terraform provisions:

- VPC
- Public subnet
- Internet Gateway
- Route table
- Security group
- Ubuntu EC2 instance

The infrastructure is organized into reusable Terraform modules.

## 7. Configuration Management

Ansible configures the EC2 instance by installing:

- OpenJDK 21
- Maven
- Git
- Docker

The playbook also enables the Docker service.

## 8. Implementation Limitations

- Kubernetes deployment uses Minikube, not EKS.
- Container images are stored in Docker Hub.
- Kubernetes deployment is manually triggered.
- Application data is not persisted in a database.
- Payment processing is simulated.
- AWS infrastructure is a demonstration environment.
