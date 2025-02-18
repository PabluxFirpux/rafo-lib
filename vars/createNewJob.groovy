import global.URLhandler
import global.jobConfigs

def call(String jobName) {
    def user = getUser()
    def password = getPassword()
    def download_Path = getDownloadPath();
    sh "rm -rf ${download_Path}/*"
    def file_Name = "config.xml"
    def full_File_Path = "${download_Path}/${file_Name}"

    File newFile = new File("${full_File_Path}")
    def newJobText = jobConfigs.getBlankJob();
    newFile.write("${newJobText}")
    postConfig(user, password, full_File_Path, download_Path, jobName)
}

def postConfig(String user, String password, String fullPath, String downloadPath, String jobName) {
    def crumb = getCrumb(user, password, downloadPath);
    println("goten crumb")
    def correctPath = URLhandler.getCreateJobString(jobName)
    def url = "${JENKINS_URL}${correctPath}"
    sh "curl -v -X POST --data-binary @${fullPath} -u ${user}:${password} -H 'Content-Type: application/xml'  \"${url}\" -H 'Jenkins-Crumb: ${crumb}'"

}