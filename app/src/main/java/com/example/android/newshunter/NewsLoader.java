package com.example.android.newshunter;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

import static android.content.ContentValues.TAG;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private static String REQUEST_URL =
            "https://content.guardianapis.com/search?show-tags=contributor&q=india&api-key=1920f002-15b9-428e-a04f-2224c5522908";

    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (REQUEST_URL == null) {
            return null;
        }

        List<News> newsList = QueryUtils.fetchNewsData(REQUEST_URL);
        if(newsList==null || newsList.isEmpty()){
            Log.i("News ","null");
        }
        else{
            Log.i("News ","not null");
        }

        return newsList;
    }
}
