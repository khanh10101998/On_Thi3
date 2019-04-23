package hongkhanh.on_thi3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    AdapterMain adapterMain;
    ArrayList<Model> arrayList;
    ListView listView;
    Button btnInsert, btnUpdate;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
        initData();
        initEvent();
        initDisplay();
    }

    private void initControl() {
        listView = findViewById(R.id.lv_main);
        btnInsert = findViewById(R.id.btn_insert);
        btnUpdate = findViewById(R.id.btn_update);
    }

    private void initData() {
dbManager = new DBManager(this);
        arrayList = new ArrayList<>();

        if(dbManager != null){
            arrayList = dbManager.gettAllGirl();
        }else {
            Toast.makeText(this, "Chua co database", Toast.LENGTH_SHORT).show();
        }
        adapterMain = new AdapterMain(this, arrayList);


        listView.setAdapter(adapterMain);

    }

    private void initEvent() {
        btnInsert.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(MainActivity.this, UpdateActivity.class);
                int id = arrayList.get(i).getmID();
                String name = arrayList.get(i).getmName();
                String age = arrayList.get(i).getmAge();
                String sex = arrayList.get(i).getmSex();
                String image = arrayList.get(i).getmAvatar();
                Model model = new Model(id,name,age,image,sex);
                intent1.putExtra("DATA",model);
                startActivity(intent1);
            }
        });
    }

    private void initDisplay() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_insert: {
                startActivity(new Intent(this, InsertGirl.class));
            }
            break;
            case R.id.btn_update: {

            }
            break;
        }
    }
}
