#!/usr/bin/env groovy

def call(String imageName) {
    echo 'Building the app..'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credential',passwordVariable: 'PASS',usernameVariable: 'USER')]) {
        sh "docker build -t $imageName ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push $imageName"
    }
}