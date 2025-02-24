import security.PermissionTags

def call(String jobName, String user) {
    PermissionTags[] allTags = PermissionTags.values()
    for (PermissionTags tag in allTags) {
        println(tag)
    }
}