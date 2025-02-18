import security.LogIn

def call() {
    LogIn login = LogIn.getLogIn()
    sh "${login.getUser()} \n ${login.getPassword()}"
}