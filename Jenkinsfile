pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'chmod +x ./mvnw && ./mvnw install'
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
                    // Pull Docker image
                    def dockerImage = 'localhost:5000/week2devops'
                    docker.image(dockerImage).pull()
                    // Run Docker container
                    def containerId = docker.image(dockerImage).run("--user root --rm -it -v ${pwd()}:/mnt --name devops")
                    // Execute command in running container
                    sh "docker exec devops curl localhost:4050"
                }
            }
        }
    }
}
