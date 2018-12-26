package thamen.om.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import thamen.om.thamen.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AcadFragment extends Fragment {
public  ListView listView;
private  String[] academicItems;


    public AcadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_acad, container, false);
        academicItems = getResources().getStringArray(R.array.academic);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, academicItems);
        listView.setAdapter(adapter);
        return view;
    }

    }


