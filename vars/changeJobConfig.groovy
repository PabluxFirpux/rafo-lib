def call() {
    sh "curl -X GET -u admin:admin http://localhost:8080/job/mec/config.xml"
    def url = "http://localhost:8080/job/mec/config.xml"
    def command = "curl -H 'Accept: application/xml' ${url}"
    def process = command.execute()
    process.waitFor()
    def xml = new StringWriter()
    process.outputStream.withWriter { writer -> writer.append(it) }
    def xmlString = xml.toString()
    println(xmlString);
}