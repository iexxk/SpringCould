#!/usr/bin/env groovy Jenkinsfile
node {
    parameters{
        choice(name: 'project_choice',choice: 'eurekaserver\neurekaclient',description: '你要构建哪个项目？')
    }
    def gradleHome = tool 'gradle4.8'  //这里的gradle4.8要和gradle工具的配置里的name要一致
    env.PATH = "${gradleHome}/bin:${env.PATH}"
    stage('gradle build') {
        if (isUnix()) {
            echo "${params.project_choice}"
            sh "gradle clean :${params.project_choice}:build" //使用jenkns安装的gradle工具(4.8)
        } else {
            bat "gradle clean :${params.project_choice}:build"
        }
    }
    stage('docker build image'){
        dir(${params.project_choice}){  //dockerfile的跟目录
            docker.build("springcould/${params.project_choice}:${env.BUILD_NUMBER}")
        }
    }
}