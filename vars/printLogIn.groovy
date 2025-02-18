import security.LogIn

def call() {
    def user = getUser()
    def pass = getPassword()
    print(user)
    print(pass)
}