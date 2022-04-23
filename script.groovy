def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'Nexus-Jenkins', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t 3.226.122.151.8083:1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin  3.226.122.151:8083"
        sh 'docker push 3.226.122.151.8083:1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
