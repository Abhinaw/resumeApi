package com.resume.api.resumehadder.repository

import com.resume.api.resumehadder.model.HadderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HadderRepository : JpaRepository<HadderEntity, Long>