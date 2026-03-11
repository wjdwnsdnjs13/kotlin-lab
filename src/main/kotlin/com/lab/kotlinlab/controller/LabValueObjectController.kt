package com.lab.kotlinlab.controller

import com.lab.kotlinlab.controller.req.CreateLabValueObjectRequest
import com.lab.kotlinlab.domain.AuthorityId
import com.lab.kotlinlab.domain.MemberId
import com.lab.kotlinlab.service.LabValueObjectService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/lab-value-object")
class LabValueObjectController(
    val labValueObjectService: LabValueObjectService,
) {
    @GetMapping("/1")
    fun test1() {
        labValueObjectService.test(MemberId(1L))
    }

    @GetMapping("/2")
    fun test2() {
        labValueObjectService.test(AuthorityId(1L))
    }

    @GetMapping("/3")
    fun test3() {
        labValueObjectService.test(1L)
    }

    @PostMapping
    fun create(
        @RequestBody
        createLabValueObjectRequest: CreateLabValueObjectRequest,
    ) {
        labValueObjectService.create(createLabValueObjectRequest.toDomain())
    }
}
