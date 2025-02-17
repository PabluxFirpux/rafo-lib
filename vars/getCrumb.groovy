def call(String user, String password, String downloadPath) {
    sh "touch  ${downloadPath}/crumb.txt"
    sh "curl -o ${downloadPath}/crumb.txt -X GET -u ${user}:${password} ${JENKINS_URL}crumbIssuer/api/xml"
    def crumbFile = new File("${downloadPath}/crumb.txt")
    def crumbFileCont = crumbFile.getText()
    def parts = crumbFileCont.split("<crumb>")
    def next = parts[1].split("</crumb>")
    return next[0]
}