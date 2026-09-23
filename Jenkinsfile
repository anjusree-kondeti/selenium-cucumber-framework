pipeline {
    agent any

    stages {
        stage('Build Validation') {
            steps {
                bat 'mvn clean compile'
            }
        }
    }
}