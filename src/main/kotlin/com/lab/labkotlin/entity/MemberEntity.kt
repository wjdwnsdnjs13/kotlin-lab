package com.lab.labkotlin.entity

import jakarta.persistence.*

@Entity
@Table(name="member_lab")
class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var memberId: Long? = null,
    var name: String
) {

}