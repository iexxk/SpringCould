#!/usr/bin/env groovy Jenkinsfile
pipeline {
    agent any
    stage('Build') {
        echo 'build'
    }

    stage('Test') {
        parallel pj1: {
            node('pj1') {
                echo 'pj1'
                stage("p b") {
                    echo 'p b'
                }
            }
        }, pj2: {
            node('pj2') {
                echo 'pj2'
                stage("p a") {
                    echo 'p a'
                }
            }
        }
    }
}