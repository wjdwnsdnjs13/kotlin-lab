package com.lab.kotlinlab.controller.req

import com.lab.kotlinlab.domain.AuthorityId
import com.lab.kotlinlab.domain.LabValueObject

class CreateLabValueObjectRequest(
    val age: Long,
    val authorityId: AuthorityId,
) {
    fun toDomain(): LabValueObject =
        LabValueObject(
            age = age,
            authorityId = authorityId,
        )
}
