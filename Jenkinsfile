#!/usr/bin/env groovy Jenkinsfile
pipeline {
    agent any
    parameters {
        choice(name: 'door_choice',
                choices: 'one\ntwo\nthree\nfour',
                description: 'What door do you choose?')
    }
    stages {
        stage('build') {
            tools{
                gradle "gradle4.8"
            }
            steps {
                echo "${params.door_choice}"
                sh 'gradle -v'
            }
        }
    }
}