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
    def jobNameParts = jobName.split("/")
    def trimmedJobName = jobNameParts[jobNameParts.size()-1]
    def newJobText = jobConfigs.getFolder(trimmedJobName);
    newFile.write("${newJobText}")
    postConfig(user, password, full_File_Path, download_Path, jobName)
}
