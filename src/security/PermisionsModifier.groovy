package security

import groovy.xml.*;
import security.PermissionTags;

class PermisionsModifier {

    static def addPermissions(String text, String user) {
        def parser = new XmlParser(true, true, true)
        def project = parser.parseText(text);
        this.addPermission(project, user, PermissionTags.JOB_BUILD)
        this.addPermission(project, user, PermissionTags.JOB_READ)
        StringWriter stringWriter = new StringWriter()
        XmlNodePrinter nodePrinter = new XmlNodePrinter(new PrintWriter(stringWriter))
        nodePrinter.setPreserveWhitespace(true)
        nodePrinter.setExpandEmptyElements(true)
        nodePrinter.setQuote("\"")

        nodePrinter.print(project)
        String xmlString = stringWriter.toString()
        return xmlString
    }

    static def getPermissionNode(def root) {
        def parentNode = root.children().find{ it.name() == 'properties' }
        def permissionNode = parentNode.children().find{it.name() == 'hudson.security.AuthorizationMatrixProperty'}
        return permissionNode;
    }

    static def addPermission(def root, def user, PermissionTags permission) {
        def permissionNode = getPermissionNode(root)
        def newElement = new groovy.util.Node(permissionNode, 'permission')
        def permissionString = PermisionLineGenerator.getPermissionStringByEnum(permission)
        newElement.value = "${permissionString}:${user}";
        root.properties.add(newElement);
    }







}