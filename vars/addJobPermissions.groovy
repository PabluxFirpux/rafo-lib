import security.*

def call(String jobName, String user_to_modify, PermissionTags[] tags) {
    def user = getUser()
    def password = getPassword()
    def fileContent = getJobConfig(user, password, jobName)
    def result = PermisionsModifier.addPermissions(fileContent, user_to_modify, tags);

    updateJobConfig(jobName, result)
}


