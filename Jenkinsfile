#!/usr/bin/env groovy
pipeline {
    //agent {dockerfile {dir 'eurekaclient'}}
    agent any
    stages {
        stage('Gradle Build') {  //gradle 构建
            if (isUnix()) {
                sh './gradlew clean :eurekaserver:build'
            } else {
                bat 'gradlew.bat clean :eurekaserver:build'
            }
        }
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