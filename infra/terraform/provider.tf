provider "aws" {
  region = var.aws_region

  default_tags {
    tags = {
      Project     = "CloudOps-Hub"
      Environment = "Development"
      ManagedBy   = "Terraform"
    }
  }
}
