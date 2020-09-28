package com.pgpatel.jsonbaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private JSONArray jsonArray;

    public CustomAdapter(Context context, JSONArray jsonArray) {
        this.context = context;
        this.jsonArray = jsonArray;
    }

    @Override
    public int getCount() {
        return jsonArray.length();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        }

        TextView Website = (TextView) convertView.findViewById(R.id.txtWebsite);
        TextView Url = (TextView) convertView.findViewById(R.id.txtUrl);

        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            Website.setText(jsonObject.getString("Website"));
            Url.setText(jsonObject.getString("Url"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}
