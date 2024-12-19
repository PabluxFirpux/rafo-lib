import security.*

def call() {
    sh "mkdir -p ${JENKINS_HOME}/permisions"
    sh "touch  ${JENKINS_HOME}/permisions/out.xml"
    sh "curl -o ${JENKINS_HOME}/permisions/out.xml -X GET -u admin:admin http://localhost:8080/job/mec/config.xml"
    sh "cat ${JENKINS_HOME}/permisions/out.xml"
    def file = new File("${JENKINS_HOME}/permisions/out.xml")
    def fileContent = file.getText()
    def result = PermisionsModifier.addPermission(fileContent, "jenkins_user")
    sh "echo \"${result}\" > ${JENKINS_HOME}/permisions/out.xml"

    sh "sed '8s/^\\(.\\{33\\}\\)/\\1\"/' out.xml > temp && mv temp out.xml"

    def crumb = getCrumb();
    sh "curl -v -X POST --data-binary @${JENKINS_HOME}/permisions/out.xml -u admin:admin -H 'Content-Type: application/xml'  \"http://localhost:8080/job/mec/config.xml\" -H 'Jenkins-Crumb: ${crumb}'"
}

def getCrumb() {
    sh "touch  ${JENKINS_HOME}/permisions/crumb.txt"
    sh "curl -o ${JENKINS_HOME}/permisions/crumb.txt -X GET -u admin:admin http://localhost:8080/crumbIssuer/api/xml"
    def crumbFile = new File("${JENKINS_HOME}/permisions/crumb.txt")
    def crumbFileCont = crumbFile.getText()
    def parts = crumbFileCont.split("<crumb>")
    def next = parts[1].split("</crumb>")
    return next[0]
}


