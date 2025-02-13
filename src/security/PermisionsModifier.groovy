package security

import groovy.xml.*;

class PermisionsModifier {

    static def addPermissions(String text, String user) {
        def parser = new XmlParser(true, true, true)
        def project = parser.parseText(text);
        this.addPermission(project, user, "USER:hudson.model.Item.Build")
        this.addPermission(project, user, "USER:hudson.model.Item.Read")
        StringWriter stringWriter = new StringWriter()
        XmlNodePrinter nodePrinter = new XmlNodePrinter(new PrintWriter(stringWriter))
        nodePrinter.setPreserveWhitespace(true)
        nodePrinter.setExpandEmptyElements(true)
        nodePrinter.setQuote("\"")

        nodePrinter.print(project)
        String xmlString = stringWriter.toString()
        //def fixedQuotes = addAllNeededQuotes(xmlString)
        return fixedQuotes
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

    static def addAllNeededQuotes(def string) {
        def first = addQuotesAroundString(string, "org.jenkinsci.plugins.matrixauth.inheritance.InheritParentStrategy")
        def second = addQuotesAroundString(first, "hudson.scm.NullSCM")
        return second
    }

    static def addQuotesAroundString(def string, def pattern) {
        def pieces = string.split(pattern);
        return pieces[0] + "\"" + pattern + "\"" + pieces[1]
    }





}