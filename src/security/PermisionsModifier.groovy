package security

import groovy.xml.*;

class PermisionsModifier {

    static def addPermissions(String text, String user) {
        def newText = XmlUtil.escapeXml(text)
        def parser = new XmlParser(true, true, true)
        def project = parser.parseText(text);
        this.addPermission(project, user, "USER:hudson.model.Item.Build")
        this.addPermission(project, user, "USER:hudson.model.Item.Read")
        // Convert the parsed Node back to a formatted XML string
        def writer = new StringWriter()
        def printer = new XmlNodePrinter(new PrintWriter(writer))

// Ensure attributes use double quotes
        printer.preserveWhitespace = true
        printer.quote = '"' // This forces double quotes

        printer.print(project)
        return writer.toString()
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