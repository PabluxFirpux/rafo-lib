import global.URLhandler

def call(String jobName) {
    def user = getUser()
    def password = getPassword()
    def downloadPath = getDownloadPath();
    sh "rm -rf ${downloadPath}/*"
    def crumb = getCrumb(user, password, downloadPath);
    def correctPath = URLhandler.getRegularJobString(jobName)
    def url = "${JENKINS_URL}${correctPath}/doDelete"
    sh "curl -X POST -u ${user}:${password}  \"${url}\" -H 'Jenkins-Crumb: ${crumb}'"
}

