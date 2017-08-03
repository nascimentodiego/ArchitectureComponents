package br.com.dfn.androidcomponent.architecturecomponents.model;

import java.util.List;

/**
 * Created by Domdi on 27/05/2017.
 */

public class Films {
    public List<Film> results;


    public class Film{
        public String title;
        public String director;
        public String release_date;
    }
}


