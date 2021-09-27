package dev.marcocattaneo.robotpatternsample.domain.interactor

interface UseCase<Input, Output> {
    suspend fun perform(input: Input): Result<Output>
}