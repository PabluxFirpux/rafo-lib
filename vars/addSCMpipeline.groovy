import global.SCMmodifier

def call(String pipelineName, String url, String credId, String branch, String JenkinsFilePath) {
    def user = getUser()
    def password = getPassword()
    def fileContent = getJobConfig(pipelineName)
    def result = SCMmodifier.setSCM(fileContent, url, credId, branch, JenkinsFilePath)
    updateJobConfig(pipelineName, result)
}