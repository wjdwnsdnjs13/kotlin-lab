package com.lab.labkotlin.repository.entity

import com.lab.labkotlin.domain.AuthorityId
import com.lab.labkotlin.domain.LabValueObject
import com.lab.labkotlin.domain.MemberId
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class LabValueObjectEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    val memberId: MemberId,
    @Column(name = "age")
    val age: Long,
    @Column(name = "authority_id")
    val authorityid: AuthorityId,
) {
    companion object {
        fun from(domain: LabValueObject): LabValueObjectEntity =
            LabValueObjectEntity(
                memberId = domain.memberId,
                age = domain.age,
                authorityid = domain.authorityId
            )
    }

    fun toDomain(): LabValueObject =
        LabValueObject(
            memberId = memberId,
            age = age,
            authorityId = authorityid
        )
}
