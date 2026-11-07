
# System Architecture – Scalable Microservices DevOps Project

## 1. Project Overview

This project aims to design and implement a scalable microservices-based e-commerce application supported by DevOps automation.

The objective is to demonstrate how an application can be developed, containerized, deployed, and managed using modern DevOps tools and cloud infrastructure.

The application will initially contain four independent microservices.

## 2. Application Architecture

The application consists of the following services:

| Microservice | Responsibility |
|---|---|
| User Service | User registration and user information |
| Product Service | Product catalogue and product information |
| Order Service | Order creation and order management |
| Payment Service | Simulated payment processing |

Each microservice will be developed using Java and Spring Boot.

Maven will manage dependencies, compile the source code, and execute tests.

## 3. Application Communication

The microservices will expose REST APIs.

The application workflow:

1. Customer requests product information.
2. User Service handles customer information.
3. Product Service retrieves product details.
4. Order Service creates an order.
5. Payment Service processes a simulated payment.

Each service will own its application data and database schema.

## 4. DevOps Architecture

The project uses the following tools:

| Tool | Responsibility |
|---|---|
| Git | Version control |
| GitLab | Source repository and container registry |
| Jenkins | CI/CD automation |
| Maven | Java application build |
| Docker | Application containerization |
| Terraform | Infrastructure provisioning |
| AWS | Cloud infrastructure |
| Ansible | Server configuration management |
| Kubernetes | Container orchestration |
| Helm | Kubernetes application packaging |

GitHub will be used to publish the project as a public portfolio repository.

GitLab will provide the repository integration and container registry required by the CI/CD workflow.

## 5. CI/CD Workflow

1. Developer pushes code to GitLab.
2. GitLab triggers Jenkins through a webhook.
3. Jenkins checks out the source code.
4. Maven compiles and tests the application.
5. Docker builds the application image.
6. Jenkins pushes the image to GitLab Container Registry.
7. Kubernetes pulls the image.
8. Jenkins deploys the updated microservice.
9. Deployment status is verified.

Merge requests will trigger validation pipelines. Deployment to the main environment will require a successful merge and any configured approval.

## 6. AWS Infrastructure Architecture

Terraform will provision the required AWS infrastructure.

Planned components:

- VPC
- Public and private subnets
- Internet Gateway
- NAT Gateway where required
- Route tables
- Security Groups
- EC2 instance for Jenkins
- Amazon EKS
- Application Load Balancer
- Amazon RDS
- Amazon S3
- Route 53

Terraform modules will be used to organize reusable infrastructure configurations.

## 7. Configuration Management

Ansible will automate the configuration of EC2-based infrastructure.

Planned activities:

- Java installation
- Jenkins installation
- Required package installation
- Jenkins host configuration
- Service management

## 8. Kubernetes Architecture

Kubernetes will manage the application containers.

Planned resources:

- Namespace
- Deployments
- Pods
- Services
- ConfigMaps
- Secrets
- Gateway API
- Horizontal Pod Autoscaler

Helm will be used to package and manage application deployments.

## 9. Scalability and Reliability

The project will demonstrate:

- Independent microservice scaling
- Kubernetes self-healing
- Rolling updates
- Health checks
- Resource requests and limits
- Horizontal Pod Autoscaling
- Load balancing
- Infrastructure scalability

## 10. Deployment Environments

Local development and initial testing will use Docker and Minikube.

The final cloud deployment will use AWS infrastructure and Amazon EKS.

## 11. Expected Outcome

A working microservices-based application with an automated CI/CD pipeline, reusable Infrastructure as Code, configuration management, and Kubernetes-based deployment.

The final deliverables will include source code, infrastructure configurations, deployment manifests, architecture diagrams, documentation, and a project demonstration.
