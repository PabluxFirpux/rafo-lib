package global;

class Info {
    def env;
    String job_name;

    Info() {
        this.env = System.getenv()
        echo "${env}"
        this.job_name = "paco";
    }
}