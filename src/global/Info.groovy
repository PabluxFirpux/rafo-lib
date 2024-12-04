package global;
import scripts.*;

class Info {
    def env;
    String job_name;

    Info() {
        this.env = System.getenv();
        this.job_name = "paco";
    }
}