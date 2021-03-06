package thamen.om.thamen;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import thamen.om.MyRecyclerAdapter;
import thamen.om.SupportItimes;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UpdateSupportFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UpdateSupportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateSupportFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    private ArrayList<SupportItimes> arrayList;
    private String [] SupportItimes;
    private int [] images;
    private SupportItimes itimes;


    private OnFragmentInteractionListener mListener;

    public UpdateSupportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateSupportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateSupportFragment newInstance(String param1, String param2) {
        UpdateSupportFragment fragment = new UpdateSupportFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_update_support, container, false);
        recyclerView= view.findViewById(R.id.list);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        arrayList=new ArrayList<>();
        SupportItimes=getResources().getStringArray(R.array.list);
        images=new int[]{R.drawable.film1,R.drawable.machine,R.drawable.monky1,R.drawable.message};
        createContainer();
        MyRecyclerAdapter myRecyclerAdapter=new MyRecyclerAdapter(arrayList,getActivity());
        recyclerView.setAdapter(myRecyclerAdapter);
        return view;
    }

    private void createContainer() {
        for(int i=0;i<images.length;i++){
            itimes=new SupportItimes();
            itimes.setName(SupportItimes[i]);
            itimes.setImageView(images[i]);
            arrayList.add(itimes);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
