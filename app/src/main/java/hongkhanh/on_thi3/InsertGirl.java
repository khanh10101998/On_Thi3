package hongkhanh.on_thi3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InsertGirl extends AppCompatActivity {
    DBManager dbManager;
    EditText edtName, edtAge, edtImage;
    Button btnInsert;
    RadioGroup radioGroup;
    RadioButton radioMale, radioFemale;
    String sex = "";
    String name, age, image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_girl);
        initControl();
        initData();
        initEvent();
        initDisplay();
    }

    private void initControl() {
        radioGroup = findViewById(R.id.radioGroup_insert);
        edtName = findViewById(R.id.edt_name_insert);
        edtAge = findViewById(R.id.edt_age_insert);
        edtImage = findViewById(R.id.edt_image_insert);
        radioMale = findViewById(R.id.radio_male_insert);
        radioFemale = findViewById(R.id.radio_female_insert);
        btnInsert = findViewById(R.id.btn_insert);
    }

    private void initData() {
        dbManager = new DBManager(this);


    }

    private void initEvent() {
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtName.getText().toString();
                age = edtAge.getText().toString();
                image = edtImage.getText().toString();
                if (radioMale.isChecked()){
                    sex = "male";
                }else {
                    sex = "Female";
                }

                dbManager.AddGirl(name,age,sex,image);
                Toast.makeText(InsertGirl.this, "add Girl successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDisplay() {

    }
}
