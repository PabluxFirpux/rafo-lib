import global.XMLmanipulation
import groovy.xml.*

def call(String jobName) {
    def response = getJobConfig(jobName)
    def parser = new XmlParser(true, true, true)
    def responseXML;
    try {
        responseXML = parser.parseText(response);
        println(true)
    } catch (Exception e) {
        println(false)
    }
}