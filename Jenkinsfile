pipeline {
    agent {
				label 'docker-agent'
  	}

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
                sh 'mvn clean install'
            }
        }
        stage('Build  & Push Docker Image') {
        	
  			steps {
                script {
                    dockerImage = docker.build 'akhilkvpv88/nagp-devops-assignment:v2'
                    docker.withRegistry('',dockerhubCredential) {
                        dockerImage.push("v2");  
                    }
                }

            }
                                        
        }

        

    }

}
