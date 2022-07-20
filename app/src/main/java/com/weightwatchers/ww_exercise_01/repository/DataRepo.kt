package com.weightwatchers.ww_exercise_01.domain.repository

import com.weightwatchers.ww_exercise_01.data.remote.model.Collections
import com.weightwatchers.ww_exercise_01.util.Resource

interface DataRepo {
    suspend fun getData(): Resource<Collections>
}