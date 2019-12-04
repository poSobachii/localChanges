provider "aws" {
  access_key = ""
  secret_key = ""
  region = "eu-north-1"
}

resource "aws_instance" "Full_Server" {
  ami = "ami-0c947472aff72870d"
  instance_type = "t3.micro"
  vpc_security_group_ids = ["${aws_security_group.fullServerSecurity.id}"]
  key_name = "tests"
  user_data =<<EOF
#!/bin/bash
yum -y update
yum -y install httpd
myip=`curl http://169.254.169.254/lates/meta-data/local-ipv4`
echo "<h2>WebServer with IP: $myip</h2><br>Build by Terraform!" > /var/www/html/index.html
sudo service httpd start
chkconfig httpd on
EOF

  tags = {
    name = "Full Applicatin Test"
  }
}

resource "aws_instance" "Full_Server_WithOut_Script" {
  ami = "ami-0c947472aff72870d"
  instance_type = "t3.micro"
  vpc_security_group_ids = ["${aws_security_group.fullServerSecurity.id}"]
  key_name = "tests"

  tags = {
    name = "Full Applicatin Test"
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