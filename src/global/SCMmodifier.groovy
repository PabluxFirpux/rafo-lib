package global

import groovy.xml.XmlParser
import global.XMLmanipulation

class SCMmodifier {
    static def getSCMnode(def root) {
        def scmNode = root.children().find{ it.name() == 'scm' }
        return scmNode;
    }

    static def addSCMnode(def root, String scmNodeText) {
        def parser = new XmlParser(true, true, true)
        def scmNode = parser.parseText(scmNodeText);
        root.append(scmNode)
    }

    public static def setSCM(String fileContent, String url, String credID, String branch, String jenkinsFilePath) {
        def parser = new XmlParser(true, true, true)
        def project = parser.parseText(fileContent);
        def currentSCMnode = getSCMnode(project)
        project.remove(currentSCMnode)
        String newNodeText = getTextNode(url, credID, branch, jenkinsFilePath)
        addSCMnode(project, newNodeText)
        return XMLmanipulation.nodeToString(project)
    }

    static def getTextNode(String url, String credID, String branch, String jenkinsfilePath) {
        return "<definition class=\"org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition\" plugin=\"workflow-cps\">\n" +
                "<scm class=\"hudson.plugins.git.GitSCM\" plugin=\"git\">\n" +
                "<configVersion>2</configVersion>\n" +
                "<userRemoteConfigs>\n" +
                "<hudson.plugins.git.UserRemoteConfig>\n" +
                "<url>${url}</url>\n" +
                "<credentialsId>${credID}</credentialsId>\n" +
                "</hudson.plugins.git.UserRemoteConfig>\n" +
                "</userRemoteConfigs>\n" +
                "<branches>\n" +
                "<hudson.plugins.git.BranchSpec>\n" +
                "<name>*/${branch}</name>\n" +
                "</hudson.plugins.git.BranchSpec>\n" +
                "</branches>\n" +
                "<doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>\n" +
                "<submoduleCfg class=\"empty-list\"/>\n" +
                "<extensions/>\n" +
                "</scm>\n" +
                "<scriptPath>${jenkinsfilePath}</scriptPath>\n" +
                "<lightweight>true</lightweight>\n" +
                "</definition>"
    }
}