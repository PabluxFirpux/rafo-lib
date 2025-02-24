import global.URLhandler

def call(String user, String password, String fullPath, String downloadPath, String jobName) {
    def crumb = getCrumb(user, password, downloadPath);
    def correctPath = URLhandler.getCreateJobString(jobName)
    def url = "${JENKINS_URL}${correctPath}"
    sh "curl -v -X POST --data-binary @${fullPath} -u ${user}:${password} -H 'Content-Type: application/xml'  \"${url}\" -H 'Jenkins-Crumb: ${crumb}'"
}