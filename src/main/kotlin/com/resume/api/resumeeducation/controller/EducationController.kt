package com.resume.api.resumeeducation.controller

import com.resume.api.resumeeducation.model.EducationEntity
import com.resume.api.resumeeducation.repository.EducationRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class EducationController(private val repo: EducationRepository) {

    @GetMapping("/getEducation")
    fun getEducation(): List<EducationEntity> = repo.findAll()

    @PostMapping("/createEducation")
    fun createEducation(@Valid @RequestBody exp: EducationEntity): EducationEntity = repo.save(exp)

    @GetMapping("/educationById/{id}")
    fun getEducationById(@PathVariable(value = "id") id: Long): ResponseEntity<EducationEntity> {
        return repo.findById(id).map { id ->
            ResponseEntity.ok(id)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/updateEducation/{id}")
    fun updateEducationById(
        @PathVariable(value = "id") id: Long,
        @Valid @RequestBody newEdu: EducationEntity
    ): ResponseEntity<EducationEntity> {
        return repo.findById(id).map { existingExp ->
            val updatedExp: EducationEntity = existingExp
                .copy(
                    degree = newEdu.degree, colleagename = newEdu.colleagename,
                    year = newEdu.year
                )
            ResponseEntity.ok().body(repo.save(updatedExp))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/edu/{id}")
    fun deleteEduById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return repo.findById(id).map { id ->
            repo.delete(id)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}