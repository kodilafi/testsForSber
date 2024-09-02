pipeline {
  agent { 
    docker { 
      image 'docker:24.0.2-dind' 
      args '--privileged'
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
