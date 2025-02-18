import global.URLhandler

def call(String jobName, String newFileText) {
    def user = getUser()
    def password = getPassword()
    def download_Path = getDownloadPath();
    def file_Name = "config.xml"
    def full_File_Path = "${download_Path}/${file_Name}"

    File newFile = new File("${full_File_Path}")
    newFile.write("${newFileText}")
    def crumb = getCrumb(user, password, download_Path);
    def correctPath = URLhandler.getRegularJobString(jobName)
    def url = "${JENKINS_URL}${correctPath}/config.xml"
    sh "curl -v -X POST --data-binary @${full_File_Path} -u ${user}:${password} -H 'Content-Type: application/xml'  \"${url}\" -H 'Jenkins-Crumb: ${crumb}'"
}
