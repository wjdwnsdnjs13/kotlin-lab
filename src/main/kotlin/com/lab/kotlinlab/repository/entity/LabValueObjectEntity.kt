package com.lab.kotlinlab.repository.entity

import com.lab.kotlinlab.domain.AuthorityId
import com.lab.kotlinlab.domain.LabValueObject
import com.lab.kotlinlab.domain.MemberId
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
    val authorityId: AuthorityId,
) {
    companion object {
        fun from(domain: LabValueObject): LabValueObjectEntity =
            LabValueObjectEntity(
                memberId = domain.memberId,
                age = domain.age,
                authorityId = domain.authorityId,
            )
    }

    fun toDomain(): LabValueObject =
        LabValueObject(
            memberId = memberId,
            age = age,
            authorityId = authorityId,
        )
}
