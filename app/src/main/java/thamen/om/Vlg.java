package thamen.om;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import thamen.om.thamen.R;

public class Vlg extends AppCompatActivity {
    EditText et1, et2;
    CheckBox checkBox;
    Button login;
    String str1, str2;
    private final int FLAG = 1;
    private final int FLAG1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.optionsss));
        setContentView(R.layout.login11);
        et1 = findViewById(R.id.user_id);
        et2 = findViewById(R.id.password);
        checkBox = findViewById(R.id.checkBox);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                str1 = et1.getText().toString();
                str2 = et2.getText().toString();
                Intent intent = new Intent(Vlg.this, HandleData.class);
                intent.putExtra("key1", str1);
                intent.putExtra("key2", str2);
                startActivityForResult(intent, FLAG);

                //Toast.makeText(Vlg.this,str1+str2,Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FLAG && resultCode == RESULT_OK) {
            String result = data.getStringExtra("key3");
            Toast.makeText(Vlg.this,result,Toast.LENGTH_LONG).show();
        }
    }
//        }
//        if(requestCode==FLAG && requestCode == RESULT_OK )
//    }
}
