package pvlinh.demo.androidfragmentbasic2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Intent intent = getIntent();
        int index = intent.getIntExtra("index", 0);
        FragmentTwo f2 = (FragmentTwo) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        if(f2 != null){
            f2.changeData(index);
        }
    }
}
