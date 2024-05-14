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
                    sh "docker build -t devopsimage ."
                    // Run Docker container
                    docker.image(devopsimage).run("--user root --rm -it -v ${pwd()}:/mnt --name devops")
                    // Execute command in running container
                    sh "docker exec devops curl localhost:4050 || true"
                }
            }
        }
    }
}
