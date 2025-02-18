package security

import groovy.xml.*;
import security.PermissionTags;
import global.XMLmanipulation

class PermisionsModifier {

    static def addPermissions(String text, String user, PermissionTags[] permisions) {
        def parser = new XmlParser(true, true, true)
        def project = parser.parseText(text);

        for (PermissionTags permisionTag in permisions) {
            addPermission(project, user, permisionTag)
        }

        return XMLmanipulation.nodeToString(project)
    }

    static def deleteAllUserPermissions(String text, String user) {
        def parser = new XmlParser(true, true, true)
        def project = parser.parseText(text);
        def permissionNode = getPermissionNode(project)

        if (isAnyUser(permissionNode, user)) {
            deleteAllUser(permissionNode, user)
        }

        return XMLmanipulation.nodeToString(project)
    }

    static def removePermissions(String text, String user, PermissionTags[] permissions) {
        def parser = new XmlParser(true, true, true)
        def project = parser.parseText(text);

        for (PermissionTags permisionTag in permissions) {
            removePermission(project, user, permisionTag)
        }

        return XMLmanipulation.nodeToString(project)
    }

    static def isAnyUser(def permissionNode, String user) {
        if (permissionNode.children() == null) {
            return false
        }
        for (def nodes in permissionNode.children()) {
            if (nodes.value()[0] == null) {
                continue
            }
            String toSplit = nodes.value()[0]
            String[] value = toSplit.split(":")
            def userOfPermission = value[2]
            if (userOfPermission == user) {
                return true
            }
        }
        return false
    }

    static def deleteAllUser(def permissionNode, String user) {
        def nodesToRemove = []
        for (def nodes in permissionNode.children()) {
            if (nodes.value()[0] == null) {
                continue
            }
            String toSplit = nodes.value()[0]
            String[] value = toSplit.split(":")
            if (value.length < 2) {
                continue
            }
            def userOfPermission = value[2]
            if (userOfPermission == user) {
                nodesToRemove.add(nodes)
            }
        }
        for (def node in nodesToRemove) {
            permissionNode.remove(node)
        }
    }

    static def hasPermission(def permissionNode, String tag) {
        if (permissionNode.children() == null) {
            return false
        }
        for (def nodes in permissionNode.children()) {
            if (nodes.value()[0] == tag) {
                return true
            }
        }
        return false
    }

    static def getNodeWithPermission(def permissionNode, String tag) {
        for (def nodes in permissionNode.children()) {
            if (nodes.value()[0] == tag) {
                return nodes
            }
        }
        return null
    }

    static def getPermissionNode(def root) {
        def parentNode = root.children().find{ it.name() == 'properties' }
        def permissionNode = parentNode.children().find{it.name() == 'hudson.security.AuthorizationMatrixProperty'}
        return permissionNode;
    }

    static def removePermission(def root, def user, PermissionTags permission) {
        def permissionNode = getPermissionNode(root)
        def permissionString = PermisionLineGenerator.getPermissionStringByEnum(permission)
        def fullString = "${permissionString}:${user}";

        if (hasPermission(permissionNode, fullString)) {
            def node = getNodeWithPermission(permissionNode, fullString)
            permissionNode.remove(node)
        }
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