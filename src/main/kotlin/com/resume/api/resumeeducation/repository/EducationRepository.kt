package com.resume.api.resumeeducation.repository

import com.resume.api.resumeeducation.model.EducationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EducationRepository : JpaRepository<EducationEntity, Long>