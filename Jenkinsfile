pipeline {
    agent any // You can specify a specific agent label if needed

    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code from a Git repository
                checkout scm
            }
        }

        stage('Test') {
            steps {
                // Run 'mvn clean compile test' using the Maven tool
                sh 'docker image'
            }
        }

        stage('Build') {
            steps {
                // Run 'mvn clean compile test' using the Maven tool
                sh 'docker build -t bm:3.0 .'
            }
        }
    }

    post {
        success {
            // This block is executed if the build is successful
            echo 'Build and tests have passed.'
        }
        failure {
            // This block is executed if the build fails
            echo 'Build or tests have failed.'
        }
    }
}