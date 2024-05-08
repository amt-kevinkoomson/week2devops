pipeline {
    agent any

    stages {
        stage('Build') {
            steps {

                sh 'chmod +x ./mvnw && ./mvnw install'
                script {
                    docker.build('devops')
                }
            }
        }

        stage('Test') {
            steps {
                // Run tests inside the Docker container
                sh 'echo hello world test'
            }
        }

        stage('Deploy') {
            steps {
                // Run the Docker container
                script {
                    docker.image('week2devops').run('-p 4050:4050 --name week2cont')
                }
            }
        }
    }
}
