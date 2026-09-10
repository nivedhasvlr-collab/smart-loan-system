pipeline {
    agent any
    tools {
        maven 'Maven3' 
    }
    stages {
        stage("Compile Project Source") {
            steps {
                bat "mvn clean compile"
            }
        }
        stage("Execute Automated Testing Suites") {
            steps {
                bat "mvn test"
            }
        }
    }
    post {
        always {
            // This line parses your project test metrics to draw the visual trends graphs automatically
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
