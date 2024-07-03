package com.example.lastchance.main;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.lastchance.R;

public class InformasiActivity extends AppCompatActivity {
    Toolbar toolbar;
    public static final String DATA_TITLE = "TITLE";
    String strTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);

        // Inisialisasi Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        strTitle = getIntent().getExtras().getString(DATA_TITLE);
        if (strTitle != null) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setTitle(strTitle);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
