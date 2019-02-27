package com.hackoholics.hideout;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNewPropertyActivity extends AppCompatActivity {


    private static final int SELECT_PICTURE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_property);

        Spinner availableFor, facing, for_, propertyType;

        availableFor = findViewById(R.id.availableFor);
        ArrayAdapter<CharSequence> AvailableforAdapter = ArrayAdapter.createFromResource(this, R.array.availableFor, R.layout.spinner_item);
        availableFor.setAdapter(AvailableforAdapter);

        facing = findViewById(R.id.facing);
        ArrayAdapter<CharSequence> facingAdapter = ArrayAdapter.createFromResource(this, R.array.facing, R.layout.spinner_item);
        facing.setAdapter(facingAdapter);

        for_ = findViewById(R.id.forR);
        ArrayAdapter<CharSequence> forAdapter = ArrayAdapter.createFromResource(this, R.array.forR, R.layout.spinner_item);
        for_.setAdapter(forAdapter);

        propertyType = findViewById(R.id.property_type);
        ArrayAdapter<CharSequence> propertyTypeAdapter = ArrayAdapter.createFromResource(this, R.array.propertyType,R.layout.spinner_item);
        propertyType.setAdapter(propertyTypeAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            Toast.makeText(AddNewPropertyActivity.this, "Changes Saved Successfully", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(AddNewPropertyActivity.this, MyPropertiesActivity.class);
            startActivity(i);
            return true;
        } else if (id == R.id.action_cancel) {
            Intent i = new Intent(AddNewPropertyActivity.this, MyPropertiesActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void uploadPics(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Get the path from the Uri
                    String path = getPathFromURI(selectedImageUri);
                    Log.i("error", "Image Path : " + path);
                    // Set the image in ImageView
                    ((ImageView) findViewById(R.id.imgView)).setImageURI(selectedImageUri);
                }
            }
        }
    }

    /* Get the real path from the URI */
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }


}
