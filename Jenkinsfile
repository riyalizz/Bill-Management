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
            }
        }

       stage('Automation-Tests') {
            steps {
                // Checkout your source code from a Git repository
                //checkout scm
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
                bat  "docker run -p 8083:8083  1aeaccdf0bfb6a6c4edadfa07cc42ee9a2b74565102c8a7ab0f7de7a5c3543fe'
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
