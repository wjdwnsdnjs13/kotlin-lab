package com.lab.labkotlin.controller.req

import com.lab.labkotlin.domain.AuthorityId
import com.lab.labkotlin.domain.LabValueObject

class CreateLabValueObjectRequest(
    val age: Long,
    val authorityId: AuthorityId,
) {
    fun toDomain() : LabValueObject = LabValueObject(
        age = age,
        authorityId = authorityId,
    )
}
