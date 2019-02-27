package com.hackoholics.hideout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class DetailsActivity extends AppCompatActivity {

    private ImageButton bookmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        bookmark=findViewById(R.id.wishList);
        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bookmark.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.bookmark_unselected).getConstantState()){
                    bookmark.setImageResource(R.drawable.bookmark_selected);
                }
                else if(bookmark.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.bookmark_selected).getConstantState()){
                    bookmark.setImageResource(R.drawable.bookmark_unselected);
                }
            }
        });
    }
}
