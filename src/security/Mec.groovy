package src.security

import src.security.PermissionTags;

PermissionTags tag = PermissionTags.JOB_BUILD;

println(PermisionLineGenerator.getPermissionStringByEnum(tag))
