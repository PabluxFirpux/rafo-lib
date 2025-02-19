import groovy.xml.*

def call(String jobName) {
    def type = jobGetType(jobName)
    def expected = "com.cloudbees.hudson.plugins.folder.Folder"
    if (type == expected) {
        println(true)
        return true
    }
    else {
        println(false)
        return false
    }
}