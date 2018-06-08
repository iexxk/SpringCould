#!/usr/bin/env groovy Jenkinsfile
pipeline {
    agent any
    parameters {
        choice(name: 'project_choice',
                choices: 'eurekaserver\neurekaclient\neurekafeign\neurekazuul',
                description: '你要编译构建那个项目?')
    }
    stages {
        stage('gradle build') {
            tools {
                gradle "gradle4.8" //这里的gradle4.8要和gradle工具的配置里的name要一致
            }
            steps {
                echo "开始构建${params.project_choice}项目"
                sh "gradle :${params.project_choice}:clean" //清理
                sh "gradle :${params.project_choice}:build" //构建
            }
        }
        stage('docker build'){
            dir("${params.project_choice}") {  //dockerfile的跟目录
                sh "pwd"
            }
        }
    }
}