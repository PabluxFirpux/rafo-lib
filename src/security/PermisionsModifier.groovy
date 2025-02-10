package security

import groovy.xml.*;

class PermisionsModifier {

    static def addPermission(String text, String user) {
        def parser = new XmlParser()
        def project = parser.parseText(text);


        return groovy.xml.XmlUtil.serialize(project)
    }

    static def getPermissionNode(Node root) {
        def parentNode = root.children().find{ it.name() == 'properties' }
        def permissionNode = parentNode.children().find{it.name() == 'hudson.security.AuthorizationMatrixProperty'}
        return permissionNode;
    }







}