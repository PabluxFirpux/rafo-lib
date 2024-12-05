import security.*

def call() {
    sh "mkdir -p ${JENKINS_HOME}/permisions"
    sh "touch  ${JENKINS_HOME}/permisions/out.xml"
    sh "curl -o ${JENKINS_HOME}/permisions/out.xml -X GET -u admin:admin http://localhost:8080/job/mec/config.xml"
    def file = new File("${JENKINS_HOME}/permisions/out.xml")
    def fileContent = file.getText()
    println(fileContent)
    def result = PermisionsModifier.addPermission(fileContent, "jenkins_user")
    println(result)
    sh "rm -rf ${JENKINS_HOME}/permisions/out.xml"
    sh "touch  ${JENKINS_HOME}/permisions/out.xml"
    sh "echo ${result} > ${JENKINS_HOME}/permisions/out.xml"
    sh "curl -v -X POST --data-binary @${JENKINS_HOME}/permisions/out.xml -u admin:admin -H 'Content-Type: application/xml'  \"http://localhost:8080/job/mec/config.xml\""
}


