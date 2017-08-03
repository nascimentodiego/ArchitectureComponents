/**
 * Created by Diego Nascimento on 27/05/2017.
 */
package br.com.dfn.androidcomponent.architecturecomponents.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import br.com.dfn.androidcomponent.architecturecomponents.model.Films;
import br.com.dfn.androidcomponent.architecturecomponents.repository.FilmsRepository;


public class FilmsViewModel extends ViewModel {
    private LiveData<Films> mFilms;
    private FilmsRepository filmsRepository
            = new FilmsRepository();

    public void init() {
        if(mFilms != null){
            return;
        }

        mFilms = filmsRepository.getFilms();
    }

    public LiveData<Films> getFilms() {
        return this.mFilms;
    }
}
