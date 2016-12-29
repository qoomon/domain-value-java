node {
    checkout scm
    stage('Build') {
       sh 'echo mvn compile'
    }
    stage('Test') {
       sh 'echo mvn test'
    }
    stage('Deploy') {
        if (currentBuild.result == 'SUCCESS') {
            sh 'echo mvn deploy'
        }
    }
}
