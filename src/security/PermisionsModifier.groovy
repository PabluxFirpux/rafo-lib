package security

import groovy.xml.*;

class PermisionsModifier {

    static def addPermissions(String text, String user) {
        def parser = new XmlParser()
        def project = parser.parseText(text);
        addPermission(project, user, "USER:hudson.model.Item.Build")
        addPermission(project, user, "USER:hudson.model.Item.Read")

        return groovy.xml.XmlUtil.serialize(project)
    }

    static def getPermissionNode(Node root) {
        def parentNode = root.children().find{ it.name() == 'properties' }
        def permissionNode = parentNode.children().find{it.name() == 'hudson.security.AuthorizationMatrixProperty'}
        return permissionNode;
    }

    static def addPermission(Node root, String user, String permission) {
        def permissionNode = getPermissionNode(root)
        def newElement = new groovy.util.Node(permissionNode, 'permission')
        newElement.value = "${permission}:${user}";
        root.properties.add(newElement);
    }







}