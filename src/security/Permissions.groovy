package security;

enum Permission {
    CREDENTIALS_CREATE,
    CREDENTIALS_DELETE,
    CREDENTIALS_UPDATE,
    CREDENTIALS_VIEW,
    CREDENTIALS_MANAGEDOMAIN,
    JOB_BUILD,
    JOB_CANCEL,
    JOB_CONFIGURE,
    JOB_DELETE,
    JOB_READ,
    JOB_DISCOVER,
    JOB_MOVE,
    JOB_WORKSPACE,
    RUN_DELETE,
    RUN_REPLAY,
    RUN_UPDATE,
    SCM_TAG
}

def getPermissionStringByEnum(Permission permission) {
    switch (permission) {
        case Permission.CREDENTIALS_CREATE:
            return "USER:com.cloudbees.plugins.credentials.CredentialsProvider.Create"
            break;
        case Permission.CREDENTIALS_DELETE:
            return "USER:com.cloudbees.plugins.credentials.CredentialsProvider.Delete"
            break;
        case Permission.CREDENTIALS_UPDATE:
            return "USER:com.cloudbees.plugins.credentials.CredentialsProvider.Update"
            break;
        case Permission.CREDENTIALS_VIEW:
            return "USER:com.cloudbees.plugins.credentials.CredentialsProvider.View"
            break;
        case Permission.CREDENTIALS_MANAGEDOMAIN:
            return "USER:com.cloudbees.plugins.credentials.CredentialsProvider.ManageDomains"
            break;
        case Permission.JOB_BUILD:
            return "USER:hudson.model.Item.Build"
            break;
        case Permission.JOB_CANCEL:
            return "USER:hudson.model.Item.Cancel"
            break;
        case Permission.JOB_CONFIGURE:
            return "USER:hudson.model.Item.Configure"
            break;
        case Permission.JOB_DELETE:
            return "USER:hudson.model.Item.Delete"
            break;
        case Permission.JOB_READ:
            return "USER:hudson.model.Item.Read"
            break;
        case Permission.JOB_DISCOVER:
            return "USER:hudson.model.Item.Discover"
            break;
        case Permission.JOB_MOVE:
            return "USER:hudson.model.Item.Move"
            break;
        case Permission.JOB_WORKSPACE:
            return "USER:hudson.model.Item.Workspace"
            break;
        case Permission.RUN_DELETE:
            return "USER:hudson.model.Run.Delete"
            break;
        case Permission.RUN_REPLAY:
            return "USER:hudson.model.Run.Replay"
            break;
        case Permission.RUN_UPDATE:
            return "USER:hudson.model.Run.Update"
            break;
        case Permission.SCM_TAG:
            return "USER:hudson.scm.SCM.Tag"
            break;

    }
}