package thamen.om;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

import thamen.om.thamen.R;
import thamen.om.utils.GulfCollegeConstants;

public class GulfCollegeBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gulf_college_base);
    }
    public void changeLang(String lang){
        Locale myLocale=new Locale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale=myLocale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
       SharedPreferences sharedPreferences=getSharedPreferences(GulfCollegeConstants.LAND_FILE,MODE_PRIVATE);
       SharedPreferences.Editor editor=sharedPreferences.edit();
      editor.putString(GulfCollegeConstants.LANG,lang);
editor.commit();
}}
