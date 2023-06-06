package com.elewa.thmanyahpodcast.base

/**
 * Base Use Case class
 */
interface BaseUseCase<Params, Result> {
    suspend fun execute(params: Params?): Result
}