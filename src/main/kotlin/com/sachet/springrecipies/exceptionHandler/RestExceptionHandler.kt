package com.sachet.springrecipies.exceptionHandler

import com.sachet.springrecipies.shared.GenericResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [com.sachet.springrecipies.exception.NotFoundException::class])
    fun handleNotFoundException(ex: com.sachet.springrecipies.exception.NotFoundException) =
        ResponseEntity(GenericResponse(ex.message), HttpStatus.NOT_FOUND)
}