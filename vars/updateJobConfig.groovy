def call(String jobName, String newFileText) {
    def user = getUser()
    def password = getPassword()
    def download_Path = getDownloadPath();
    def file_Name = "config.xml"
    def full_File_Path = "${download_Path}/${file_Name}"

    File newFile = new File("${full_File_Path}")
    newFile.write("${newFileText}")
    updateConfig(user, password, full_File_Path, download_Path, jobName)
}

def updateConfig(String user, String password, String fullPath, String downloadPath, String jobName) {
    def crumb = getCrumb(user, password, downloadPath);
    sh "curl -v -X POST --data-binary @${fullPath} -u ${user}:${password} -H 'Content-Type: application/xml'  \"${JENKINS_URL}job/${jobName}/config.xml\" -H 'Jenkins-Crumb: ${crumb}'"

}