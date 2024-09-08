package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class SenderInfoActivity extends AppCompatActivity {

    EditText sender_email, sender_name, sender_contactinfo, sender_country, sender_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sender_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sender_view), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //retrieving ids
        sender_email = findViewById(R.id.sender_email);
        sender_name = findViewById(R.id.sender_name);
        sender_contactinfo = findViewById(R.id.sender_contactinfo);
        sender_country = findViewById(R.id.sender_country);
        sender_address = findViewById(R.id.sender_address);

        //input type for contact information
        sender_contactinfo.setInputType(InputType.TYPE_CLASS_PHONE);

        
        Button sender_btn = findViewById(R.id.sender_btn);
        sender_btn.setOnClickListener(v -> {
            if(inputChecks()){
                Intent intent = new Intent(SenderInfoActivity.this, ReceiverInfoActivity.class);
                intent.putExtra("senderFullName", Objects.requireNonNull(sender_name.getText()).toString().trim());
                intent.putExtra("senderContact", Objects.requireNonNull(sender_contactinfo.getText()).toString().trim());
                intent.putExtra("senderCountry", Objects.requireNonNull(sender_country.getText()).toString().trim());
                intent.putExtra("senderAddress", Objects.requireNonNull(sender_address.getText()).toString().trim());

                startActivity(intent);}
        });

    }

    //necessary checks
    private boolean inputChecks(){
        String email = Objects.requireNonNull(sender_email.getText()).toString().trim();
        String fullname = Objects.requireNonNull(sender_name.getText()).toString().trim();
        String ci = Objects.requireNonNull(sender_contactinfo.getText()).toString().trim();
        String country = Objects.requireNonNull(sender_country.getText()).toString().trim();
        String address = Objects.requireNonNull(sender_address.getText()).toString().trim();

        if (email.isEmpty()||fullname.isEmpty()||ci.isEmpty()||country.isEmpty()||address.isEmpty()){
            Toast.makeText(this,"FILL ALL FIELDS",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!email.contains("@")){
            Toast.makeText(this, "USE CORRECT EMAIL FORMAT", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}