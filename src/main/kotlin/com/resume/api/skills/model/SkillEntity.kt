package com.resume.api.skills.model

import javax.persistence.Id;
import javax.persistence.*

@Entity
@Table(name = "skills")
data class SkillEntity(
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "skill")
    val skill: String = ""
)
