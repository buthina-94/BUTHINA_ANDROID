package thamen.om;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import thamen.om.thamen.R;

    public class Movies extends AppCompatActivity {
        private ListView listView;
        private ArrayList<thamen.om.SupportItimes> arrayList;
        private String[] SupportItimes,year,rate;
        private  int [] images;
        private SupportItimes items;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies);
        listView = findViewById(R.id.movies);
        arrayList = new ArrayList<>();
        SupportItimes = getResources().getStringArray(R.array.tile);
        rate = getResources().getStringArray(R.array.rating);
        year = getResources().getStringArray(R.array.year);

        images = new int[]{R.drawable.monky1, R.drawable.monky2, R.drawable.machine, R.drawable.film1};
        createContainer();
        Adapter Adapter = new Adapter(Movies.this,arrayList);
        listView.setAdapter(Adapter);
    }
        public void createContainer() {
            for (int i = 0; i < images.length; i++) {
                items = new SupportItimes();
                items.setName(SupportItimes[i]);
                items.setRate(rate[i]);
                items.setYear(year[i]);
                items.setImageView(images[i]);
                arrayList.add(items);

            }
        }}




