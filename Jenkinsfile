node {
    checkout scm
    stage('Build') {
       sh mvn compile
    }
    stage('Test') {
       sh mvn test
    }
    stage('Deploy') {
        if (currentBuild.result == 'SUCCESS') { // <1>
            sh 'echo SUCCESS'
        }
    }
}
