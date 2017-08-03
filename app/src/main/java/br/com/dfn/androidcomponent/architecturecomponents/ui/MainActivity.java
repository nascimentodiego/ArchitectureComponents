package br.com.dfn.androidcomponent.architecturecomponents.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import br.com.dfn.androidcomponent.architecturecomponents.R;
import br.com.dfn.androidcomponent.architecturecomponents.model.Films;
import br.com.dfn.androidcomponent.architecturecomponents.viewmodel.FilmsViewModel;

public class MainActivity extends AppCompatActivity implements LifecycleRegistryOwner, LifecycleObserver {
    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    private FilmsViewModel viewModel;
    private ListView lstFIlms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(FilmsViewModel.class);
        viewModel.init();
        lstFIlms = (ListView) findViewById(R.id.lstFilms);

        subscribeUi(viewModel);

        getLifecycle().addObserver(this);
    }

    private void subscribeUi(FilmsViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getFilms().observe(this, new Observer<Films>() {
            @Override
            public void onChanged(@Nullable Films films) {
                if (films != null) {
                    lstFIlms.setAdapter(new FilmsAdapter(getApplicationContext(), films.results));
                }
            }
        });
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyLifecycke() {
        Log.d(MainActivity.class.getSimpleName(), "Lifecycle.Event.ON_DESTROY");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateLifecycke() {
        Log.d(MainActivity.class.getSimpleName(), "Lifecycle.Event.ON_CREATE");
    }
}
