#!/usr/bin/env groovy Jenkinsfile
pipeline {
    agent none
    parameters {
        choice(name: 'door_choice',
                choices: 'one\ntwo\nthree\nfour',
                description: 'What door do you choose?')
    }
    stages {
        stage('gradle build') {
            agent { label 'gradle' }
            steps {
                echo "${params.door_choice}"
                sh 'gradle -v'
            }
        }
    }
}