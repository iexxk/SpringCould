#!/usr/bin/env groovy Jenkinsfile
pipeline {
    agent any
    parameters {
        choice(name: 'door_choice',
                choices: 'one\ntwo\nthree\nfour',
                description: 'What door do you choose?')
    }
//    def gradleHome = tool 'gradle4.8'  //这里的gradle4.8要和gradle工具的配置里的name要一致
//    env.PATH = "${gradleHome}/bin:${env.PATH}"
    stages {
        stage('gradle build') {
            steps {
//        if (isUnix()) {
                echo "${params.project_choice}"
            }
//            sh "gradle clean :${params.project_choice}:build" //使用jenkns安装的gradle工具(4.8)
//        } else {
//            bat "gradle clean :${params.project_choice}:build"
//        }
        }
    }
//    stage('docker build image'){
//        dir(${params.project_choice}){  //dockerfile的跟目录
//            docker.build("springcould/${params.project_choice}:${env.BUILD_NUMBER}")
//        }
//    }
}