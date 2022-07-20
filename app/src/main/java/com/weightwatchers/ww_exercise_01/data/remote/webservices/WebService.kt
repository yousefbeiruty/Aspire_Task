package com.weightwatchers.ww_exercise_01.data.remote.webservices

import com.weightwatchers.ww_exercise_01.data.remote.model.Collections
import com.weightwatchers.ww_exercise_01.data.remote.model.CollectionsItem
import com.weightwatchers.ww_exercise_01.util.Resource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface WebService {
    @GET
    suspend fun getData(@Url url:String="collections.json"): Response<Collections>
}