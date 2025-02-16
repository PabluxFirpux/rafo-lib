import security.*

def call(String user, String password, String jobName, String user_to_modify, PermissionTags[] tags) {

    def fileContent = getJobConfig(user, password, jobName)
    def result = PermisionsModifier.addPermissions(fileContent, user_to_modify, tags);

    updateJobConfig(user, password, jobName, result)
}


