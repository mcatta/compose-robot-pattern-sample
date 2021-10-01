package dev.marcocattaneo.robotpatternsample.uitest

import dagger.hilt.android.testing.HiltAndroidTest
import dev.marcocattaneo.robotpatternsample.BaseAndroidComposeTest
import dev.marcocattaneo.robotpatternsample.utils.TestUtils
import dev.marcocattaneo.robotpatternsample.presentation.welcome.welcomeRobotScreen
import io.mockk.coEvery
import org.junit.Test

@HiltAndroidTest
internal class RepositoriesListingTest: BaseAndroidComposeTest() {

    override fun provideTestInstance() = this

    @Test
    fun testConfirmButtonBehaviour() {
        welcomeRobotScreen {
            isConfirmEnabled(false)
            typeUsername("mcatta")
            isConfirmEnabled(true)
            typeUsername("")
            isConfirmEnabled(false)
            typeUsername("mcatta")
        }
    }

    @Test
    fun testRepositoriesListing() {
        coEvery { githubRepository.repositoriesByName(any()) } returns listOf(
            TestUtils.fakeRepo(), TestUtils.fakeRepo()
        )

        welcomeRobotScreen {
            typeUsername("mcatta")
            isConfirmEnabled(true)
        } confirmUsername {
            countRepositories(2)
        }
    }

}