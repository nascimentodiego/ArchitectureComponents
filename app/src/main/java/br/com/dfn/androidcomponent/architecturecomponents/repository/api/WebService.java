package br.com.dfn.androidcomponent.architecturecomponents.repository.api;

import br.com.dfn.androidcomponent.architecturecomponents.model.Films;
import retrofit2.Call;
import retrofit2.http.GET;


public interface WebService {
    /**
     * @GET the list of star wars films an HTTP GET request
     */
    @GET("films")
    Call<Films> getFilms();
}
