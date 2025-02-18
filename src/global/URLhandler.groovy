package global

class URLhandler {
    public static def getCreateJobString(String jobName) {
        println(jobName)
        def result = ""
        def path = jobName.split(".")
        println(path.size())
        for (int i = 0; i < path.length-1; i++) {
            result += "job/${path[i]}/"
        }
        result += "createItem?name=${path[path.length-1]}"
        return result;
    }
}