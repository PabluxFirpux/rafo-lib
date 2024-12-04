package global;

class Info {
    String job_name;

    Info() {
        this.job_name = "${env.JOB_NAME}";
    }
}