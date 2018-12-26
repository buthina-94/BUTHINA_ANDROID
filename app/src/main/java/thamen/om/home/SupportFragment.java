package thamen.om.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import thamen.om.MyAdapter;
import thamen.om.Support;
import thamen.om.SupportItimes;
import thamen.om.thamen.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SupportFragment extends Fragment {

    private ListView listView;
    private ArrayList<thamen.om.SupportItimes> arrayList;
    private String[] SupportItimes;
    private  int [] images;
    private SupportItimes itimes;

    public SupportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =inflater.inflate(R.layout.fragment_support, container, false);
       listView =view.findViewById(R.id.list);
        arrayList = new ArrayList<>();
        SupportItimes = getResources().getStringArray(R.array.support);
        images = new int[]{R.drawable.phone, R.drawable.email, R.drawable.calendar, R.drawable.message};
        createContainer();
        MyAdapter MyAdapter = new MyAdapter(getActivity(),arrayList);
        listView.setAdapter(MyAdapter);
        return view;
    }
    public void createContainer() {
        for (int i = 0; i < images.length; i++) {
            itimes = new SupportItimes();
            itimes.setName(SupportItimes[i]);
            itimes.setImageView(images[i]);
            arrayList.add(itimes);

        }
    }}


