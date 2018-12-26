package thamen.om;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import thamen.om.academicfaculities.Centre_for_Foundation_Studies;
import thamen.om.academicfaculities.Centre_for_Postgraduate_Studies;
import thamen.om.academicfaculities.Faculty_of_Business_and_Management;
import thamen.om.academicfaculities.Faculty_of_Computing_Sciences;
import thamen.om.thamen.Conectus;
import thamen.om.thamen.R;
import thamen.om.utils.GulfCollegeConstants;

/**
 * Created by sasmob on 11/12/2018.
 */

public class Home extends GulfCollegeBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
       // setTitle(getString(R.string.home)); to change the name of page. this is other method
        setContentView(R.layout.optionsss);

        CircleImageView button = findViewById(R.id.profile_imag5);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Email.class);
                startActivity(i);
            }
        });

        CircleImageView button1 = findViewById(R.id.profile_imag4);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent t = new Intent(Home.this, gazette.class);
                startActivity(t);
            }
        });
        CircleImageView button2 = findViewById(R.id.profile_imag6);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent t = new Intent(Home.this,Vlg.class);
                startActivity(t);
            }
        });

        CircleImageView button3 = findViewById(R.id.profile_imag7);
        button3.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v) {
            Intent t = new Intent(Home.this, Conectus.class);
            startActivity(t);
        } });

        CircleImageView button6 = findViewById(R.id.profile_imag3);
        button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent t = new Intent(Home.this,Movies.class);
                startActivity(t);
            } });}




    //}

public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater menuInflater=getMenuInflater();
            menuInflater.inflate(R.menu.menu,menu);
            return true;

        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    int id=item.getItemId();
            switch (id){
                case R.id.language:
                    Locale current = getResources().getConfiguration().locale;
                    if(current.getLanguage().equalsIgnoreCase(GulfCollegeConstants.AR)) {
                        changeLang(GulfCollegeConstants.EN);
                    }
                    else
                    {
                        changeLang(GulfCollegeConstants.AR);
                    }
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                    //Intent i = new Intent(Home.this, Centre_for_Foundation_Studies.class);
                    //startActivity(i);
                    //Toast.makeText(this, "locate",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.contact:
                    Intent w = new Intent(Home.this, Faculty_of_Computing_Sciences.class);
                    startActivity(w);
                    Toast.makeText(this, "contact",Toast.LENGTH_SHORT).show();
                    break;
//                case R.id.locate1:
//                    Intent r = new Intent(Home.this, Faculty_of_Business_and_Management.class);
//                    startActivity(r);
//                    Toast.makeText(this, "locate1",Toast.LENGTH_SHORT).show();
//                    break;
                case R.id.locate11:
                    Intent j = new Intent(Home.this, Centre_for_Postgraduate_Studies.class);
                    startActivity(j);
                    Toast.makeText(this, "contact1",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.Gallary:
                    Intent h= new Intent(Home.this, thamen.om.academicfaculities.Gallery.class);
                    startActivity(h);
            }

        return super.onOptionsItemSelected(item);

    }

    public void gotolist(View view) {
    Intent intent=new Intent(Home.this,Main2ActivityCommonlistActivity.class);
    startActivity(intent);
    }


}
