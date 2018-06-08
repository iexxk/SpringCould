pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                node {
                    label 'gradle'
                    def gradleHome = tool 'gradle4.8'  //这里的gradle4.8要和gradle工具的配置里的name要一致
                    env.PATH = "${gradleHome}/bin:${env.PATH}"
                    stage('gradle build') {
                        if (isUnix()) {
                            sh 'gradle clean :eurekaserver:build' //使用jenkns安装的gradle工具(4.8)
                        } else {
                            bat 'gradle clean :eurekaserver:build'
                        }
                    }
                }
                steps {
                    echo 'Testing..'
                }
            }
        }
        stage('image') {
            agent {
                dockerfile {
                    filename 'eurekaserver/Dockerfile'
                }
            }
            steps {
                echo 'Testing..'
            }
        }
    }
}