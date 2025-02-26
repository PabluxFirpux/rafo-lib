@GrabResolver(name='xbib-releases', root='https://repo1.maven.org/maven2/')
@Grab(group='org.xbib.groovy', module='groovy-ldap', version='1.0.2')
import org.xbib.groovy.ldap.LDAP;
import org.xbib.groovy.ldap.SearchScope


def call() {
    def ldapUrl = 'ldap://ldap.forumsys.com:389'
    def bindDN = 'cn=read-only-admin,dc=example,dc=com'
    def bindPassword = 'password'

    def ldap = LDAP.newInstance(ldapUrl, bindDN, bindPassword)

    def username = "euler"
    def userEntry = ldap.searchUnique("uid=${username},ou=mathematicians,dc=example,dc=com")

    if (userEntry) {
        try {
            // Attempt to bind using the user's DN and password
            def userLdap = LDAP.newInstance(ldapUrl, userEntry.dn, "password")
            println "Authentication successful for user: ${username}"
            userLdap.close()
        } catch (Exception e) {
            println "Authentication failed for user: ${username} - ${e.message}"
        }
    } else {
        println "User not found: ${username}"
    }
    ldap.close()
}