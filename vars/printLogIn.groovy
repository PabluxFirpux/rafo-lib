import security.LogIn

def call() {
    //LogIn login = LogIn.getLogIn()
    sh "echo \$USERNAME; echo \$JENINS_API_KEY"
}