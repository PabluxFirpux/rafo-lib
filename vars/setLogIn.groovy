import security.LogIn

def call(String user, String password) {
    //LogIn.setLogIn(user, password)
    sh "env.JENKINS_USER = ${user}"
    sh "env.JENKINS_PASS = ${password}"
}