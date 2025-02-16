def call(String user, String password, String jobName, String newFileText) {
    def download_Path = getDownloadPath();
    def file_Name = "config.xml"
    def full_File_Path = "${download_Path}/${file_Name}"

    sh "rm ${full_File_Path}"
    File newFile = new File("${full_File_Path}")
    newFile.write("${newFileText}")
    updateConfig(user, password, full_File_Path, download_Path, jobName)
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

def updateConfig(String user, String password, String fullPath, String downloadPath, String jobName) {
    def crumb = getCrumb(user, password, downloadPath);
    sh "curl -v -X POST --data-binary @${fullPath} -u ${user}:${password} -H 'Content-Type: application/xml'  \"${JENKINS_URL}job/${jobName}/config.xml\" -H 'Jenkins-Crumb: ${crumb}'"

}