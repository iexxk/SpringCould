#!/usr/bin/env groovy Jenkinsfile
node {
    def gradleHome = tool 'gradle4.8'  //这里的gradle4.8要和gradle工具的配置里的name要一致
    env.PATH = "${gradleHome}/bin:${env.PATH}"
    stage('build') {
        parallel { //平行
            stages('eurekaserver build') {
                stage('gradle build') {
                    sh()
                    if (isUnix()) {
                        sh 'gradle clean :eurekaserver:build' //使用jenkns安装的gradle工具(4.8)
                    } else {
                        bat 'gradle clean :eurekaserver:build'
                    }
                }
                stage('docker build image') {
                    dir('eurekaserver') {  //dockerfile的跟目录
                        docker.build("springcould/eurekaserver:${env.BUILD_NUMBER}")
                    }
                }
            }
            stages('eurekaclient build') {
                stage('gradle build') {
                    sh()
                    if (isUnix()) {
                        sh 'gradle clean :eurekaclient:build' //使用jenkns安装的gradle工具(4.8)
                    } else {
                        bat 'gradle clean :eurekaclient:build'
                    }
                }
                stage('docker build image') {
                    dir('eurekaclient') {  //dockerfile的跟目录
                        docker.build("springcould/eurekaclient:${env.BUILD_NUMBER}")
                    }
                }
            }

        }
    }
}
