#!/usr/bin/env groovy Jenkinsfile
pipeline {
    agent none
    stages {
        stage('gradle build') {
            agent { label 'gradle' }
            steps {
                sh 'gradle -v'
            }
        }
    }
}