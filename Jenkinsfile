pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // sh 'chmod +x ./mvnw && ./mvnw install'
                sh "echo mock install"
                script {
                    // Stop and remove existing container
                    sh "docker stop devops || true"
                    sh "docker rm devops || true"
                }
            }
        }
        stage('Test') {
            steps {
                sh 'echo Hello world'
            }
        }
        stage('Deploy') {
            steps {
                script {
                    sh "docker build -t devopsimage ."
                    // Run Docker container
                    sh "docker run --name devops --publish 4050:4050 devopsimage"
                    // Execute command in running container
                    sh "docker exec devops curl localhost:4050 || true"
                }
            }
        }
    }
}
