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

    public static def getScriptedPipeline(String script) {
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

    public static def getFolder(String folderName) {
        return "<com.cloudbees.hudson.plugins.folder.Folder plugin=\"cloudbees-folder\">\n" +
                "<description>description</description>\n" +
                "<displayName>${folderName}</displayName>\n" +
                "<properties>\n" +
                "<com.cloudbees.hudson.plugins.folder.properties.AuthorizationMatrixProperty>\n" +
                "<inheritanceStrategy class=\"org.jenkinsci.plugins.matrixauth.inheritance.InheritParentStrategy\"/>\n" +
                "</com.cloudbees.hudson.plugins.folder.properties.AuthorizationMatrixProperty>\n" +
                "<org.jenkinsci.plugins.docker.workflow.declarative.FolderConfig plugin=\"docker-workflow\">\n" +
                "<dockerLabel/>\n" +
                "<registry plugin=\"docker-commons\"/>\n" +
                "</org.jenkinsci.plugins.docker.workflow.declarative.FolderConfig>\n" +
                "</properties>\n" +
                "<folderViews class=\"com.cloudbees.hudson.plugins.folder.views.DefaultFolderViewHolder\">\n" +
                "<views>\n" +
                "<hudson.model.AllView>\n" +
                "<owner class=\"com.cloudbees.hudson.plugins.folder.Folder\" reference=\"../../../..\"/>\n" +
                "<name>All</name>\n" +
                "<filterExecutors>false</filterExecutors>\n" +
                "<filterQueue>false</filterQueue>\n" +
                "<properties class=\"hudson.model.View\$PropertyList\"/>\n" +
                "</hudson.model.AllView>\n" +
                "</views>\n" +
                "<tabBar class=\"hudson.views.DefaultViewsTabBar\"/>\n" +
                "</folderViews>\n" +
                "<healthMetrics/>\n" +
                "<icon class=\"com.cloudbees.hudson.plugins.folder.icons.StockFolderIcon\"/>\n" +
                "</com.cloudbees.hudson.plugins.folder.Folder>"
    }

    public static def getFolder(String folderName, String description) {
        return "<com.cloudbees.hudson.plugins.folder.Folder plugin=\"cloudbees-folder\">\n" +
                "<description>${description}</description>\n" +
                "<displayName>${folderName}</displayName>\n" +
                "<properties>\n" +
                "<com.cloudbees.hudson.plugins.folder.properties.AuthorizationMatrixProperty>\n" +
                "<inheritanceStrategy class=\"org.jenkinsci.plugins.matrixauth.inheritance.InheritParentStrategy\"/>\n" +
                "</com.cloudbees.hudson.plugins.folder.properties.AuthorizationMatrixProperty>\n" +
                "<org.jenkinsci.plugins.docker.workflow.declarative.FolderConfig plugin=\"docker-workflow\">\n" +
                "<dockerLabel/>\n" +
                "<registry plugin=\"docker-commons\"/>\n" +
                "</org.jenkinsci.plugins.docker.workflow.declarative.FolderConfig>\n" +
                "</properties>\n" +
                "<folderViews class=\"com.cloudbees.hudson.plugins.folder.views.DefaultFolderViewHolder\">\n" +
                "<views>\n" +
                "<hudson.model.AllView>\n" +
                "<owner class=\"com.cloudbees.hudson.plugins.folder.Folder\" reference=\"../../../..\"/>\n" +
                "<name>All</name>\n" +
                "<filterExecutors>false</filterExecutors>\n" +
                "<filterQueue>false</filterQueue>\n" +
                "<properties class=\"hudson.model.View\$PropertyList\"/>\n" +
                "</hudson.model.AllView>\n" +
                "</views>\n" +
                "<tabBar class=\"hudson.views.DefaultViewsTabBar\"/>\n" +
                "</folderViews>\n" +
                "<healthMetrics/>\n" +
                "<icon class=\"com.cloudbees.hudson.plugins.folder.icons.StockFolderIcon\"/>\n" +
                "</com.cloudbees.hudson.plugins.folder.Folder>"
    }
}