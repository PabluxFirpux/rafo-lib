package security

import groovy.xml.*;
import security.PermissionTags;

class PermisionsModifier {

    static def addPermissions(String text, String user, PermissionTags[] permisions) {
        def parser = new XmlParser(true, true, true)
        def project = parser.parseText(text);

        for (PermissionTags permisionTag in permisions) {
            addPermission(project, user, permisionTag)
        }

        StringWriter stringWriter = new StringWriter()
        XmlNodePrinter nodePrinter = new XmlNodePrinter(new PrintWriter(stringWriter))
        nodePrinter.setPreserveWhitespace(true)
        nodePrinter.setExpandEmptyElements(true)
        nodePrinter.setQuote("\"")

        nodePrinter.print(project)
        String xmlString = stringWriter.toString()
        return xmlString
    }

    static def hasPermission(def permissionNode, String tag) {
        for (def nodes in permissionNode.children()) {
            if (nodes.value() == tag) {
                return true
            }
        }
        return false
    }

    static def getPermissionNode(def root) {
        def parentNode = root.children().find{ it.name() == 'properties' }
        def permissionNode = parentNode.children().find{it.name() == 'hudson.security.AuthorizationMatrixProperty'}
        return permissionNode;
    }

    static def addPermission(def root, def user, PermissionTags permission) {
        def permissionNode = getPermissionNode(root)
        def permissionString = PermisionLineGenerator.getPermissionStringByEnum(permission)
        def fullString = "${permissionString}:${user}";
        if (hasPermission(permissionNode, fullString)) {
            return
        }

        def newElement = new groovy.util.Node(permissionNode, 'permission')
        newElement.value = fullString
        root.properties.add(newElement);
    }







}