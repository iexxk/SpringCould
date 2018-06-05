#!/usr/bin/env groovy
pipeline {
    agent {dockerfile {dir 'eurekaclient'}}
    stages {
        stage('Test') {
            steps {
                sh 'node --version'
                sh 'svn --version'
            }
        }
    }
}
node {
    docker.withServer('tcp://10.14.0.7:2375', '') {

    }
}