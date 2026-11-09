
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
    }

    post {
        success {
            echo 'All microservices built and Docker images created successfully!'
        }

        failure {
            echo 'Pipeline failed. Check the stage logs.'
        }
    }
}
