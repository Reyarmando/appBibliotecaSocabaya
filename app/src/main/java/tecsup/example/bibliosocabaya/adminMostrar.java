





package tecsup.example.bibliosocabaya;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class adminMostrar extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;

    private RecyclerView recyclerViewLibro;
    private RecyclerViewAdaptador adaptadorLibro;

    Button btnBuscar;
    EditText buscarId;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mostrar);

        toolbar = findViewById(R.id.mi_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setSubtitle("com.empresa");

        btnBuscar=(Button)findViewById(R.id.btnBuscar);
        buscarId=(EditText)findViewById(R.id.id);

        recyclerViewLibro=(RecyclerView)findViewById(R.id.recyclerLibroAdmin);
        recyclerViewLibro.setLayoutManager(new LinearLayoutManager(this));

        final DevelopBD developBD= new DevelopBD(getApplicationContext());

        adaptadorLibro= new RecyclerViewAdaptador(developBD.mostrarLibro());
        recyclerViewLibro.setAdapter(adaptadorLibro);




        btnBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Libro libros = new Libro();
                developBD.buscarLibro(libros,buscarId.getText().toString());
                adaptadorLibro= new RecyclerViewAdaptador(developBD.mostrarLibro());
                recyclerViewLibro.setAdapter(adaptadorLibro);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menuprincipal){
        getMenuInflater().inflate(R.menu.menuprincipal,menuprincipal);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menu_elegido){
        int id = menu_elegido.getItemId();
        if (id==R.id.configuracion){
            Toast.makeText(this, "Elegiste menu configuracion", Toast.LENGTH_LONG).show();
            Intent llamaractividad = new Intent(getApplicationContext(),adminMostrar.class);
            startActivity(llamaractividad);
            return true;
        }
        if (id==R.id.informacion){
            Toast.makeText(this, "Elegiste menu informacion", Toast.LENGTH_LONG).show();
            Intent llamaractividad = new Intent(getApplicationContext(),agregarLibro.class);
            startActivity(llamaractividad);
            return true;
        }
        return super.onOptionsItemSelected(menu_elegido);
    }


}
