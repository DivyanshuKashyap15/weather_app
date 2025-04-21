pipeline {
    agent any

    environment {
        IMAGE_NAME = 'divyanshu509/weather-app'
        DOCKER_HUB_CREDENTIALS = 'docker_smtp' // ✅ corrected ID
    }

    triggers {
        githubPush() // ✅ make sure webhook is set correctly
    }

    stages {
        stage('Clone Repo') {
            steps {
                git 'https://github.com/DivyanshuKashyap15/weather-app.git' // ✅ use your repo URL
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("${IMAGE_NAME}:latest")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_HUB_CREDENTIALS) {
                        dockerImage.push("latest")
                    }
                }
            }
        }
    }

    post {
        success {
            echo "✅ Image pushed to Docker Hub successfully!"
        }
        failure {
            echo "❌ Pipeline failed."
        }
    }
}
