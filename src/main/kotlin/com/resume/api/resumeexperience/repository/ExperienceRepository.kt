package com.resume.api.resumeexperience.repository

import com.resume.api.resumeexperience.model.ExperienceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExperienceRepository : JpaRepository<ExperienceEntity, Long>