pipeline {
  agent any

  stages {
    stage ('API-Test') {
      steps {
        echo 'Running tests...'
        sh './gradlew test'
      }
    }
  }
}
