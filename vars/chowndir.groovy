def chowndir(String user, String path) {
    sh "chown -R ${user} ${path}"
}

def chowndir(String user, String path, boolean recursive) {
    recursive ? chowndir(user, path) : sh "chown ${user} ${path}"
}