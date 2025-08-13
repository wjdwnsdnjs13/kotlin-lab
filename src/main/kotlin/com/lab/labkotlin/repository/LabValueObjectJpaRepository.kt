package com.lab.labkotlin.repository

import com.lab.labkotlin.repository.entity.LabValueObjectEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LabValueObjectJpaRepository : JpaRepository<LabValueObjectEntity, Long>
