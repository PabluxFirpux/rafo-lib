import security.PermisionsModifier

def call(String user, String password, String jobName, String userToRemove) {
    def fileContent = getJobConfig(user, password, jobName)
    def result = PermisionsModifier.deleteAllUserPermissions(fileContent, userToRemove)
    println(result)
    updateJobConfig(user, password, jobName, result)
}