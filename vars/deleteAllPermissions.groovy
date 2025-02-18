import security.PermisionsModifier

def call(String jobName, String userToRemove) {
    def user = getUser()
    def password = getPassword()
    def fileContent = getJobConfig(jobName)
    def result = PermisionsModifier.deleteAllUserPermissions(fileContent, userToRemove)
    updateJobConfig(jobName, result)
}