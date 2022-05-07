package com.resume.api.resumehadder.controller

import com.resume.api.resumehadder.model.HadderEntity
import com.resume.api.resumehadder.repository.HadderRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class HadderController(private val repo: HadderRepository) {

    @GetMapping("/hadderDetails")
    fun getHadderDetails(): List<HadderEntity> = repo.findAll()

    @PostMapping("/hadder")
    fun createHadder(@Valid @RequestBody hadder: HadderEntity): HadderEntity = repo.save(hadder)

    @GetMapping("/hadder/{id}")
    fun getHadderById(@PathVariable(value = "id") articleId: Long): ResponseEntity<HadderEntity> {
        return repo.findById(articleId).map { article ->
            ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/hadder/{id}")
    fun updateHadderById(
        @PathVariable(value = "id") articleId: Long,
        @Valid @RequestBody newHadder: HadderEntity
    ): ResponseEntity<HadderEntity> {

        return repo.findById(articleId).map { existingArticle ->
            val updatedArticle: HadderEntity = existingArticle
                .copy(
                    name = newHadder.name, address = newHadder.address,
                    phone = newHadder.phone, email = newHadder.email
                )
            ResponseEntity.ok().body(repo.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/hadder/{id}")
    fun deleteHadderById(@PathVariable(value = "id") hadderId: Long): ResponseEntity<Void> {
        return repo.findById(hadderId).map { article ->
            repo.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}