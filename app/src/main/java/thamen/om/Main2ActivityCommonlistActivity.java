package thamen.om;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import thamen.om.thamen.R;

public class Main2ActivityCommonlistActivity extends AppCompatActivity {
    private ListView listView;
    private String[] mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_commonlist);
        mList = getResources().getStringArray(R.array.list);
        listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (Main2ActivityCommonlistActivity.this, android.R.layout.simple_list_item_1, mList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                                                switch (position + 1) {
                                                    case 1: {
                                                        Intent intent = new Intent(Main2ActivityCommonlistActivity.this, academic.class);
                                                        startActivity(intent);
                                                    }
                                                    break;
                                                    case 2: {
                                                        Intent e = new Intent(Main2ActivityCommonlistActivity.this, Support.class);
                                                        startActivity(e);
                                                    }
                                                    break;
                                                }
                                            }
                                        }
        );
    }
}


