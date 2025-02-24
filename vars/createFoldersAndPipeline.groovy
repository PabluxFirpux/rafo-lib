def call(String jobName) {
    createFolder(jobName)
    deleteJob(jobName)
    createScriptedPipeline(jobName, "")
}