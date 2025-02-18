def call() {
    def loginPath = getLogInPath()
    def file = new File("${loginPath}/user.txt")
    def fileContent = file.getText()
    return fileContent.trim()
}