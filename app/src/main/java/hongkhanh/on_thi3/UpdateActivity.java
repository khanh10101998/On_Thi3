package hongkhanh.on_thi3;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    DBManager dbManager;
    EditText edtName, edtAge, edtImage, edtDate;
    Button btnInsert;
    RadioGroup radioGroup;
    RadioButton radioMale, radioFemale;
    String sex = "";
    String name, age, image;
    Model model;
    int id;

    DatePickerDialog datePickerDialog;


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
        edtDate = findViewById(R.id.date);
        radioGroup = findViewById(R.id.radioGroup_insert);
        edtName = findViewById(R.id.edt_name_insert);
        edtAge = findViewById(R.id.edt_age_insert);
        edtImage = findViewById(R.id.edt_image_insert);
        radioMale = findViewById(R.id.radio_male_insert);
        radioFemale = findViewById(R.id.radio_female_insert);
        btnInsert = findViewById(R.id.btn_insert);
    }

    private void initData() {
        model = new Model();
        dbManager = new DBManager(this);
        model = (Model) getIntent().getSerializableExtra("DATA");
        id = model.getmID();
        name = model.getmName();
        age = model.getmAge();
        sex = model.getmSex();
        image = model.getmAvatar();
        edtName.setText(name);
        edtAge.setText(age);
        edtImage.setText(image);

        if(sex.equals("male")){
            radioGroup.check(R.id.radio_male_insert);
        }else {
            radioGroup.check(R.id.radio_female_insert);
        }
        btnInsert.setText("update");

    }

    private void initEvent() {

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePickerDialog = new DatePickerDialog(UpdateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        edtDate.setText(i2+"/"+i1+"/"+i);
                    }
                },2018,1 ,1);
                datePickerDialog.show();
            }

        });

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
                Toast.makeText(UpdateActivity.this, "id: "+ id, Toast.LENGTH_SHORT).show();
                int update = dbManager.UpdateGirl(String.valueOf(id),name,age,sex,image);
                if (update > 0){
                    Toast.makeText(UpdateActivity.this, "add Girl successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateActivity.this,MainActivity.class));
                }else {
                    Toast.makeText(UpdateActivity.this, "Update Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        edtImage.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                    Toast.makeText(UpdateActivity.this, "da chon hinh", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    private void initDisplay() {

    }
}
