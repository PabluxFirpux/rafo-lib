def call(String username, String pass, String artifactName, String tag) {
    echo "Dockericeing the application"
    sh "dockerd &"
    sh "docker login -u ${username} -p ${pass}"
    sh "docker build -t ${artifactName}:${tag} ."
    sh "docker images"
    sh "docker tag ${artifactName} ${username}/${artifactName}:${tag}"
    sh "docker image push ${username}/${artifactName}:${tag}"
}