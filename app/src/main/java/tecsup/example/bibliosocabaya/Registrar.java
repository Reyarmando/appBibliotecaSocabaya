package tecsup.example.bibliosocabaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
    EditText usuario, contraseña, nombres, apellidos;
    Button registrarse, cancelar;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        usuario=(EditText)findViewById(R.id.RegUsuario);
        contraseña=(EditText)findViewById(R.id.RegContraseña);
        nombres=(EditText)findViewById(R.id.RegNombres);
        apellidos=(EditText)findViewById(R.id.RegApellidos);
        registrarse=(Button)findViewById(R.id.RegRegistrar);
        cancelar=(Button)findViewById(R.id.RegCancelar);
        dao=new daoUsuario(this);

        registrarse.setOnClickListener(this);
        cancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RegRegistrar:
                Usuario u = new Usuario();
                u.setUsuario(usuario.getText().toString());
                u.setContraseña(contraseña.getText().toString());
                u.setNombres(nombres.getText().toString());
                u.setApellidos(apellidos.getText().toString());
                if (!u.isNull()){
                    Toast.makeText(this, "ERROR: Campos vacios", Toast.LENGTH_LONG).show();
                }else if (dao.insertUsuario(u)){
                    Toast.makeText(this, "Registro Exitoso!!!", Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(Registrar.this,Cuenta.class);
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this, "Usuario registrado", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.RegCancelar:
                Intent i=new Intent(Registrar.this,Cuenta.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
