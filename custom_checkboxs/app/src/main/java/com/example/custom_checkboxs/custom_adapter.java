package com.example.custom_checkboxs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.Toast;

public class custom_adapter extends BaseAdapter {
String value;
Context context;
String[] names;
LayoutInflater inflater;

public custom_adapter(Context context,String[] names)
{
    this.context =context;
    this.names=names;
    inflater=(LayoutInflater.from(context));

}
    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
    view=inflater.inflate(R.layout.activity_check_activity,null);
    final CheckedTextView checkedtextview=(CheckedTextView) view.findViewById(R.id.checkedtextview);
    checkedtextview.setText(names[i]);

    checkedtextview.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(checkedtextview.isChecked())
            {
                value="UnChecked";
                checkedtextview.setCheckMarkDrawable(0);
                checkedtextview.setChecked(false);
            }
            else
            {
                value="Checked";
                checkedtextview.setCheckMarkDrawable(R.drawable.checked);
                checkedtextview.setChecked(true);
            }
            Toast.makeText(context,value,Toast.LENGTH_SHORT).show();
        }
    });




    return view;
    }
}
