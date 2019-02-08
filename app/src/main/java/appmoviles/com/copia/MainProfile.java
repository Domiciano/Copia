package appmoviles.com.copia;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

//5. implementar la interfaz
public class MainProfile extends FragmentActivity implements FragmentA.FragmentAActions {

    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);

        fragmentA = new FragmentA();
        fragmentA.setListener(this);
        fragmentB = new FragmentB();
        fragmentC = new FragmentC();


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.menubar_home:
                        transaction.replace(R.id.contenido, fragmentA);
                        transaction.commit();
                        break;
                    case R.id.menubar_notifications:
                        transaction.replace(R.id.contenido, fragmentB);
                        transaction.commit();
                        break;
                    case R.id.menubar_feed:
                        transaction.replace(R.id.contenido, fragmentC);
                        transaction.commit();
                        break;
                }

                return true;
            }
        });

    }

    //5. Implementar metodos de la interfaz
    @Override
    public void onMessage(String msj) {
        Toast.makeText(this, msj, Toast.LENGTH_LONG).show();
    }
}
