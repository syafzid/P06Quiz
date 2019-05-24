package sg.edu.rp.soi.p06_quiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView displayResult, operations;
    EditText etNum1, etNum2;
    Button btnReset;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayResult = findViewById(R.id.textView);
        operations = findViewById(R.id.tvOperation);
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnReset = findViewById(R.id.btnReset);

        registerForContextMenu(operations);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNum1.setText("");
                etNum2.setText("");
                displayResult.setText("");
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"+");
        menu.add(0,1,1,"-");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) {
            result = Integer.parseInt(etNum1.getText().toString()) + Integer.parseInt(etNum2.getText().toString());
            displayResult.setText(result);
            return true;
        } else if(item.getItemId()==1) {
            result = Integer.parseInt(etNum1.getText().toString()) - Integer.parseInt(etNum2.getText().toString());
            displayResult.setText(result);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
