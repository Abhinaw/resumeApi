package com.resume.api.resumeexperience.model

import javax.persistence.*

@Entity
@Table(name = "experience")
data class ExperienceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = 0,
    @Column(name = "desigation")
    val desigation: String = "",
    @Column(name = "company")
    val company: String = "",
    @Column(name = "tenure")
    val tenure: String = "",
    @Column(name = "jobdescription")
    val jobdescription: String = "",
)