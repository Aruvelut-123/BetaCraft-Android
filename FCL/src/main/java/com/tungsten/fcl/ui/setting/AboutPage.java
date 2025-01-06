package com.tungsten.fcl.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

import com.tungsten.fcl.R;
import com.tungsten.fclcore.task.Schedulers;
import com.tungsten.fclcore.task.Task;
import com.tungsten.fcllibrary.component.ui.FCLCommonPage;
import com.tungsten.fcllibrary.component.view.FCLLinearLayout;
import com.tungsten.fcllibrary.component.view.FCLUILayout;

public class AboutPage extends FCLCommonPage implements View.OnClickListener {

    private FCLLinearLayout launcher;
    private FCLLinearLayout developer;
    private FCLLinearLayout fork_from;
    private FCLLinearLayout original_developer;
    private FCLLinearLayout sponsor;
    private FCLLinearLayout source;

    public AboutPage(Context context, int id, FCLUILayout parent, int resId) {
        super(context, id, parent, resId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        launcher = findViewById(R.id.launcher);
        developer = findViewById(R.id.developer);
        fork_from = findViewById(R.id.fork_from);
        original_developer = findViewById(R.id.original_developer);
        sponsor = findViewById(R.id.sponsor);
        source = findViewById(R.id.source);
        launcher.setOnClickListener(this);
        developer.setOnClickListener(this);
        fork_from.setOnClickListener(this);
        original_developer.setOnClickListener(this);
        sponsor.setOnClickListener(this);
        source.setOnClickListener(this);
    }

    @Override
    public Task<?> refresh(Object... param) {
        return null;
    }

    @Override
    public void onClick(View v) {
        Uri uri = null;

        if (v == launcher) {
            uri = Uri.parse("https://github.com/Aruvelut-123/BetaCraft-Android");
        }
        if (v == developer) {
            uri = Uri.parse("https://github.com/Aruvelut-123");
        }
        if (v == fork_from) {
            uri = Uri.parse("https://github.com/FCL-Team/FoldCraftLauncher");
        }
        if (v == original_developer) {
            uri = Uri.parse("https://github.com/FCL-Team");
        }
        if (v == sponsor) {
            /*uri = Uri.parse("https://afdian.com/@tungs");*/
            Context context = this.getContext();
            Schedulers.androidUIThread().execute(() -> Toast.makeText(context, context.getString(R.string.about_no_sponsor), Toast.LENGTH_LONG).show());
        }
        if (v == source) {
            uri = Uri.parse("https://github.com/Aruvelut-123/BetaCraft-Android");
        }

        if (uri != null) {
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            getContext().startActivity(intent);
        }
    }
}
