package com.lab.labkotlin.domain

class LabValueObject(
    val memberId: MemberId = MemberId(0L),
    val age: Long,
    val authorityId: AuthorityId,
)

class LabValueObject2(
    val memberId: MemberId,
    val age: Long,
    val authority: Authority,
)

class Authority(
    val authorityId: AuthorityId = AuthorityId(1L),
)

@JvmInline
value class MemberId(val id: Long)

@JvmInline
value class AuthorityId(val id: Long)
