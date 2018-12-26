package thamen.om.moodle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import thamen.om.UpdatedHomeFragment;
import thamen.om.database.MyDatabase;
import thamen.om.database.Student;
import thamen.om.thamen.R;
import thamen.om.updated.NavigationMainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistrationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistrationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button already_regidter,register;
    private EditText name,user_id,password;
    private MyDatabase helperClass;
    private String fName,mUser,mPass;
    private Student student;
    private android.support.v4.app.FragmentTransaction fragmentTransaction;
    private long aLong;
    private UpdatedHomeFragment.OnFragmentInteractionListener mListener;
    private Fragment fragment;
    private RegistrationFragment MoodleLoginFragment;

    public RegistrationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrationFragment newInstance(String param1, String param2) {
        RegistrationFragment fragment = new RegistrationFragment();
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
        View view = inflater.inflate(R.layout.fragment_registration,container,false);
        ((NavigationMainActivity)getActivity()).getSupportActionBar().setTitle("New LoginNew");
        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        name=view.findViewById(R.id.name);
        user_id= view.findViewById(R.id.name);
        register=view.findViewById(R.id.register);
        helperClass= view.findViewById(R.id.helperClass);
        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
           fName=name.getText().toString();
           mUser=user_id.getText().toString();
           mPass=password.getText().toString();
           student = new Student();
           student.setName(fName);
           student.setUser_id(mUser);
           student.setPassword(mPass);
           aLong=helperClass.insertStudent(student);
           if(aLong>0){
               Toast.makeText(getActivity(),"LoginNew Successfull !!",Toast.LENGTH_LONG.show());
               fragment=MoodleLoginFragment.newInstance("VLG (Moodle)",null);
               fragmentTransaction.replace(R.id.main_container,fragment);
               fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
               fragmentTransaction.commit();
           }
            }
        });

         already_regidter=view.findViewById(R.id.already_register) ;
         already_regidter.setOnClickListener(new View.OnClickListener(){


    @Override
         public void onClick(View view) {

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        Fragment fragment = MoodleLoginFragment.newInstance("VLG (Moodle", null);
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }
    });
    return view;

    }}
