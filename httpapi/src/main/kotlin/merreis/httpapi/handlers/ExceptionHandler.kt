package merreis.httpapi.handlers

import core.errors.NotFoundError
import core.errors.UseCaseError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

data class ErrorMessage(val message: String)

@ControllerAdvice
class ExceptionHandler {

    val dfMessage = "Algo de errado não está certo!!1"

    @ExceptionHandler(value = [NotFoundError::class])
    fun handleNotFoundException(ex: NotFoundError, request: WebRequest): ResponseEntity<List<ErrorMessage>> {
        val message = ex.message ?: dfMessage
        val errorMessage = ErrorMessage(message)
        return ResponseEntity(listOf(errorMessage), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [UseCaseError::class])
    fun handleUseCaseException(ex: UseCaseError, request: WebRequest): ResponseEntity<List<ErrorMessage>> {
        val message = ex.message ?: dfMessage
        val errorMessage = ErrorMessage(message)
        return ResponseEntity(listOf(errorMessage), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [Exception::class, RuntimeException::class])
    fun handleRuntimeException(ex: UseCaseError, request: WebRequest): ResponseEntity<List<ErrorMessage>> {
        val errorMessage = ErrorMessage(dfMessage)
        return ResponseEntity(listOf(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR)
    }

}