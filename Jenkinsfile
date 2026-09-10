pipeline {
    agent any
    stages {
        stage("Compile Project") {
            steps {
                bat "javac -d target/classes src/main/java/com/loan/system/model/*.java src/main/java/com/loan/system/service/*.java src/test/java/com/loan/system/service/*.java"
            }
        }
        stage("Run Automated Tests") {
            steps {
                bat "java -cp target/classes com.loan.system.service.CreditAssessmentTest"
            }
        }
    }
}
