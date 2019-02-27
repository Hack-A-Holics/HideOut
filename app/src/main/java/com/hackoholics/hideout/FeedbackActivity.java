package com.hackoholics.hideout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity {

    private Button submit;
    private EditText feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        submit = findViewById(R.id.submit_feedback);
        feedback = findViewById(R.id.EditText_Feedback);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = feedback.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND, Uri.fromParts(
                        "mailto","abc@gmail.com", null));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack For HideOut");
                intent.putExtra(Intent.EXTRA_TEXT, msg);
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });

    }
}
