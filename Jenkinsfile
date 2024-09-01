pipeline {
  agent any

  stages {
    stage ('Chekout') {
      steps {
        chekout scm
      }
    }
    stage ('Build') {
      steps {
        sh './gradlew clean build'
      }
    }
    stage ('API-Test') {
      steps {
        echo 'Running tests...'
        sh './gradlew test'
      }
    }
  }
}
