
variable "project_name" {
  type    = string
  default = "scalable-microservices"
}

variable "aws_region" {
  type    = string
  default = "ap-south-2"
}

variable "availability_zone" {
  type    = string
  default = "ap-south-2a"
}

variable "vpc_cidr" {
  type    = string
  default = "10.0.0.0/16"
}

variable "subnet_cidr" {
  type    = string
  default = "10.0.1.0/24"
}

variable "instance_type" {
  type    = string
  default = "t3.small"
}

variable "key_name" {
  type    = string
  default = "jenkins-key"
}

variable "admin_cidr" {
  type = string
}
