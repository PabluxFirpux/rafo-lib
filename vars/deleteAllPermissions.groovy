import security.PermisionsModifier

def call(String user, String password, String jobName, String userToRemove) {
    def fileContent = getJobConfig(user, password, jobName)
    def result = PermisionsModifier.deleteAllUserPermissions(fileContent, userToRemove)

    updateJobConfig(user, password, jobName, result)
}