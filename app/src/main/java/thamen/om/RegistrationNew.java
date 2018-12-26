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

import java.util.regex.Pattern;

public class RegistrationNew extends AppCompatActivity {

    private android.R.attr R;
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
        setContentView(R.layout.activity_RegistrationNew_page);
        mAuth=FirebaseAuth.getInstance();
        user=findViewById(R.id.user_id1);
        pass=findViewById(R.id.password2);
        register=findViewById(R.id.register);
        already_register=findViewById(R.id.already_register);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mUser = user.getText().toString().trim();
                mPass = pass.getText().toString().trim();
                if (TextUtils.isEmpty(mUser)) {
                    user.setError("Please Enter user name");
                    return;
                }
                if (!isVALIDeMALL(mUser)) {
                    user.setError("please provid a vaild mail id");
                    Toast.makeText(RegistrationNew.this, "Mail id is not valid", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mPass) || mPass.length() < 6) {
                    Toast.makeText(RegistrationNew.this, "password field is empty or" + "It should have password should have at least six characters", Toast.LENGTH_LONG).show();
                    pass.setError("plz provide a valid password should have at least 6 character");
                    return;
                }
                mAuth.createUserWithEmailAndPassword(mUser, mPass).addOnCompleteListener(RegistrationNew.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegistrationNew.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                            Intent loginIntent = new Intent(RegistrationNew.this, LoginNew.class);
                            startActivity(loginIntent);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {

                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });
                already_register.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent loginIntent = new Intent(RegistrationNew.this, RegistrationNew.class);
                        {
                            startActivity(loginIntent);

                        }
                    }
                });
            }

            private boolean isVALIDeMALL(String email) {
                return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
            }

        }
    }




