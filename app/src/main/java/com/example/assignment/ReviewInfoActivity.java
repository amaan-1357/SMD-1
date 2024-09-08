package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewInfoActivity extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_info);

        tableLayout = findViewById(R.id.tbl_info);

        String senderFullName = getIntent().getStringExtra("senderFullName");
        String senderContact = getIntent().getStringExtra("senderContact");
        String senderAddress = getIntent().getStringExtra("senderAddress");
        String senderCountry = getIntent().getStringExtra("senderCountry");

        String receiverFullName = getIntent().getStringExtra("recFullName");
        String receiverCountry = getIntent().getStringExtra("recCountry");
        String receiverAddress = getIntent().getStringExtra("recAddress");
        String receiverContact = getIntent().getStringExtra("recContact");

        // Add sender-receiver pairs dynamically
        addSenderReceiverPair(senderFullName,senderCountry,senderAddress,senderContact,receiverFullName,receiverCountry,receiverAddress,receiverContact);
    }

    public void goToSenderInfo(View view) {
        Intent intent = new Intent(this, SenderInfoActivity.class);
        startActivity(intent);
    }

    private void addSenderReceiverPair(String senderName, String senderCountry, String senderAddress, String senderContactInfo,
                                       String receiverName, String receiverCountry, String receiverAddress, String receiverContactInfo) {

        TableRow senderRow = new TableRow(this);

        TextView senderNameTextView = new TextView(this);
        senderNameTextView.setText(senderName);
        senderNameTextView.setPadding(8, 8, 8, 8);
        senderRow.addView(senderNameTextView);

        TextView senderCountryTextView = new TextView(this);
        senderCountryTextView.setText(senderCountry);
        senderCountryTextView.setPadding(8, 8, 8, 8);
        senderRow.addView(senderCountryTextView);

        TextView senderAddressTextView = new TextView(this);
        senderAddressTextView.setText(senderAddress);
        senderAddressTextView.setPadding(8, 8, 8, 8);
        senderRow.addView(senderAddressTextView);

        TextView senderContactInfoTextView = new TextView(this);
        senderContactInfoTextView.setText(senderContactInfo);
        senderContactInfoTextView.setPadding(8, 8, 8, 8);
        senderRow.addView(senderContactInfoTextView);

        tableLayout.addView(senderRow);

        TableRow arrowRow = new TableRow(this);

        ImageView arrowImageView = new ImageView(this);
        arrowImageView.setImageResource(R.drawable.ic_transaction_arrow);
        arrowImageView.setMaxHeight(50);
        arrowImageView.setMaxWidth(50);
        arrowRow.addView(arrowImageView);

        tableLayout.addView(arrowRow);

        TableRow receiverRow = new TableRow(this);

        TextView receiverNameTextView = new TextView(this);
        receiverNameTextView.setText(receiverName);
        receiverNameTextView.setPadding(8, 8, 8, 8);
        receiverRow.addView(receiverNameTextView);

        TextView receiverCountryTextView = new TextView(this);
        receiverCountryTextView.setText(receiverCountry);
        receiverCountryTextView.setPadding(8, 8, 8, 8);
        receiverRow.addView(receiverCountryTextView);

        TextView receiverAddressTextView = new TextView(this);
        receiverAddressTextView.setText(receiverAddress);
        receiverAddressTextView.setPadding(8, 8, 8, 8);
        receiverRow.addView(receiverAddressTextView);

        TextView receiverContactInfoTextView = new TextView(this);
        receiverContactInfoTextView.setText(receiverContactInfo);
        receiverContactInfoTextView.setPadding(8, 8, 8, 8);
        receiverRow.addView(receiverContactInfoTextView);

        tableLayout.addView(receiverRow);
    }
}
