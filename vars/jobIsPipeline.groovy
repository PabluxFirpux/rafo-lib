def call(String jobName) {
    def expected = "flow-definition"
    return jobIsSomething(jobName, expected)
}