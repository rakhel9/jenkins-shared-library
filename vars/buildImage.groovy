#!/usr/bin/env groovy

def call() {
    echo 'Building the app..'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credential',passwordVariable: 'PASS',usernameVariable: 'USER')]) {
        sh 'docker build -t rakhel/jenkins-build:jma-3.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push rakhel/jenkins-build:jma-2.0'
    }
}