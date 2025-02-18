import security.LogIn

def call() {
    def user = getUser()
    def pass = getPassword()
    println(user)
    println(pass)
}