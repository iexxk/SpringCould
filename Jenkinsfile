#!/usr/bin/env groovy Jenkinsfile
node {
    def gradleHome = tool 'gradle4.8'  //这里的gradle4.8要和gradle工具的配置里的name要一致
    env.PATH = "${gradleHome}/bin:${env.PATH}"
    stage('gradle build') {
        if (isUnix()) {
            sh './gradlew clean :eurekaserver:build'
        } else {
            bat 'gradlew.bat clean :eurekaserver:build'
        }
    }
}
