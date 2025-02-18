def call(String jobName, String newFileText) {
    def user = getUser()
    def password = getPassword()
    def download_Path = getDownloadPath();
    def file_Name = "config.xml"
    def full_File_Path = "${download_Path}/${file_Name}"

    File newFile = new File("${full_File_Path}")
    newFile.write("${newFileText}")
    postConfig(user, password, full_File_Path, download_Path, jobName)
}
