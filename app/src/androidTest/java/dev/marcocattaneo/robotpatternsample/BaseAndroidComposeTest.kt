package dev.marcocattaneo.robotpatternsample

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import dagger.hilt.android.testing.HiltAndroidRule
import dev.marcocattaneo.robotpatternsample.domain.repository.GithubRepository
import org.junit.After
import org.junit.Before
import org.junit.Rule
import javax.inject.Inject

abstract class BaseAndroidComposeTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(provideTestInstance())

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Inject
    lateinit var githubRepository: GithubRepository

    abstract fun provideTestInstance(): Any

    val activity: MainActivity
        get() = composeTestRule.activity

    @Before
    open fun setUp() {
        hiltRule.inject()
    }

    @After
    open fun tearDown() {

    }

}