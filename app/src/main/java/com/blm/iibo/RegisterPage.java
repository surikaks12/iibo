package com.blm.iibo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class RegisterPage extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private EditText ePassword2;
    private Button eRegister;

    static HashMap<String, String> credentials = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        eName = findViewById(R.id.retUserName);
        ePassword = findViewById(R.id.retPassword);
        ePassword2 = findViewById(R.id.retPassword2);
        eRegister = findViewById(R.id.rbtnRegister);

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();
                String inputPassword2 = ePassword2.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty() || inputPassword2.isEmpty())
                {
                    Toast.makeText( RegisterPage.this, "Please enter all credentials", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(!inputPassword.equals(inputPassword2))
                    {
                        Toast.makeText( RegisterPage.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(credentials.containsKey(inputName))
                            Toast.makeText( RegisterPage.this, "Username already taken", Toast.LENGTH_SHORT).show();
                        else {
                            credentials.put(inputName, inputPassword);
                            Intent intent = new Intent(RegisterPage.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}