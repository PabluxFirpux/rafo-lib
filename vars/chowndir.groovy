def chowndir(String user, String path) {
    sh "chown -R ${user} ${path}"
}

def chowndir(String user, String path, boolean recursive) {
    if (recursive) {
        chowndir(user, path);
    } else {
        sh "chown ${user} ${path}"
    }
}