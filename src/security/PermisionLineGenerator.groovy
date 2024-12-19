package security;

class PermisionLineGenerator {
    static private def getJobBuild(String username) {
        return "      <permission>USER:hudson.model.Item.Read:${username}</permission>\n"
    }

    static private def getJobRead(String username) {
        return "      <permission>USER:hudson.model.Item.Read:${username}</permission>\n"
    }
}