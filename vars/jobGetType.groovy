import groovy.xml.*

def call(String jobName) {
    if (!jobExists(jobName)) return false

    def response = getJobConfig(jobName)
    def parser = new XmlParser(true, true, true)
    def responseXML = parser.parseText(response)
    println(responseXML.name())
    return responseXML.name()
}