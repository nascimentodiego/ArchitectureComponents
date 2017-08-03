/*
 * Copyright 2017 Diego Nascimento.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.dfn.androidcomponent.architecturecomponents.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import br.com.dfn.androidcomponent.architecturecomponents.model.Films;
import br.com.dfn.androidcomponent.architecturecomponents.repository.api.ServiceClient;
import br.com.dfn.androidcomponent.architecturecomponents.repository.api.WebService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsRepository {
    private WebService webService = ServiceClient.getBuilderStarWarsRetrofit().create(WebService.class);

    public LiveData<Films> getFilms() {
        final MutableLiveData<Films> data = new MutableLiveData<>();
        webService.getFilms().enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Films> call, Throwable t) {
                Log.d(FilmsRepository.class.getSimpleName(), "onFailure:getFilms");
            }
        });
        return data;
    }

}
