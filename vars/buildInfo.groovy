import global.*

def call() {
    def jenkins = Jenkins.instance;
    def job = jenkins.getJob("${JOB_NAME}")
    echo "===================================="
    Info inf = new Info();
    echo "${JOB_NAME}"
    echo "${WORKSPACE}"
    echo "${JENKINS_URL}"
}