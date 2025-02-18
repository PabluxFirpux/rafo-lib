import security.LogIn

def call(String user, String password) {
    //LogIn.setLogIn(user, password)
    sh "export USERNAME=${user}"
    sh "export JENKINS_API_KEY=${password}"
}