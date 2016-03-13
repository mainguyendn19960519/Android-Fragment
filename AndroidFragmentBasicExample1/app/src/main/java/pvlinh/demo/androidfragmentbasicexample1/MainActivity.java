package pvlinh.demo.androidfragmentbasicexample1;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    boolean status = false;
    private Button btnChangeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChangeFragment = (Button) findViewById(R.id.btnChangeFragment);

        btnChangeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                if(!status){
                    Log.i("TAG","load fragment 1");
                    FragmentOne fo = new FragmentOne();
                    transaction.add(R.id.fragment_container,fo);
                    transaction.commit();
                    btnChangeFragment.setText("Load Fragment 2");
                    status = true;
                }else{
                    Log.i("TAG","load fragment 2");
                    FragmentTwo fw = new FragmentTwo();
                    transaction.add(R.id.fragment_container,fw);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    btnChangeFragment.setText("Load Fragment 1");
                    status = false;
                }
            }
        });
    }
}
