package com.lab.kotlinlab.service

import com.lab.kotlinlab.domain.Authority
import com.lab.kotlinlab.domain.AuthorityId
import com.lab.kotlinlab.domain.LabValueObject
import com.lab.kotlinlab.domain.LabValueObject2
import com.lab.kotlinlab.domain.MemberId
import com.lab.kotlinlab.repository.LabValueObjectRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LabValueObjectService(
    val labValueObjectRepository: LabValueObjectRepository,
) {
    fun test(memberId: MemberId) {
        LabValueObject2(
            memberId = memberId,
            age = 1L,
            authority = Authority(AuthorityId(1L)),
        )
        println("MemberId: ${memberId.id}")
    }

    fun test(authorityId: AuthorityId) {
        println("AuthorityId: ${authorityId.id}")
    }

    fun test(age: Long) {
        println("age: $age")
    }

    @Transactional
    fun create(labValueObject: LabValueObject) {
        labValueObjectRepository.save(labValueObject)
    }
}
