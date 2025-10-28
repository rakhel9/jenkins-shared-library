#!/usr/bin/env groovy
def call() {
    echo 'Testing the app..'
    echo "Executing Pipeline for $BRANCH_NAME"
    sh 'mvn test'
}