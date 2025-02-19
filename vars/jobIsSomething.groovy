import groovy.xml.*

def call(String jobName, String expectedType) {
    def type = jobGetType(jobName)
    def expected = expectedType
    if (type == expected) {
        println(true)
        return true
    }
    else {
        println(false)
        return false
    }
}