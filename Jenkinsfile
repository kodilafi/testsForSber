pipeline {
  agent any

  stages {
    stage ('Build') {
      steps {
        echo 'Build project...'
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
