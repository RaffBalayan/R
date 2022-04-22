def buildJar() {
    echo "building the application..."
    sh'sudo apt install maven'
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'For-DockerHub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t r723/tets:1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push r723/tets:1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
