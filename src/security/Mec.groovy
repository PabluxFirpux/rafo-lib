package security

import security.PermissionTags;

PermissionTags tag = PermissionTags.JOB_BUILD;

println(PermisionLineGenerator.getPermissionStringByEnum(tag))
