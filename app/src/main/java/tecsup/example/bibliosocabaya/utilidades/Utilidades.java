package tecsup.example.bibliosocabaya.utilidades;

public class Utilidades {

    public static final String TABLA_LIBROS="LIBROS";
    public static final String ID="ID";
    public static final String TITULO="TITULO";
    public static final String AUTOR="AUTOR";
    public static final String CATEGORIA="CATEGORIA";
    public static final String FECHA_INGRESO="FECHA_INGRESO";
    public static final String DESCRIPTION="DESCRIPTION";

    public static final String CREAR_TABLA_LIBROS = "CREATE TABLE "+TABLA_LIBROS+" ("+ID+" TXT PRIMARY KEY, "+TITULO+" TXT, "+AUTOR+" TXT, "+CATEGORIA+" TXT, "+FECHA_INGRESO+" TXT, "+DESCRIPTION+" TXT)";



}
