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
        	
  			steps {
                script {
                    dockerImage = docker.build 'akhil/nagp-devops-assignment:v1'
                    docker.withRegistry('',dockerhubCredential);
					dockerImage.push("v1");                    
                }

            }
                                        
        }

        

    }

}
