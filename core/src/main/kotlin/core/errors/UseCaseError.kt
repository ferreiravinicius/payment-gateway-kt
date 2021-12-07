package core.errors

abstract class UseCaseError : Exception {
    constructor() : super()
    constructor(message: String) : super(message)
}
