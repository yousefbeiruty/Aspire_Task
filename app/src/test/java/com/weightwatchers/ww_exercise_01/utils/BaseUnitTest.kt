package com.weightwatchers.ww_exercise_01.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
open class BaseUnitTest {
    @get:Rule
    val coroutineTestRule=MainCoroutineScopeRule()

    @get:Rule
    open val instantTaskExecutorRule= InstantTaskExecutorRule()
}