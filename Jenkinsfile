#!/usr/bin/env groovy Jenkinsfile

pipeline {
    agent any
    parameters {
        choice(name: 'project_choice',
                choices: 'eurekaserver' +
                        '\neurekaclient' +
                        '\neurekafeign' +
                        '\neurekazuul' +
                        '\nribbonrest' +
                        '\nconfigserver' +
                        '\nconfigclient',
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
            steps{
               dir("${params.project_choice}"){  //切换执行目录
                   script {  //需要用script包裹，就能使用脚本式语言
                       docker.build("${env.JOB_NAME}/${params.project_choice}:${env.BUILD_NUMBER}")
                   }
                   echo "构建镜像${env.JOB_NAME}/${params.project_choice}:${env.BUILD_NUMBER}完成"
               }
            }
        }
    }
}