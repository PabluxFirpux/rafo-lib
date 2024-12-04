package global;
import System;

class Info {
    def env;
    String job_name;

    Info() {
        this.env = System.getenv()
        this.job_name = env.JOB_NAME;
    }
}