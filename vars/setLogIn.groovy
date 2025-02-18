def call(String user, String password) {
    def loginPath = getLogInPath()
    sh "mkdir -p ${loginPath}"
    sh "rm -rf ${loginPath}/*"
    sh "touch ${loginPath}/user.txt"
    sh "touch ${loginPath}/pass.txt"
}