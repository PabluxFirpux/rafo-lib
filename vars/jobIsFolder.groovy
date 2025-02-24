def call(String jobName) {
    def expected = "com.cloudbees.hudson.plugins.folder.Folder"
    return jobIsSomething(jobName, expected)
}