package global

class jobConfigs {
    public static def getBlankJob() {
        return "<?xml version='1.1' encoding='UTF-8'?>\n" +
                "<project>\n" +
                "  <actions/>\n" +
                "  <description></description>\n" +
                "  <keepDependencies>false</keepDependencies>\n" +
                "  <properties>\n" +
                "    <hudson.security.AuthorizationMatrixProperty>\n" +
                "      <inheritanceStrategy class=\"org.jenkinsci.plugins.matrixauth.inheritance.InheritParentStrategy\"/>\n" +
                "    </hudson.security.AuthorizationMatrixProperty>\n" +
                "  </properties>\n" +
                "  <scm class=\"hudson.scm.NullSCM\"/>\n" +
                "  <canRoam>true</canRoam>\n" +
                "  <disabled>false</disabled>\n" +
                "  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>\n" +
                "  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>\n" +
                "  <triggers/>\n" +
                "  <concurrentBuild>false</concurrentBuild>\n" +
                "  <builders/>\n" +
                "  <publishers/>\n" +
                "  <buildWrappers/>\n" +
                "</project>"
    }

    public static def getBlankPipeline(String script) {
        return "<flow-definition plugin=\"workflow-job\">\n" +
                "<description/>\n" +
                "<keepDependencies>false</keepDependencies>\n" +
                "<properties>\n" +
                "<hudson.security.AuthorizationMatrixProperty>\n" +
                "<inheritanceStrategy class=\"org.jenkinsci.plugins.matrixauth.inheritance.InheritParentStrategy\"/>\n" +
                "</hudson.security.AuthorizationMatrixProperty>\n" +
                "</properties>\n" +
                "<definition class=\"org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition\" plugin=\"workflow-cps\">\n" +
                "<script>${script}</script>\n" +
                "<sandbox>true</sandbox>\n" +
                "</definition>\n" +
                "<triggers/>\n" +
                "<disabled>false</disabled>\n" +
                "</flow-definition>"
    }
}