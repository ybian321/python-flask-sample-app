terraform {
  backend "s3" {
    profile  = "default"
    bucket   = "terraform-state-file-devops"
    region   = "ap-southeast-2"
    key      = "aws/cloudwatch/custom-metrics-alarms/terraform.tfstate"
  }
}
