def call(String user, String password, String jobName) {
    def downloadPath = getDownloadPath();
    sh "rm -rf ${downloadPath}/*"
    def crumb = getCrumb(user, password, downloadPath);
    sh "curl -X POST -u ${user}:${password}  \"${JENKINS_URL}job/${jobName}/doDelete\" -H 'Jenkins-Crumb: ${crumb}'"
}

