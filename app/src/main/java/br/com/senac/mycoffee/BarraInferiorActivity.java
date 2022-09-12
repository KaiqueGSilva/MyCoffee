package br.com.senac.mycoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BarraInferiorActivity extends AppCompatActivity {

    //Declarando as variaveis no Java

    BottomNavigationView bottomNavigationView;

    //Instanciando as janelas (Fragments)

    CoffeeFragment coffeeFragment = new CoffeeFragment();
    MuffinFragment muffinFragment = new MuffinFragment();
    TeaFragment teaFragment = new TeaFragment();
    DonutsFragment donutsFragment = new DonutsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barra_inferior_layout);

        //Apresentando o xml ao Java
        bottomNavigationView = findViewById(R.id.idBottomNavView);

        //Carregamento do fragment default (Coffee) na janela de conteudo
        getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer,
                coffeeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.mCoffee:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, coffeeFragment)
                                .commit();
                        return true;
                    case R.id.mMuffin:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, muffinFragment)
                                .commit();
                        return true;
                    case R.id.mTea:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, teaFragment)
                                .commit();
                        return true;
                    case R.id.mDonuts:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, donutsFragment)
                                .commit();
                        return true;
                }
                return false;
            }
        });

    }
}