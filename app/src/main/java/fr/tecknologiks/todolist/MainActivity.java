package fr.tecknologiks.todolist;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ArrayList<Item> lstajout = new ArrayList<Item>();
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = (ListView)findViewById(R.id.lst);

        ((Button)findViewById(R.id.btnAjout)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!((EditText) findViewById(R.id.edt)).getText().toString().equals("")) {
                    lstajout.add(new Item(false, ((EditText) findViewById(R.id.edt)).getText().toString()));
                    maj();
                }
            }
        });
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lstajout.get(i).setSelected(!lstajout.get(i).isSelected());
                maj();
            }
        });
        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                lstajout.remove(i);
                maj();
                return false;
            }
        });
    }

    private void maj()
    {
        lst.setAdapter(new AdapterString(lstajout, this));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


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

            if (lstajout.get(position).isSelected())
                ((TextView) convertView.findViewById(R.id.tv)).setPaintFlags(((TextView) convertView.findViewById(R.id.tv)).getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


            ((CheckBox)convertView.findViewById(R.id.check)).setChecked(lstajout.get(position).isSelected());
            ((TextView)convertView.findViewById(R.id.tv)).setText(lstajout.get(position).getText());

            return convertView;
        }

    }

    public class Item
    {

        public Item()
        {

        }
        public Item(boolean _selected, String _text)
        {
            selected = _selected;
            text = _text;
        }
        private boolean selected = false;
        private String text = "";

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
