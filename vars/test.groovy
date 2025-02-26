@Grab(group='org.apache.directory.groovyldap', module='groovy-ldap', version='0.9.0-incubating')
import org.apache.directory.groovyldap.LDAP;
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