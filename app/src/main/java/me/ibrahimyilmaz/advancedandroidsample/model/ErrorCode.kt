package me.ibrahimyilmaz.newsitkotlin.model

/**
 * Created by ibrahimyilmaz on 6/11/18 Project NewsItKotlin.
 */
enum class ErrorCode {
    apiKeyDisabled,
    apiKeyExhausted,
    apiKeyInvalid,
    apiKeyMissing,
    parameterInvalid,
    parametersMissing,
    rateLimited,
    sourcesTooMany,
    sourceDoesNotExist,
    unexpectedError
}