package com.example.springrecipies.exception

class NotFoundException(messageError: String): Exception(
    messageError
)