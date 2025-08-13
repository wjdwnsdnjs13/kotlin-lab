package com.lab.labkotlin.service

import com.lab.labkotlin.domain.Authority
import com.lab.labkotlin.domain.AuthorityId
import com.lab.labkotlin.domain.LabValueObject
import com.lab.labkotlin.domain.LabValueObject2
import com.lab.labkotlin.domain.MemberId
import com.lab.labkotlin.repository.LabValueObjectRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LabValueObjectService(
    val labValueObjectRepository: LabValueObjectRepository
) {
    fun test(memberId: MemberId) {
        LabValueObject2(
            memberId = memberId,
            age = 1L,
            authority = Authority(AuthorityId(1L))
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
