package com.resume.api.skills.controller

import com.resume.api.skills.model.SkillEntity
import com.resume.api.skills.repository.SkillRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class SkillController(private val repo: SkillRepository) {

    @GetMapping("/getAllSkill")
    fun getSkillDetails(): List<SkillEntity> = repo.findAll()

    @PostMapping("/skill")
    fun createSkill(@Valid @RequestBody skill: SkillEntity): SkillEntity = repo.save(skill)

    @GetMapping("/skill/{id}")
    fun getSkillById(@PathVariable(value = "id") skillId: Long): ResponseEntity<SkillEntity> {
        return repo.findById(skillId).map { article ->
            ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/skill/{id}")
    fun updateSkillById(
        @PathVariable(value = "id") skillId: Long,
        @Valid @RequestBody newSkill: SkillEntity
    ): ResponseEntity<SkillEntity> {

        return repo.findById(skillId).map { existingSkill ->
            val updateSkill: SkillEntity = existingSkill
                .copy(skill = newSkill.skill)
            ResponseEntity.ok().body(repo.save(updateSkill))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/skill/{id}")
    fun deleteSkillById(@PathVariable(value = "id") skillId: Long): ResponseEntity<Void> {
        return repo.findById(skillId).map { id ->
            repo.delete(id)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}