package security

import groovy.xml.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;

class PermisionsModifier {

    static def addPermissions(String text, String user) {
        def newText = XmlUtil.escapeXml(text)
        def parser = new XmlParser(true, true, true)
        def project = parser.parseText(text);
        this.addPermission(project, user, "USER:hudson.model.Item.Build")
        this.addPermission(project, user, "USER:hudson.model.Item.Read")
        // Convert the XML string into a DOM Document
        def factory = DocumentBuilderFactory.newInstance()
        factory.setNamespaceAware(true)
        def builder = factory.newDocumentBuilder()
        def doc = builder.parse(new ByteArrayInputStream(xmlContent.bytes))

// Use a Transformer to output the XML with correct quoting
        def transformer = TransformerFactory.newInstance().newTransformer()
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8")
        transformer.setOutputProperty(OutputKeys.INDENT, "yes")
        def writer = new StringWriter()
        transformer.transform(new DOMSource(doc), new StreamResult(writer))

        def outputXml = writer.toString()
        return outputXml
    }

    static def getPermissionNode(def root) {
        def parentNode = root.children().find{ it.name() == 'properties' }
        def permissionNode = parentNode.children().find{it.name() == 'hudson.security.AuthorizationMatrixProperty'}
        return permissionNode;
    }

    static def addPermission(def root, def user, def permission) {
        def permissionNode = getPermissionNode(root)
        def newElement = new groovy.util.Node(permissionNode, 'permission')
        newElement.value = "${permission}:${user}";
        root.properties.add(newElement);
    }







}