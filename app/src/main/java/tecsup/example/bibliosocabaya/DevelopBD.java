package tecsup.example.bibliosocabaya;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.media.Image;
import android.telephony.mbms.StreamingServiceInfo;
import android.text.Html;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

import tecsup.example.bibliosocabaya.utilidades.Utilidades;

public class DevelopBD extends SQLiteOpenHelper {
    private static final String NOMBRE_BD="develop.bd";
    private  static final int VERSION_BD=1;

    public static final String TABLA_LIBROS = "CREATE TABLE LIBROS (ID TXT PRIMARY KEY, TITULO TXT, AUTOR TXT, CATEGORIA TXT, FECHA_INGRESO TXT, DESCRIPTION TXT)";
    public DevelopBD(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_LIBROS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_LIBROS);
        sqLiteDatabase.execSQL(TABLA_LIBROS);
    }

    public void agregarLibros(String id, String titulo, String autor, String categoria, String fecha_ingreso, String descripcion){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO LIBROS VALUES ('"+id+"', '"+titulo+"', '"+autor+"', '"+categoria+"', '"+fecha_ingreso+"', '"+descripcion+"')");
            bd.close();
        }
    }

    public List<Libro> mostrarLibro(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM LIBROS", null);
        List<Libro> libros=new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                libros.add(new Libro(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
            }while (cursor.moveToNext());
        }
        return libros;
    }

    public void buscarLibro(Libro libros, String id){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM LIBROS WHERE ID='"+id+"'", null);
        if (cursor.moveToFirst()){
            do{
                libros.setTitulo(cursor.getString(1));
                libros.setDescription(cursor.getString(2));
            }while (cursor.moveToNext());
        }
    }
}
