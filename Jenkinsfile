Set-Content -Path "Jenkinsfile" -Value 'pipeline {
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
}'; git add Jenkinsfile; git commit -m "fix: update jenkins pipeline logic to native maven declarations"; git push https://github.com main -f
