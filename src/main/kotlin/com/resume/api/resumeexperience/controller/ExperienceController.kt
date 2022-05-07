package com.resume.api.resumeexperience.controller

import com.resume.api.resumeexperience.model.ExperienceEntity
import com.resume.api.resumeexperience.repository.ExperienceRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ExperienceController(private val repo: ExperienceRepository) {

    @GetMapping("/allExp")
    fun getAllExperience(): List<ExperienceEntity> = repo.findAll()

    @PostMapping("/createExp")
    fun createExperience(@Valid @RequestBody exp: ExperienceEntity): ExperienceEntity = repo.save(exp)

    @GetMapping("/expById/{id}")
    fun getExpById(@PathVariable(value = "id") id: Long): ResponseEntity<ExperienceEntity> {
        return repo.findById(id).map { id ->
            ResponseEntity.ok(id)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/createExp/{id}")
    fun updateHadderById(
        @PathVariable(value = "id") id: Long,
        @Valid @RequestBody newExp: ExperienceEntity
    ): ResponseEntity<ExperienceEntity> {

        return repo.findById(id).map { existingExp ->
            val updatedExp: ExperienceEntity = existingExp
                .copy(
                    desigation = newExp.desigation, company = newExp.company,
                    tenure = newExp.tenure, jobdescription = newExp.jobdescription
                )
            ResponseEntity.ok().body(repo.save(updatedExp))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/exp/{id}")
    fun deleteExpById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return repo.findById(id).map { id ->
            repo.delete(id)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}