import security.PermissionTags

def call(String jobName, String user) {
    PermissionTags[] allTags = PermissionTags.values()
    println(allTags)
}