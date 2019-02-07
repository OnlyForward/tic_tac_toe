package shibanov.tic_tac_toe.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import shibanov.tic_tac_toe.R;

public class BackCardFragment extends Fragment {

    private static String IMAGE = "IMAGE";

    public static Fragment startFragment(int name){
        Bundle bundle =new Bundle();
        bundle.putInt(IMAGE,name);
        Fragment fragment = new BackCardFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card,container,false);

        final int id = getArguments().getInt(IMAGE);

        final ImageButton btn = (ImageButton)view.findViewById(R.id.image_tic_tac);
        btn.setImageResource(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setClickable(false);
            }
        });

        return view;
    }
}
