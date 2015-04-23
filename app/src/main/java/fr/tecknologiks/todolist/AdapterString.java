package fr.tecknologiks.todolist;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by robinpauquet on 23/04/15.
 */

public class AdapterString extends BaseAdapter {



    ArrayList<Item> lststring;
    Context c;
    private LayoutInflater inflater;
    public  AdapterString(ArrayList<Item> lst, Context _c) {
        c = _c;
        lststring = lst;
        inflater = LayoutInflater.from(_c);
    }



    @Override
    public int getCount() {
        return lststring.size();
    }

    @Override
    public Object getItem(int index) {
        return lststring.get(index);
    }

    @Override
    public long getItemId(int index) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item, null);

        if (lststring.get(position).isSelected())
            ((TextView) convertView.findViewById(R.id.tv)).setPaintFlags(((TextView) convertView.findViewById(R.id.tv)).getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        ((CheckBox)convertView.findViewById(R.id.check)).setChecked(lststring.get(position).isSelected());
        ((TextView)convertView.findViewById(R.id.tv)).setText(lststring.get(position).getText());

        return convertView;
    }

}