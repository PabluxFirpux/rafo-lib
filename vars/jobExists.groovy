import global.XMLmanipulation
import groovy.xml.XmlParser

def call(String jobName) {
    def response = getJobConfig(jobName)
    def parser = new XmlParser(true, true, true)
    def responseXML = parser.parseText(response);
    def titleNode = responseXML.children().find{ it.name() == 'title' }

    def result = XMLmanipulation.nodeToString(titleNode)
    println(result)
}