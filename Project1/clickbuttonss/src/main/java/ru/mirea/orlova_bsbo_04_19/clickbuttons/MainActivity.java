package ru.mirea.orlova_bsbo_04_19.clickbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvOut;
    private Button OK;
    private Button Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOut = (TextView) findViewById(R.id.tvOut);
        OK = (Button) findViewById(R.id.btnOk);
        Cancel = (Button) findViewById(R.id.btnCancel);

        View.OnClickListener BtnOK = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOut.setText("You've clicked OK button");
            }
        };

        OK.setOnClickListener(BtnOK);
    }



    public void onMyButtonClick(View view)
    {
        // выводим сообщение
        Toast.makeText(this, "You've clicked Cancel button", Toast.LENGTH_SHORT).show();
    }
}