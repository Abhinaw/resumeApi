package com.resume.api.skills.repository

import com.resume.api.skills.model.SkillEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SkillRepository : JpaRepository<SkillEntity, Long>