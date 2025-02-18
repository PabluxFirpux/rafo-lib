def call() {
    def loginPath = getLogInPath()
    def file = new File("${loginPath}/pass.txt")
    def fileContent = file.getText()
    return fileContent.trim()
}