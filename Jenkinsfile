
pipeline {

    agent any
    options {
        durabilityHint 'MAX_SURVIVABILITY'
    }
    stages {
        stage('Checkout') {
            steps {
                sh 'rm -rf spring_config_k; git clone https://github.com/cherepakhin/spring_config_k'
            }
        }

        stage('Unit tests') {
            steps {
                sh 'pwd;cd spring_config_k;./gradlew clean test --tests *Test'
            }
        }

        stage('Build bootJar') {
            steps {
                sh 'pwd;cd spring_config_k;./gradlew bootJar'
            }
        }

        stage('Publish to Nexus') {
            environment {
                NEXUS_CRED = credentials('nexus_admin')
            }
            steps {
                sh 'cd spring_config_k;./gradlew publish'
            }
        }
    }
}