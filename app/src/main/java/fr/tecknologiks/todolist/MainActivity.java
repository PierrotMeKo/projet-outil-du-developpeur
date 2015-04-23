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



}
