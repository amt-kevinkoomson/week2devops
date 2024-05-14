pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    sh "docker stop devops || true"
                    sh "docker rm devops || true"
                    def dockerImage = 'localhost:5000/week2devops'

                }
            }
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