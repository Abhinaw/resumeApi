package com.resume.api.resumeeducation.model

import javax.persistence.*

@Entity
@Table(name = "education")
data class EducationEntity(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id", nullable = false) var id: Long? = 0,
    @Column(name = "degree") val degree: String = "",
    @Column(name = "colleagename") val colleagename: String = "",
    @Column(name = "year") val year: String = ""
)