@GrabResolver(name='xbib-releases', root='https://repo1.maven.org/maven2/')
@Grab(group='org.xbib.groovy', module='groovy-ldap', version='1.0.2')
import org.xbib.groovy.groovyldap.*;
import org.apache.directory.groovyldap.SearchScope;

def call() {
    def ldapUrl = 'ldap://ldap.mycompany.com:389/dc=mycompany,dc=com'
    def bindDN = 'cn=admin,dc=mycompany,dc=com'
    def bindPassword = 'adminpassword'

    def ldap = LDAP.newInstance(ldapUrl, bindDN, bindPassword)

    ldap.eachEntry('(objectClass=person)') { entry ->
        println "User found: ${entry.cn} - ${entry.displayName}"
    }

    ldap.close()
}