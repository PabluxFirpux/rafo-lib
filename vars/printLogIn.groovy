import security.LogIn

def call() {
    //LogIn login = LogIn.getLogIn()
    sh "echo \$JENKINS_USER; echo \$JENINS_PASS"
}