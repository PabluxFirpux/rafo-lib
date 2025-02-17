def call(String user, String password, String jobName) {
    def download_Path = getDownloadPath();
    sh "rm -rf ${download_Path}/*"
    def crumb = getCrumb(user, password, downloadPath);
    sh "curl -X POST -u ${user}:${password}  \"${JENKINS_URL}job/${jobName}/doDelete\" -H 'Jenkins-Crumb: ${crumb}'"
}

