package com.zayjsev.app;

import android.content.Context;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class GitHubRepoAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<GitHubRepo> list;
    GitHubRepoAdapter(Context context, int resource, List<GitHubRepo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null) {
            view = inflater.inflate(R.layout.list_item, null);
        }

        TextView name = (TextView) view.findViewById(R.id.textview);
        GitHubRepo gitHubRepo = list.get(position);

        if (name != null) {
            name.setText(gitHubRepo.getName());
        }

        return view;
    }
}
