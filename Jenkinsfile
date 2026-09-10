pipeline {
    agent any
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
