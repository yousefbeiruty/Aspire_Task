package com.weightwatchers.ww_exercise_01.presentation

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.weightwatchers.ww_exercise_01.R
import com.weightwatchers.ww_exercise_01.data.remote.model.Collections
import com.weightwatchers.ww_exercise_01.databinding.ActivityMainBinding
import com.weightwatchers.ww_exercise_01.presentation.adapter.Adapter
import com.weightwatchers.ww_exercise_01.util.LoadingScreen
import com.weightwatchers.ww_exercise_01.util.Resource
import com.weightwatchers.ww_exercise_01.util.calculateNoOfColumns
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import android.util.DisplayMetrics
import android.view.View


private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: Adapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var configuration: Configuration
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        configuration= Configuration()
        getData()
    }

    private fun getData() {
        viewModel.getData()
        viewModel.result.observe(this) {
            when (it) {
                is Resource.Loading -> {
                    LoadingScreen.displayLoadingWithText(this, "Please wait...", false)
                    Timber.tag(TAG).d("onCreateView: Loading")
                }
                is Resource.Success -> {
                    LoadingScreen.hideLoading()
                    LoadingScreen.hideErrorDialog()
                    if(it.data?.size==0)
                        binding.tvEmpty.visibility= View.VISIBLE
                    it.data?.let {
                        setRc(it)
                    }

                    Timber.tag(TAG).d("onCreateView: Success")
                }
                is Resource.Error -> {
                    LoadingScreen.hideLoading()
                    LoadingScreen.showErrorMessage(
                        this,
                        "Error",
                        it.message
                    ) {
                        viewModel.getData()
                    }

                    Timber.tag(TAG).d("onCreateView: Error= ${it.message}")
                }
            }
        }
    }

    fun setRc(data: Collections) {
        adapter = Adapter(this, data) {
            val snackbar = Snackbar
                .make(binding.rc, "filter:${it.filter.toString()}", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
        binding.rc.setHasFixedSize(true)

        binding.rc.layoutManager = LinearLayoutManager(this)


        binding.rc.adapter = adapter
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        try {
            if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
                val mNoOfColumns: Int = calculateNoOfColumns(this)
                 layoutManager = GridLayoutManager(this, mNoOfColumns)
                // at last set adapter to recycler view.
                // at last set adapter to recycler view.
            } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
                layoutManager=LinearLayoutManager(this)
            }
            binding.rc.layoutManager = layoutManager
            binding.rc.adapter = adapter
        } catch (e: Exception) {

        }
    }
}