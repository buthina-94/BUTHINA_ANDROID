package thamen.om;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import thamen.om.thamen.R;

public class Support extends AppCompatActivity {
  private ListView listView;
  private ArrayList<thamen.om.SupportItimes> arrayList;
  private String[] SupportItimes;
  private  int [] images;
  private SupportItimes itimes;
   // private String[] mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        listView = findViewById(R.id.list);
        arrayList = new ArrayList<>();
        SupportItimes = getResources().getStringArray(R.array.support);
        images = new int[]{R.drawable.phone, R.drawable.email, R.drawable.calendar, R.drawable.message};
        createContainer();
        MyAdapter MyAdapter = new MyAdapter(Support.this,arrayList);
        listView.setAdapter(MyAdapter);
    }
    public void createContainer() {
        for (int i = 0; i < images.length; i++) {
            itimes = new SupportItimes();
            itimes.setName(SupportItimes[i]);
            itimes.setImageView(images[i]);
            arrayList.add(itimes);

        }
    }}

        //mList = getResources().getStringArray(R.array.academic);
       // listView = findViewById(R.id.list);
       // ArrayAdapter<String> adapter = new ArrayAdapter<>
       //         (Support.this, android.R.layout.simple_list_item_1, mList);
       // listView.setAdapter(adapter);
   // }
//}
