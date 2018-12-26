package thamen.om;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import thamen.om.home.MyRecyclerAdapterHome;
import thamen.om.thamen.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UpdatedHomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UpdatedHomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdatedHomeFragment extends Fragment implements MyRecyclerAdapterHome.onAdapterItemClick{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM11 = "param1";
    private static final String ARG_PARAM22 = "param2";
    // TODO: Rename and change types of parameters
    private static final String ARG_PARAM1= "Param1";
    private static final String ARG_PARAM2= "Param2";
    private RecyclerView recyclerView;
    private ArrayList<SupportItimes> arrayList;
    private String [] supportItims;
    private int [] image;
    private SupportItimes iteme;
    private CircleIndicator indicator;
    private ViewPager viewPager;
    private SectionsPagerAdapter sectionsPagerAdapter;
    private Handler handler;
    private Runnable runnable;
    private int mPageNumber;

private String mParam1;
private String mParam2;
private static  int[] pagerImage={R.drawable.D,R.drawable.dark_header,R.drawable.message,
        R.drawable.calendar,R.drawable.phone};
private OnFragmentInteractionListener mListener;
{

}
    public UpdatedHomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdatedHomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdatedHomeFragment newInstance(String param1, String param2) {
        UpdatedHomeFragment fragment = new UpdatedHomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
        View rootView= inflater.inflate(R.layout.optionsss,container,false);
        recyclerView=rootView.findViewById(R.id.home_page);
        viewPager=rootView.findViewById(R.id.home_view_pager);
        indicator=rootView.findViewById(R.id.indicator);
        sectionsPagerAdapter=new SectionsPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        indicator.setView(viewPager);
//        RecyclerView.LayoutManager layoutManager=new
//                LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        GridLayoutManager layoutManager=
                new GridLayoutManager(getActivity(),2);

        recyclerView.setLayoutManager(layoutManager);


        arrayList=new ArrayList<>();
        supportItims=getResources().getStringArray(R.array.home_items);


        image=new int[] {R.drawable.email,R.drawable.email,
                R.drawable.calendar,R.drawable.calendar,
                R.drawable.film1,R.drawable.film1,
                R.drawable.green,R.drawable.green,
                R.drawable.face,R.drawable.face};

        createContainer(); //calling method
//        MyAdapter myAdapter=new MyAdapter(arrayList,getActivity());
        MyRecyclerAdapterHome myAdapter=new MyRecyclerAdapterHome(arrayList,getActivity());
        myAdapter.newMethod(this);
        recyclerView.setAdapter(myAdapter);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

            }if (sectionsPagerAdapter.getCount() == mPageNumber){
                mPageNumber = 0 ;
            } else {
                mPageNumber++;
            }
                viewPager.setCurrentItem(mPageNumber,true);
                handler.postDelayed(this,3000);

    };
        return view;
}
    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable); //once app pause will stop slides
    }
    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable,3000);
    }
    public void createContainer() {
        for (int i = 0; i < image.length; i++) {
            iteme = new SupportItimes();
            iteme.setName(supportItims[i]);
            iteme.setImageView(image[i]);
            arrayList.add(iteme);
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

    @Override
    public void onItemClick(int position) {
//        Toast.makeText(getActivity(), "position" +position,Toast.LENGTH_LONG ).show();
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        Fragment fragment=null;
        switch (supportItims[position]){
            case "VLG MOODLE":
                fragment = MoodleLoginFragment.newInstance(supportItims[position],null);
                break;
            case "EMAIL":
                break;
            case "ONLINE HELP DESK":
                break;
            case "EXAM TIMETABLE":
                break;
            case "CONTACT US":
                break;
            case "ACADEMIC CALENDER":
                break;
            case "FAQs":
                break;
            case "ACHEIVEMENTS AND RECOGNITIONS":
                break;
            case "NEW GAZETTE":
                break;
            case "JOB VACANCIES":
                break;
        }
        if (fragment!=null){
            fragmentTransaction.replace(R.id.main_container,fragment);
            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName()); //code for the back button
            fragmentTransaction.commit();
        }
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
    public interface OnFragmentInteractionListener { //if any activity want to use this fragments it must implement this interface
        // TODO: Update argument type and name //communicate onother fragments
        void onFragmentInteraction(Uri uri);
    }
    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment(){

        }
        public static PlaceholderFragment newInstance (int sectionNumber){
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.home_image_pager, container, false);
            int pageNumber = getArguments().getInt(ARG_SECTION_NUMBER);
            ImageView tutorialImage = (ImageView) rootView.findViewById(R.id.pager_image);
            tutorialImage.setImageResource(pagerImage[pageNumber - 1]);
            return rootView;
        }
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter{

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {

            return pagerImage.length;
        }

        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "SECTION 1"; //show title at the top of image in pager
                case 1:
                    return "SECTION 2";
                case 2 :
                    return "SECTION 3";
            }
            return null;
        }
    }










































    int pagerNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        ImageView tutorialImage = (ImageView) rootView.findViewById(R.id.imageView8);
        tutorialImage.setImageResource(pagerImage[pagerNumber - 1]);
        return  rootView;
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
        View view =inflater.inflate(R.layout.home_page, container, false);
        View recyclerView = inflater.inflate(R.layout.home_page);
        viewpager= view.findViewById(R.home_view_pager);
        indicator=view.findViewById(R.id.indicator);
        sectionsPagerAdapter =new SectionsPagerAdapter(getChildFragmentManager());
        viewpager.setAdapter(sectionsPagerAdapter);
        indicator.setViewPager(viewPager);

        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.set
                layoutManager(layoutManager);

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
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public class PlaceholderFragment extends  Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static Fragment newInstance(int i) {

            class SectionsPagerAdapter extends FragmentPagerAdapter {

                public SectionsPagerAdapter(FragmentManager fm) {
                    super(fm);
                }

                @Override
                public Fragment getItem(int position) {
                    return PlaceholderFragment.newInstance(position + 1);
                }

                @Override
                public int getCount() {
                    return pagerImagr.lenght;
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    switch (position) {
                        case 0:
                            return "SECTION 1";
                        case 1:
                            return "SECTION 2";
                        case 2:
                            return "SECTION 3";
                    }
                    return null;
                }
            }
        }
    }
