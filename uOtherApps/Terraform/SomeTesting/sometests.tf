provider "aws" {
  access_key = ""
  secret_key = ""
  region = "eu-north-1"
}

resource "aws_instance" "my_testServer" {
  ami = "ami-1dab2163"
  instance_type = "t3.micro"

  tags = {
    Name = "Ubuntu Server Test"
    name = "sometest"
  }
}

resource "aws_instance" "my_serverTest" {
  ami = "ami-9f35bde1"
  instance_type = "t3.micro"

  tags = {
    Name = "Red Hat Linux"
    Owner = "Алекс"
    Project = "просто балюсь"
  }
}