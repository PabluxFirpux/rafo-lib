package security;

class PermisionsModifier {
    private static final String header = '<?xml version=\\"1.1\\" encoding=\\"UTF-8\\"?><project>\n' +
            '  <actions/>'
    private static final String sectionHead = '<hudson.security.AuthorizationMatrixProperty>\n';
    private static final String strat = '      <inheritanceStrategy class=\\"org.jenkinsci.plugins.matrixauth.inheritance.InheritParentStrategy\\"/>\n'
    private static final String sectionTail = '</hudson.security.AuthorizationMatrixProperty>\n';

    static def addPermission(String file, String user) {
        def keep = file.split('<actions/>');
        def parts = keep[1].split(sectionHead);
        def part1 = parts[0];
        parts = parts[1].split(sectionTail);
        def scmQuotes = parts[1].split('<scm class=hudson.scm.NullSCM/>');
        def part2 = scmQuotes[0] + '<scm class=\\"hudson.scm.NullSCM\\"/>' + scmQuotes[1];
        return header + part1 + sectionHead + strat + PermisionLineGenerator.getJobBuild(user) + PermisionLineGenerator.getJobRead(user) + "    " + sectionTail + part2 + "\n";
    }





}