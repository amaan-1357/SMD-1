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

public class ReceiverInfoActivity extends AppCompatActivity {

    EditText rec_email, rec_name, rec_contactinfo, rec_country, rec_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receiver_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.receiver_view), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //retrieving ids
        rec_email = findViewById(R.id.rec_email);
        rec_name = findViewById(R.id.rec_name);
        rec_contactinfo = findViewById(R.id.rec_contactinfo);
        rec_country = findViewById(R.id.rec_country);
        rec_address = findViewById(R.id.rec_address);

        //input type for contact information
        rec_contactinfo.setInputType(InputType.TYPE_CLASS_PHONE);

        String senderFullName = getIntent().getStringExtra("senderFullName");
        String senderContact = getIntent().getStringExtra("senderContact");
        String senderAddress = getIntent().getStringExtra("senderAddress");
        String senderCountry = getIntent().getStringExtra("senderCountry");

        Button rec_btn = findViewById(R.id.rec_btn);
        rec_btn.setOnClickListener(v -> {
            if(inputChecks()){
                Intent intent = new Intent(ReceiverInfoActivity.this, ReviewInfoActivity.class);
                intent.putExtra("recFullName", Objects.requireNonNull(rec_name.getText()).toString().trim());
                intent.putExtra("recContact", Objects.requireNonNull(rec_contactinfo.getText()).toString().trim());
                intent.putExtra("recCountry", Objects.requireNonNull(rec_country.getText()).toString().trim());
                intent.putExtra("recAddress", Objects.requireNonNull(rec_address.getText()).toString().trim());
                intent.putExtra("senderFullName", Objects.requireNonNull(senderFullName));
                intent.putExtra("senderContact", Objects.requireNonNull(senderContact));
                intent.putExtra("senderAddress", Objects.requireNonNull(senderAddress));
                intent.putExtra("senderCountry", Objects.requireNonNull(senderCountry));

                startActivity(intent);}
        });

    }

    //necessary checks
    private boolean inputChecks(){
        String email = Objects.requireNonNull(rec_email.getText()).toString().trim();
        String fullname = Objects.requireNonNull(rec_name.getText()).toString().trim();
        String ci = Objects.requireNonNull(rec_contactinfo.getText()).toString().trim();
        String country = Objects.requireNonNull(rec_country.getText()).toString().trim();
        String address = Objects.requireNonNull(rec_address.getText()).toString().trim();

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