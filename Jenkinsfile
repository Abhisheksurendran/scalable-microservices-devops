
pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
        timestamps()
        disableConcurrentBuilds()
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
                echo 'Source code checked out successfully'
            }
        }

        stage('Maven Build and Test') {
            steps {
                sh '''
                    set -e
                    export MAVEN_OPTS="-Xmx384m -XX:MaxMetaspaceSize=192m"

                    for service in user-service product-service order-service payment-service
                    do
                        echo "Building $service"
                        mvn -B -f services/$service/pom.xml clean package
                    done
                '''
            }
        }

        stage('Build Docker Images') {
            steps {
                sh '''
                    set -e

                    for service in user-service product-service order-service payment-service
                    do
                        echo "Building Docker image for $service"

                        docker build \
                            -t $service:$BUILD_NUMBER \
                            -f services/$service/Dockerfile \
                            services/$service
                    done
                '''
            }
        }

        stage('Push Images to Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKERHUB_USER',
                    passwordVariable: 'DOCKERHUB_TOKEN'
                )]) {
                    sh '''
                        set +x
                        set -e

                        echo "$DOCKERHUB_TOKEN" | docker login \
                            -u "$DOCKERHUB_USER" \
                            --password-stdin

                        for service in user-service product-service order-service payment-service
                        do
                            echo "Pushing $service"

                            docker tag "$service:$BUILD_NUMBER" \
                                "$DOCKERHUB_USER/$service:$BUILD_NUMBER"

                            docker push "$DOCKERHUB_USER/$service:$BUILD_NUMBER"

                            docker tag "$service:$BUILD_NUMBER" \
                                "$DOCKERHUB_USER/$service:latest"

                            docker push "$DOCKERHUB_USER/$service:latest"
                        done

                        docker logout
                    '''
                }
            }
        }
    }

    post {
        success {
            echo 'All microservices built and pushed to Docker Hub successfully!'
        }

        failure {
            echo 'Pipeline failed. Check the stage logs.'
        }
    }
}

