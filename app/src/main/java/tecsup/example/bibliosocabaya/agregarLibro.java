package tecsup.example.bibliosocabaya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class agregarLibro extends AppCompatActivity {

    EditText edtId,edtTitulo, edtAutor, edtCategoria, edtFecha_ingreso, edtDescription, edtEditorial, edtCantidad;
    Button btnAgregar, btnEditar, btnMostrar, btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_libro);

        edtId = (EditText)findViewById(R.id.id);
        edtTitulo = (EditText)findViewById(R.id.titulo);
        edtAutor = (EditText)findViewById(R.id.autor);
        edtCategoria = (EditText)findViewById(R.id.categoria);
        edtFecha_ingreso = (EditText)findViewById(R.id.fecha_ingreso);
        edtDescription = (EditText)findViewById(R.id.description);
        edtEditorial = (EditText)findViewById(R.id.editorial);
        edtCantidad = (EditText)findViewById(R.id.cantidad);
        btnAgregar = (Button)findViewById(R.id.btnAgregar);
        btnEditar = (Button)findViewById(R.id.btnEditar);
        btnMostrar = (Button)findViewById(R.id.btnMostrar);
        btnEliminar = (Button)findViewById(R.id.btnEliminar);

        final DevelopBD developBD = new DevelopBD(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ejecutarServicio("http//192.168.139.1:50/biblioteca/insertarProducto.php");

                //developBD.agregarLibros(edtId.getText().toString(), edtTitulo.getText().toString(), edtAutor.getText().toString(), edtCategoria.getText().toString(), edtFecha_ingreso.getText().toString(), edtDescription.getText().toString());
                //Toast.makeText(getApplicationContext(), "LIBRO AGREGADO!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros=new HashMap<String, String>();
                parametros.put("id",edtId.getText().toString());
                parametros.put("titulo",edtTitulo.getText().toString());
                parametros.put("autor",edtAutor.getText().toString());
                parametros.put("categoria",edtCategoria.getText().toString());
                parametros.put("editorial",edtEditorial.getText().toString());
                parametros.put("fecha_ingreso",edtFecha_ingreso.getText().toString());
                parametros.put("descripcion",edtDescription.getText().toString());
                parametros.put("cantidad",edtCantidad.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
