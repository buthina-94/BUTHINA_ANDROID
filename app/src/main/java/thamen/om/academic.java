package thamen.om;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import thamen.om.thamen.R;

public class academic extends AppCompatActivity {
    private ListView listView;
    private String[] mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);
        mList = getResources().getStringArray(R.array.academic);
        listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (academic.this, android.R.layout.simple_list_item_1, mList);
        listView.setAdapter(adapter);
    }
    }

