package com.lab.kotlinlab.repository

import com.lab.kotlinlab.domain.LabValueObject
import com.lab.kotlinlab.repository.entity.LabValueObjectEntity
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class LabValueObjectRepository(
    private val labValueObjectJpaRepository: LabValueObjectJpaRepository,
) {
    fun save(labValueObject: LabValueObject) {
        labValueObjectJpaRepository.save(LabValueObjectEntity.from(labValueObject))
    }

    fun findById(id: Long): LabValueObject? {
        return labValueObjectJpaRepository.findById(id).getOrNull()?.toDomain()
    }

    fun findAll(): List<LabValueObject> {
        return labValueObjectJpaRepository.findAll()
            .map { it.toDomain() }
    }
}
