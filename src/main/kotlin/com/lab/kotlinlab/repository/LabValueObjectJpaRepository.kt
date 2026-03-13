package com.lab.kotlinlab.repository

import com.lab.kotlinlab.repository.entity.LabValueObjectEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LabValueObjectJpaRepository : JpaRepository<LabValueObjectEntity, Long>
