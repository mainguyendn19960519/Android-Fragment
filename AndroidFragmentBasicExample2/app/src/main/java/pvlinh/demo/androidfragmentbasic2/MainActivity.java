package pvlinh.demo.androidfragmentbasic2;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnFragmentInteractionListener{
    FragmentOne f1;
    FragmentTwo f2;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        f1 = (FragmentOne) manager.findFragmentById(R.id.fragment1);
    }

    @Override
    public void onResponse(int index) {
        f2 = (FragmentTwo) manager.findFragmentById(R.id.fragment2);
        if(f2 != null){
            f2.changeData(index);
        }else{
            Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }
    }
}
