package tecsup.example.bibliosocabaya.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tecsup.example.bibliosocabaya.DevelopBD;
import tecsup.example.bibliosocabaya.Libro;
import tecsup.example.bibliosocabaya.R;
import tecsup.example.bibliosocabaya.RecyclerViewAdaptador;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewLibro;
    private RecyclerViewAdaptador adaptadorLibro;
    private ArrayList<Libro> listaLibros;

    private HomeViewModel homeViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);



        recyclerViewLibro=(RecyclerView) root.findViewById(R.id.listLibro);
        recyclerViewLibro.setLayoutManager(new LinearLayoutManager(getContext()));

        DevelopBD developBD= new DevelopBD(getActivity());

        adaptadorLibro = new RecyclerViewAdaptador(developBD.mostrarLibro());
        recyclerViewLibro.setAdapter(adaptadorLibro);


        
        return root;
    }




}