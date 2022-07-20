package com.weightwatchers.ww_exercise_01.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weightwatchers.ww_exercise_01.data.remote.model.Collections
import com.weightwatchers.ww_exercise_01.domain.repository.DataRepo
import com.weightwatchers.ww_exercise_01.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor( private val dataRepo: DataRepo): ViewModel() {
    private val _result= MutableLiveData<Resource<Collections>>()
    val result: LiveData<Resource<Collections>> get()=_result
    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            _result.postValue(Resource.Loading())
             delay(1000)
            _result.postValue(dataRepo.getData())
        }
    }
}