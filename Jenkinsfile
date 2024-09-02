pipeline {
  agent { 
    docker { 
      image 'gradle:8.8.0-jdk17' 
    } 
  }

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
