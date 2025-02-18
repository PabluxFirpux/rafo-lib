import global.URLhandler

def call(String jobName) {
    def user = getUser()
    def password = getPassword()
    def downloadPath = getDownloadPath();
    sh "rm -rf ${downloadPath}/*"
    def crumb = getCrumb(user, password, downloadPath);
    def correctPath = URLhandler.getCreateJobString(jobName)
    def url = "${JENKINS_URL}${correctPath}"
    sh "curl -X POST -u ${user}:${password}  \"${url}/doDelete\" -H 'Jenkins-Crumb: ${crumb}'"
}

