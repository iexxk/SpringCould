pipeline {
  agent none
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          agent {
            node {
              label 'gradle'
            }

          }
          environment {
            gradleHome = 'path'
          }
          steps {
            echo 'Building..'
          }
        }
        stage('bbb') {
          agent {
            node {
              label 'build 2'
            }

          }
          steps {
            sh 'echo \'build2\''
          }
        }
      }
    }
    stage('image') {
      agent {
        dockerfile {
          filename 'as'
        }

      }
      steps {
        echo 'Testing..'
      }
    }
    stage('Deploy') {
      agent {
        node {
          label 'ds'
        }

      }
      steps {
        echo 'Deploying....'
      }
    }
  }
}