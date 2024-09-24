package com.dara.gitty.repos

import org.junit.jupiter.api.Test

class ReposMapperTest {

    @Test
    fun `given a RepositoryApiModel, when mapped, then a Repository object is returned with corresponding parameters`() {
        // Given
        val repositoryApiModel = repositoryApiModels[0]

        // When
        val repository = repositoryApiModel.toRepository()

        // Then
        with(repository) {
            assert(owner == repositoryApiModel.owner.login)
            assert(name == repositoryApiModel.name)
            assert(imageUrl == repositoryApiModel.owner.avatarUrl)
            assert(description == repositoryApiModel.description)
        }
    }
}
