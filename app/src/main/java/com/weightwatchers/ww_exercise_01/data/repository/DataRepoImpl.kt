package com.weightwatchers.ww_exercise_01.data.repository

import com.weightwatchers.ww_exercise_01.data.remote.model.Collections
import com.weightwatchers.ww_exercise_01.data.remote.webservices.WebService
import com.weightwatchers.ww_exercise_01.domain.repository.DataRepo
import com.weightwatchers.ww_exercise_01.util.ErrorType
import com.weightwatchers.ww_exercise_01.util.Resource
import kotlinx.coroutines.delay
import java.net.SocketTimeoutException
import javax.inject.Inject

class DataRepoImpl @Inject constructor(
    private val webService: WebService
) : DataRepo {
    override suspend fun getData(): Resource<Collections> {
        try {
            val task = webService.getData()
            if (task.isSuccessful) {
                task.body()?.let {
                    return Resource.Success(data = it)
                } ?: return Resource.Error(errorType = ErrorType.EMPTY_DATA)
            } else {
                return Resource.Error()
            }
        } catch (e: SocketTimeoutException) {
            return Resource.Error(errorType = ErrorType.TIME_OUT)
        } catch (e: Exception) {
            return Resource.Error(message = e.localizedMessage)
        }
    }
}