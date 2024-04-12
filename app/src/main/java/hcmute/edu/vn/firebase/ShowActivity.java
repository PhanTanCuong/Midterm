package hcmute.edu.vn.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {


    //Vars
    GridView gridView;
    ArrayList<Model_Image> dataList;
    MyAdapter adapter;
    final private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Image");
    private StorageReference storageReference = FirebaseStorage.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        gridView=findViewById(R.id.gridView);

        dataList = new ArrayList<>();

        adapter = new MyAdapter(dataList, this);
        gridView.setAdapter(adapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                Model_Image dataClass= dataSnapshot.getValue(Model_Image.class);
                dataList.add(dataClass);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}