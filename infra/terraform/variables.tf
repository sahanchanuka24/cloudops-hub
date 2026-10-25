variable "aws_region" {
  description = "AWS region for CloudOps Hub"
  type        = string
  default     = "us-east-1"
}

variable "vpc_cidr" {
  description = "CIDR block for the CloudOps Hub VPC"
  type        = string
  default     = "10.20.0.0/16"
}

variable "public_subnet_cidr" {
  description = "CIDR block for the public subnet"
  type        = string
  default     = "10.20.1.0/24"
}

variable "project_name" {
  description = "Project name used in AWS resource names"
  type        = string
  default     = "cloudops-hub"
}
