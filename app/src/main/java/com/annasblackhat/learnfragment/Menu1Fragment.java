package com.annasblackhat.learnfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu1Fragment extends Fragment {


    public Menu1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu1, container, false);

        view.findViewById(R.id.btn_detail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceData();
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getContext(), "ondestroy menu 1", Toast.LENGTH_SHORT).show();
    }
}
