package com.resume.api.resumehadder.model
import javax.persistence.Id;
import javax.persistence.*

@Entity
@Table(name = "resume_hadder")
data class HadderEntity(
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "name")
    val name: String = "",

    @Column(name = "address")
    val address: String = "",

    @Column(name = "phone")
    val phone: String = "",

    @Column(name = "email")
    val email: String = ""
)
