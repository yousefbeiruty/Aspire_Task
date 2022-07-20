package com.weightwatchers.ww_exercise_01.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.weightwatchers.ww_exercise_01.MainCoroutineRule
import com.weightwatchers.ww_exercise_01.data.remote.model.Collections
import com.weightwatchers.ww_exercise_01.data.remote.model.CollectionsItem
import com.weightwatchers.ww_exercise_01.data.repository.DataRepoImpl
import com.weightwatchers.ww_exercise_01.data.repository.FakeDataRepoImplTest
import com.weightwatchers.ww_exercise_01.util.Resource
import com.weightwatchers.ww_exercise_01.utils.BaseUnitTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FakeMainViewModelTest: BaseUnitTest(){

    @get:Rule
    override var instantTaskExecutorRule= InstantTaskExecutorRule()


    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule= MainCoroutineRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp(){
        viewModel= MainViewModel(FakeDataRepoImplTest())
    }

    @Test
    fun getData(){
      viewModel.getData()
    }
}