pipeline {
    agent any
    tools {
        maven 'Maven 3.x' // This injects the path automatically
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
