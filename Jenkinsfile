pipeline {
    agent any

	tools {
	    maven 'Maven'
	}
	
	environment {
		dockerhubCredential = 'dockerhubCredential'
	}

    
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }

        }
        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build  & Push Docker Image') {
        	agent {
				label 'docker-agent'
  			}
  			steps {
                script {
                    dockerImage = docker.build 'akhilkvpv88/nagp-devops-assignment:v1'
                    docker.withRegistry('',dockerhubCredential) {
                        dockerImage.push("v1");  
                    }
                }

            }
                                        
        }
        
        stage('Run Application') {
        	agent {
				label 'docker-agent'
  			}
  			steps {
                sh 'docker-compose up'
            }
                                        
        }

        

    }

}
