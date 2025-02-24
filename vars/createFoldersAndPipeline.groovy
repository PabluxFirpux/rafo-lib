def call(String jobName, String script) {
    createFolder(jobName)
    deleteJob(jobName)
    createScriptedPipeline(jobName, script)
}