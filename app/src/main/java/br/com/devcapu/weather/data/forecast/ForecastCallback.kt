package br.com.devcapu.weather.data.forecast

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import br.com.devcapu.weather.data.ForecastApiModel
import br.com.devcapu.weather.ui.viewModel.MainUiState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastCallback(
    private val onCompletion: (MainUiState) -> Unit
): Callback<ForecastApiModel> {

    private val mapper = ForecastMapper()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResponse(
        call: Call<ForecastApiModel>,
        response: Response<ForecastApiModel>,
    ) {
        if (response.isSuccessful && response.body() != null) {
            onCompletion(mapper.map(response.body()!!))
        } else {
            Log.d("FAILURE_200", response.body().toString())
        }
    }

    override fun onFailure(call: Call<ForecastApiModel>, t: Throwable) {
        Log.d("FAILURE_500", t.message.toString())
    }


}