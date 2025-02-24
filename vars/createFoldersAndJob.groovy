def call(String jobName) {
    createFolder(jobName)
    deleteJob(jobName)
    createNewJob(jobName)
}