package com.example.android.newshunter;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

import static android.content.ContentValues.TAG;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String mUrl;
    public NewsLoader(Context context,String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<News> newsList = QueryUtils.fetchNewsData(mUrl);
        if(newsList==null || newsList.isEmpty()){
            Log.i("News ","null");
        }
        else{
            Log.i("News ","not null");
        }

        return newsList;
    }
}
