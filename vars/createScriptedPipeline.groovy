import global.jobConfigs

def call(String jobName, String script) {
    def user = getUser()
    def password = getPassword()
    def download_Path = getDownloadPath();
    sh "rm -rf ${download_Path}/*"
    def file_Name = "config.xml"
    def full_File_Path = "${download_Path}/${file_Name}"

    File newFile = new File("${full_File_Path}")
    def newJobText = jobConfigs.getScriptedPipeline(script);
    newFile.write("${newJobText}")
    postConfig(user, password, full_File_Path, download_Path, jobName)
}

def postConfig(String user, String password, String fullPath, String downloadPath, String jobName) {
    def crumb = getCrumb(user, password, downloadPath);
    sh "curl -v -X POST --data-binary @${fullPath} -u ${user}:${password} -H 'Content-Type: application/xml'  \"${JENKINS_URL}createItem?name=${jobName}\" -H 'Jenkins-Crumb: ${crumb}'"

}