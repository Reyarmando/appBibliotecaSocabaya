package tecsup.example.bibliosocabaya;

import java.sql.Blob;

public class Libro {
    String Id, Titulo, Autor, Categoria, Fecha_ingreso, Description;


    public Libro(){
    }

    public Libro(String id, String titulo, String autor, String categoria, String fecha_ingreso, String description) {
        Id= id;
        Titulo= titulo;
        Autor = autor;
        Categoria = categoria;
        Fecha_ingreso = fecha_ingreso;
        Description = description;

    }

    @Override
    public String toString() {
        return "Libro{" +
                "Id='" + Id + '\'' +
                ", Titulo='" + Titulo + '\'' +
                ", Autor='" + Autor + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", Fecha_ingreso='" + Fecha_ingreso + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }

    public boolean isNull(){
        if(Autor.equals("")&&Categoria.equals("")&&Fecha_ingreso.equals("")&&Description.equals("")){
            return false;
        }else{
            return true;
        }
    }




    public String getId() {
        return Id;
    }

    public void setId(int id) {
        Id = Id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getFecha_ingreso() {
        return Fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        Fecha_ingreso = fecha_ingreso;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


}
