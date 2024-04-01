package com.geunoo.shortbook.global.exception

class BadRequestException(
    message: String,
) : CustomException(message, 400)

class UnauthorizedException(
    message: String,
) : CustomException(message, 401)

class ForbiddenException(
    message: String,
) : CustomException(message, 403)

class NotFoundException(
    message: String,
) : CustomException(message, 404)

class ConflictException(
    message: String,
) : CustomException(message, 409)

class InternalServerErrorException(
) : CustomException("Internal Server Error", 500)