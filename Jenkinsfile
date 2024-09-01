pipeline {
  agent any

  stages {
    stage ('Set Permissions') {
      steps {
        echo 'Build project...'
        sh 'chmod +x gradlew'
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
