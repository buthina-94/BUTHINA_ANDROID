package thamen.om.thamen;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
public class Conectus extends AppCompatActivity {
TextView textView22,textView18;
public static final  int MY_PERMISSIONS_REQUEST=1;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        textView22= findViewById(R.id.textView22);
        textView18= findViewById(R.id.textView18);
        textView22.setText(Html.fromHtml(getString(R.string.mail)));
        textView18.setText(Html.fromHtml(getString(R.string.mail)));
    }


    public void open(View view) {
        int id= view.getId();
        switch (id){
            case R.id.textView22:

                Intent emailIntent  = new Intent(Intent.ACTION_SEND);
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                emailIntent.setType("vnd.android.cursor.item/email");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"gcollege@omantel.net.om","Buthina_94@hotmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"BODY");
                startActivity(Intent.createChooser(emailIntent,"chooser"));
                break;
            case  R.id.textView18:
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:98754321"));
                if(ContextCompat.checkSelfPermission(Conectus.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(Conectus.this, Manifest.permission.CALL_PHONE)){
                    //show the reason why app required this permission
                    //called permission rationale.

                }
                     else {
                    ActivityCompat.requestPermissions(Conectus.this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST);

                }
                }
                else {
                    startActivity(intent);
                }


                break;
            case  R.id.textView23:
                Uri gmmIntentUri = Uri.parse("geo:23.6401,58.0927");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                     intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:98754321"));
                    startActivity(intent);
                }
                }
        }
    }
