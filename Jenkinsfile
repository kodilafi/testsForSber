pipeline {
  agent { 
    docker { 
      image gradle:8.8.0-jdk17 
    } 
  }

  stages {
    stage ('API-Test') {
      echo 'Running tests...'
      sh './gradlew test'
    }
  }
}
