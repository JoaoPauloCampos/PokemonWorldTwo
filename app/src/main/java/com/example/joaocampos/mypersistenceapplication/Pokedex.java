package com.example.joaocampos.mypersistenceapplication;

import java.util.List;

/**
 * Created by joao.campos on 27/02/2018.
 */

public class Pokedex {
    List<Pokemon> results;
    int count;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
