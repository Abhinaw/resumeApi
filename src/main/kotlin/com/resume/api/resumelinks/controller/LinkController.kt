package com.resume.api.resumelinks.controller

import com.resume.api.resumelinks.model.LinkEntity
import com.resume.api.resumelinks.repository.LinkRepository
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class LinkController(private val repo: LinkRepository) {

    @GetMapping("/getAllLink")
    fun getSkillDetails(): List<LinkEntity> = repo.findAll()

    @PostMapping("/link")
    fun createLink(@Valid @RequestBody link: LinkEntity): LinkEntity = repo.save(link)
}