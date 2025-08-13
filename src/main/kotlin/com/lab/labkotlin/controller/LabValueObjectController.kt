package com.lab.labkotlin.controller

import com.lab.labkotlin.controller.req.CreateLabValueObjectRequest
import com.lab.labkotlin.domain.AuthorityId
import com.lab.labkotlin.domain.MemberId
import com.lab.labkotlin.service.LabValueObjectService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/lab-value-object")
class LabValueObjectController(
    val labValueObjectService: LabValueObjectService
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
        createLabValueObjectRequest: CreateLabValueObjectRequest
    ) {
        labValueObjectService.create(createLabValueObjectRequest.toDomain())
    }
}
