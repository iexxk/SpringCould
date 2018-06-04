#!/usr/bin/env groovy
pipeline {
    agent {dockerfile {dir 'eurekaclient'}}
    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world!'
            }
        }
    }
}