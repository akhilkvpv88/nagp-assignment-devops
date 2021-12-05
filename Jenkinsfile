pipeline {
    agent any
	tools {
	    maven 'Maven'
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
                sh 'mvn clean package -DskipTests'
            }
        }
        

    }

}
