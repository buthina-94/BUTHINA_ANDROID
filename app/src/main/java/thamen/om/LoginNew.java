package thamen.om;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class LoginNew extends AppCompatActivity {

    private EditText user,pass;
    private Button already_register,register;
    private String mUser,mPass;
    private FirebaseAuth mAuth;
    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(

            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_LoginNew);
        mAuth = FirebaseAuth.getInstance();
        user = findViewById(R.id.user_id1);
        pass = findViewById(R.id.password2);
        register = findViewById(R.id.register);
        already_register = findViewById(R.id.already_register);

        already_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUser = user.getText().toString().trim();
                mPass = pass.getText().toString().trim();
                checkedittxt();
                FirebaseUser currebtUser = mAuth.getCurrentUser();
                mAuth.signInWithEmailAndPassword(mUser, mPass).addOnCompleteListener(LoginNew.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginNew.this, "Login Successfuly", Toast.LENGTH_LONG).show();
                        }
                    }


                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        });
        register.setOnClick(View v) {
            Intent intent = new Intent(LoginNew.this, RegistrationNew.class);
            startActivity(intent);
        }
    });
}

    private void checkedittxt() {
    if(TextUtils.isEmpty(mUser){

    });

    }
}
