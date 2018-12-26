package thamen.om;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import thamen.om.thamen.R;

public class HandleData extends AppCompatActivity {
TextView textView;
String user,pass;
public final int FLAG=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_data);
        Intent i=getIntent();
      user= i.getStringExtra("key1");
      pass=i.getStringExtra("key2");
      Intent intent=new Intent(HandleData.this, Vlg.class);
      String string=user+":"+pass;
      intent.putExtra("key3",string);
      setResult(RESULT_OK,intent);
      finish();

//        textView=findViewById(R.id.textView7);
//        textView.setText(user+pass);
    }
}
