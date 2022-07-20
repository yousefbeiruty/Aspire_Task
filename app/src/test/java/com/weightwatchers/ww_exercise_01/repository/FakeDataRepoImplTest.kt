package com.weightwatchers.ww_exercise_01.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.weightwatchers.ww_exercise_01.data.remote.model.Collections
import com.weightwatchers.ww_exercise_01.data.remote.model.CollectionsItem
import com.weightwatchers.ww_exercise_01.data.remote.webservices.WebService
import com.weightwatchers.ww_exercise_01.domain.repository.DataRepo
import com.weightwatchers.ww_exercise_01.util.ErrorType
import com.weightwatchers.ww_exercise_01.util.Resource
import com.weightwatchers.ww_exercise_01.utils.BaseUnitTest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking

class FakeDataRepoImplTest(): BaseUnitTest(), DataRepo {

    private val webService:WebService = mock()
    private val service: DataRepoImpl = mock()
    private val lists= mock<Resource<Collections>>()
    private val exception=RuntimeException("Something went wrong")
    private val listRaw= mock<Collections>()

    private val items = mutableListOf<CollectionsItem>()

    @Test
    fun getlistFromService(): Unit = runBlocking{
        service.getData()
        verify(service, times(1)).getData()
    }

    @Test
    fun successfulCall(): Unit = runBlocking{
            whenever(service.getData()).thenReturn(
                Resource.Success(data = listRaw)
            )
    }

    @Test
    fun `unsuccessful call`(): Unit = runBlocking{
        whenever(service.getData()).thenReturn(
            Resource.Error(message= exception.message.toString())
        )
    }

     override suspend fun getData(): Resource<Collections> {
     return Resource.Success(listRaw)
    }

}