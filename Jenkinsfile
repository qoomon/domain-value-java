node {
    checkout scm
    stage('Build') {
       sh 'mvn compile'
    }
    stage('Test') {
       sh 'mvn test'
    }
    stage('Deploy') {
        if (currentBuild.result == 'SUCCESS') {
            sh 'echo SUCCESS'
        }
    }
}
