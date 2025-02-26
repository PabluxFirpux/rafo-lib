@GrabResolver(name='xbib-releases', root='https://repo1.maven.org/maven2/')
@Grab(group='org.xbib.groovy', module='groovy-ldap', version='1.0.2')
import org.xbib.groovy.ldap.LDAP;
import org.xbib.groovy.ldap.SearchScope


def call() {
    def ldapUrl = 'ldap://ldap.forumsys.com:389'
    def bindDN = 'cn=read-only-admin,dc=example,dc=com'
    def bindPassword = 'password'

    def ldap = LDAP.newInstance(ldapUrl, bindDN, bindPassword)

    for (def thing in ldap) {
        println(thing)
    }

    ldap.close()
}