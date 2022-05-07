package com.resume.api.resumelinks.model

import javax.persistence.Id;
import javax.persistence.*

@Entity
@Table(name = "blogs")
data class LinkEntity(
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "links")
    val links: String = ""
)
