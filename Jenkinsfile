pipeline {
    agent any
    tools {
        maven 'Maven3' // Matches your exact Jenkins global configuration name
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
}
