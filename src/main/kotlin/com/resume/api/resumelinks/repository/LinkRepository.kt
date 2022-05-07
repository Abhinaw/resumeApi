package com.resume.api.resumelinks.repository

import com.resume.api.resumelinks.model.LinkEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LinkRepository : JpaRepository<LinkEntity, Long>