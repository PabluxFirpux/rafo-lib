import global.*

def call() {
    Info currentInfo = new Info();
    def job_name = currentInfo.job_name;
    echo "${job_name}"
    echo "${env}"
    echo "${currentInfo.env}"
    echo "${JOB_NAME}"
    echo "${currentInfo}"
}