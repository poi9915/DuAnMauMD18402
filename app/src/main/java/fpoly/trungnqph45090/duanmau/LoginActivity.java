package fpoly.trungnqph45090.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    TextInputLayout edUsername, edPassword;

    private String dfUsername = "admin";
    private String dfPassword = "1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edPassword = findViewById(R.id.edPassword);
        edUsername = findViewById(R.id.edUsername);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(view ->{
            String username = edUsername.getEditText().getText().toString();
            String password =edPassword.getEditText().getText().toString();
            if (username.equals(dfUsername) && password.equals(dfPassword)){
                startActivity(new Intent(LoginActivity.this ,MainActivity.class));
            }

        });
    }
}