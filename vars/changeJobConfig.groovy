def call() {
    sh "mkdir -p ${JENKINS_HOME}/permisions"
    sh "touch  ${JENKINS_HOME}/permisions/out.xml"
    sh "curl -o ${JENKINS_HOME}/permisions/out.xml -X GET -u admin:admin http://localhost:8080/job/mec/config.xml"
    def file = new File("${JENKINS_HOME}/permisions/out.xml")
    def fileContent = file.getText()
    println(fileContent)
}