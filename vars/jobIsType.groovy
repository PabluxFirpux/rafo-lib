import groovy.xml.*

def call(String jobName, String expectedType) {
    def type = jobGetType(jobName)
    return type == expectedType
}