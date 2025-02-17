import global.SCMmodifier

def call(String user, String password, String pipelineName, String url, String credId, String branch, String JenkinsFilePath) {
    def fileContent = getJobConfig(user, password, pipelineName)
    def result = SCMmodifier.setSCM(fileContent, url, credId, branch, JenkinsFilePath)
    updateJobConfig(user, password, pipelineName, result)
}