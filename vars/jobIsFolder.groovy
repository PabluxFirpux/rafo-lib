import groovy.xml.*

def call(String jobName) {
    def type = jobGetType(jobName)
    def expected = "com.cloudbees.hudson.plugins.folder.Folder"
    if (type == expected) return true
    else return false
}