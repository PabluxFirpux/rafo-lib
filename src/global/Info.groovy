package global;

class Info {
    def env;
    String job_name;

    Info() {
        this.env = System.getenv()
        steps.echo "${env}"
        this.job_name = "paco";
    }
}