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