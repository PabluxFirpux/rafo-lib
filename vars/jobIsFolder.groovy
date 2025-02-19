import groovy.xml.XmlParser

def call(String jobName) {
    if (!jobExists(jobName)) return false

    def response = getJobConfig(jobName)
    def parser = new XmlParser(true, true, true)
    def responseXML = parser.parseText(response);
    Node targetNode = responseXML.children().find{ it.name() == 'properties' }
    println(responseXML.name())
}