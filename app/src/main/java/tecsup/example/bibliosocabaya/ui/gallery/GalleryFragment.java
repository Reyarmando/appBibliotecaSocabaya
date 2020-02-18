package tecsup.example.bibliosocabaya.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import tecsup.example.bibliosocabaya.DevelopBD;
import tecsup.example.bibliosocabaya.R;
import tecsup.example.bibliosocabaya.RecyclerViewAdaptador;

public class GalleryFragment extends Fragment {

    private RecyclerView recyclerViewLibro;
    private RecyclerViewAdaptador adaptadorLibro;

    private GalleryViewModel galleryViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        recyclerViewLibro=(RecyclerView) root.findViewById(R.id.listLibro);
        recyclerViewLibro.setLayoutManager(new LinearLayoutManager(getContext()));

        DevelopBD developBD= new DevelopBD(getActivity());

        adaptadorLibro = new RecyclerViewAdaptador(developBD.mostrarLibro());
        recyclerViewLibro.setAdapter(adaptadorLibro);


        return root;
    }
}