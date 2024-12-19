package security;

class PermisionsModifier {
    private static final String sectionHead = "<hudson.security.AuthorizationMatrixProperty>\n";
    private static final String strat = '      <inheritanceStrategy class="org.jenkinsci.plugins.matrixauth.inheritance.InheritPedoParentStrategy"/>\n'
    private static final String sectionTail = "</hudson.security.AuthorizationMatrixProperty>\n";

    static def addPermission(String file, String user) {
        def parts = file.split(sectionHead);
        def part1 = parts[0]
        parts = parts[1].split(sectionTail)
        def part2 = parts[1]
        return part1 + sectionHead + strat + PermisionLineGenerator.getJobBuild(user) + PermisionLineGenerator.getJobRead(user) + "    " + sectionTail + part2 + "\n";
    }





}