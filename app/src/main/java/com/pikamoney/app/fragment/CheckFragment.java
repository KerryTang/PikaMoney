package com.pikamoney.app.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.pikamoney.app.R;

public class CheckFragment extends Fragment {

    private int count;
    private ImageView imageView;

    private String packageName;

    public CheckFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        packageName = getActivity().getPackageName();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView_check);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    imageView.setImageResource(getResources().getIdentifier("img_check_" + (count++)%6, "drawable", packageName));
            }
        });
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
