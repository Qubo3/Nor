package jp.ac.sp_salesio.s08547;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.*;

public class ListActivity extends Activity {

    private ListView listView = null;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listView  = (ListView) findViewById(R.id.list);
        
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        
        arrayAdapter.add("新規追加");
        
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
