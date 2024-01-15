pipeline {
    agent any // You can specify a specific agent label if needed

    parameters {
        choice(
            name: 'ENVIRONMENT',
            choices: ['staging', 'qa', 'prod'],
            description: 'Select the target environment'
        )
    }

    stages {
        stage('Unit-Tests') {
            steps {
                // Checkout your source code from a Git repository
               // checkout scm
                echo 'run unit tests'
            }
        }

       stage('Automation-Tests') {
            steps {
                // Checkout your source code from a Git repository
                //checkout scm
                echo 'run automation tests'
            }
        }

        stage('Build') {
            steps {
                // Run 'mvn clean compile test' using the Maven tool
                bat "docker build -t bm:3.0 ."
            }
        }

        stage('Deploy') {
            when {
                expression { params.ENVIRONMENT != null }
                
            }
            steps {
                // Run 'mvn clean compile test' using the Maven tool
                bat  "docker run -p 8083:8083  1e00734507c2"
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
