import global.XMLmanipulation
import groovy.xml.*

def call(String jobName) {
    def response = getJobConfig(jobName)
    def parser = new XmlParser(true, true, true)
    def responseXML;
    try {
        responseXML = parser.parseText(response);
        return true
    } catch (Exception e) {
        return false
    }
}