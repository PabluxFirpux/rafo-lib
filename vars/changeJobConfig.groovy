import security.*

def call(String user, String password, String jobName) {
    def download_Path = "${JENKINS_HOME}/permisions";
    def file_Name = "output.xml"
    def full_File_Path = "${download_Path}/${file_Name}"

    this.downloadFile(user, password, jobName);

    def file = new File("${JENKINS_HOME}/permisions/out.xml")
    def fileContent = file.getText()
    def result = PermisionsModifier.addPermission(fileContent, "jenkins_user")
    sh "echo \"${result}\" > ${JENKINS_HOME}/permisions/out.xml"


    this.updateConfig(user, password, full_File_Path, download_Path, jobName);
}

def getCrumb(String user, String password, String downloadPath) {
    sh "touch  ${downloadPath}/crumb.txt"
    sh "curl -o ${downloadPath}/crumb.txt -X GET -u ${user}:${password} ${JENKINS_URL}crumbIssuer/api/xml"
    def crumbFile = new File("${downloadPath}/crumb.txt")
    def crumbFileCont = crumbFile.getText()
    def parts = crumbFileCont.split("<crumb>")
    def next = parts[1].split("</crumb>")
    return next[0]
}

def downloadFile(String user, String password, String jobName, String download_Path, String full_File_Path) {
    sh "mkdir -p ${download_Path}"
    sh "touch ${full_File_Path}"
    sh "rm -rf ${download_Path}/*"

    sh "curl -o ${full_File_Path} -X GET -u ${user}:${password} ${JENKINS_URL}job/${jobName}/config.xml"
    sh "cat ${full_File_Path}"
}

def updateConfig(String user, String password, String fullPath, String downloadPath, String jobName) {
    def crumb = getCrumb(user, password, downloadPath);
    sh "curl -v -X POST --data-binary @${fullPath} -u ${user}:${password} -H 'Content-Type: application/xml'  \"${JENKINS_URL}job/${jobName}/config.xml\" -H 'Jenkins-Crumb: ${crumb}'"

}


