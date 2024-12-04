import global.*

def call() {
    echo "${JOB_NAME}"
    echo "${WORKSPACE}"
    helloWorld("pepe");
}