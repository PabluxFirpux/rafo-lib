import global.*

def call() {
    Info inf = new Info();
    echo "${JOB_NAME}"
    echo "${WORKSPACE}"
    helloWorld("pepe");
}