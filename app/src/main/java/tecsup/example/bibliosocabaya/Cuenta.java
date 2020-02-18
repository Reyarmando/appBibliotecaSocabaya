package tecsup.example.bibliosocabaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static tecsup.example.bibliosocabaya.R.id.action_cuenta;

public class Cuenta extends AppCompatActivity implements View.OnClickListener {

    EditText usuario, contraseña;
    Button entrar, registrarse;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);
        usuario=(EditText)findViewById(R.id.Usuario);
        contraseña=(EditText)findViewById(R.id.Contraseña);
        entrar=(Button)findViewById(R.id.Entrar);
        registrarse=(Button)findViewById(R.id.Registrarse);
        dao=new daoUsuario(this);

        entrar.setOnClickListener(this);
        registrarse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Entrar:
                String u= usuario.getText().toString();
                String p= contraseña.getText().toString();
                if (u.equals("")&&p.equals("")){
                    Toast.makeText(this, "ERROR: Campos vacios.", Toast.LENGTH_LONG).show();
                }else if (dao.login(u,p)==1){
                    Usuario ux=dao.getUsuario(u,p);
                    Toast.makeText(this, "Datos correctos", Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(Cuenta.this,CRUD.class);


                    i2.putExtra("Id", ux.getId());
                    startActivity(i2);
                }else{
                    Toast.makeText(this, "Usuario y/o Contraseña erronea", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.Registrarse:
                Intent i=new Intent(Cuenta.this,Registrar.class);
                startActivity(i);
                break;
        }

    }
}
