import global.*

def call() {
    def currentInfo = new Info();
    def job_name = currentInfo.job_name;
    echo "${job_name}"
}