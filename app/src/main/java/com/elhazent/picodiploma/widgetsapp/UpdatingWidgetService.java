package com.elhazent.picodiploma.widgetsapp;

import android.app.RemoteAction;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.widget.RemoteViews;

public class UpdatingWidgetService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        RemoteViews views = new RemoteViews(getPackageName(), R.layout.random_number_widget);
        ComponentName thewidget = new ComponentName(this, RandomNumberWidget.class);
        String lastUpdate = "Random : " + NumberGenerator.Generate(100);
        views.setTextViewText(R.id.appwidget_text, lastUpdate);
        jobFinished(jobParameters, false);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
