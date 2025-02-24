import security.PermissionTags

def call(String jobName, String user) {
    PermissionTags[] allTags = PermissionTags.values()
    addJobPermissions(jobName, user, allTags)
}