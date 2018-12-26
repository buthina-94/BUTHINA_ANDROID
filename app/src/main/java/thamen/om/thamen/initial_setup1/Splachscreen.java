package thamen.om.thamen.initial_setup1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import thamen.om.GulfCollegeBaseActivity;
import thamen.om.Home;
import thamen.om.thamen.R;
import thamen.om.updated.NavigationMainActivity;
import thamen.om.utils.GulfCollegeConstants;

public class Splachscreen extends GulfCollegeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TO hide action bar
        getSupportActionBar().hide();
        //to hide notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        Toast.makeText(this, "from onCreate life cycle method", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.splach_screen);

        if(getSharedPreferences(GulfCollegeConstants.LAND_FILE,MODE_PRIVATE)
                .getString(GulfCollegeConstants.LANG,null) !=null
                &&getSharedPreferences(GulfCollegeConstants.LAND_FILE, MODE_PRIVATE)
                .getString(GulfCollegeConstants.LANG, null).equalsIgnoreCase(GulfCollegeConstants.EN)){
            changeLang(GulfCollegeConstants.EN);
        }
        else{
               changeLang(GulfCollegeConstants.AR);
        }


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Splachscreen.this,NavigationMainActivity.class);//here be (home)
                // in place of navigationMainActivity, so aftar splachscreen the navigation will came.

                startActivity(i);
                finish();
               // setContentView(R.layout.splach_screen);
            }
        }, 5000);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
    //   public void goToHome(View view){
     //   Intent i=new Intent(Splachscreen.this,Home.class);
 //       startActivity(i);
  //  }
}
