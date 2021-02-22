package com.blm.iibo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {

    public static EditText eName;
    private EditText ePassword;
    private Button elogin;

    private Button eregister;

    private String admin = "Admin";
    private String apassword = "1234567";

    private boolean isValid = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.etusername);
        ePassword = findViewById(R.id.etpassword);
        elogin = findViewById(R.id.btnlogin);
        eregister = findViewById(R.id.btnSignUp);

        elogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText( MainActivity.this, "Incorrect credentials", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    isValid = validate(inputName, inputPassword);
                    if(!isValid)
                    {
                        Toast.makeText(MainActivity.this, "Incorrect credentials", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText( MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        eregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterPage.class);
                startActivity(intent);
            }
        });
    }


    private boolean validate(String name, String password)
    {
        if(name.equals(admin) && password.equals(apassword))
            return true;

        if(RegisterPage.credentials.containsKey(name))
            return RegisterPage.credentials.get(name).equals(password);
        return false;
    }
}