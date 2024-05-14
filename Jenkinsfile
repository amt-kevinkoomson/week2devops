pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
            sh 'chmod +x ./mvnw && ./mvnw install'
                script {
                    sh "docker stop devops || true"
                    sh "docker rm devops || true"
                    def dockerImage = 'localhost:5000/week2devops'

                }
            }
        }
        stage('Test') {
        sh 'echo Hello world'
        }
        stage('Deploy') {
            steps {
                docker.image(dockerImage).pull()
                def containerId = docker.image(dockerImage).run("--user root --rm -it -v ${pwd()}:/mnt --name devops")
                sh "docker exec devops 'curl localhost:4050'"
            }
        }
    }

}