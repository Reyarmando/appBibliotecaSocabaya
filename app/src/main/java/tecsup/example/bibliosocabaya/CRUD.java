package tecsup.example.bibliosocabaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CRUD extends AppCompatActivity {

    Button agregar, mostrar, editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        agregar = (Button)findViewById(R.id.Agregar);
        mostrar = (Button)findViewById(R.id.Mostrar);
        editar = (Button)findViewById(R.id.Editar);


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agregarLibros=new Intent(getApplicationContext(),agregarLibro.class);
                startActivity(agregarLibros);
            }
        });

        mostrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent mostrarLibros=new Intent(getApplicationContext(),adminMostrar.class);
                startActivity(mostrarLibros);
            }
        });

        editar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent editarLibros=new Intent(getApplicationContext(),editarLibro.class);
                startActivity(editarLibros);
            }
        });

    }

}
