def call() {
    sh "mkdir permisions"
    sh "curl -o ${JENKINS_HOME}/permisions/out.xml -X GET -u admin:admin http://localhost:8080/job/mec/config.xml"
}