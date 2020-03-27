provider "aws" {
  access_key = "AKIAIKLEM5BWGN54S25A"
  secret_key = "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"
  region = "eu-north-1"
}

resource "aws_instance" "Ansible_master" {
  ami = "ami-006cda581cf39451b"
  instance_type = "t3.micro"
  vpc_security_group_ids = ["${aws_security_group.fullServerSecurity.id}"]
  key_name = "ansible1"

  tags = {
    name = "Ansible Master"
  }
}

resource "aws_instance" "Full_Server_WithOut_Script" {
  count = 3
  ami = "ami-006cda581cf39451b"
  instance_type = "t3.micro"
  vpc_security_group_ids = ["${aws_security_group.fullServerSecurity.id}"]
  key_name = "ansible2"

  tags = {
    name = "ansible Puppet"
  }
}


resource "aws_security_group" "fullServerSecurity" {
  name        = "fullAppSecurity"
  description = "my sec group 1 "

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port       = 0
    to_port         = 0
    protocol        = "-1"
    cidr_blocks     = ["0.0.0.0/0"]
  }
}
