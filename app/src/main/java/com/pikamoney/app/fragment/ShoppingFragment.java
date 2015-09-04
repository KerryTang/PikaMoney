package com.pikamoney.app.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import com.pikamoney.app.R;

public class ShoppingFragment extends Fragment {

    private ImageView mAd1, mAd2;
    private Button mBtn1, mBtn2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_shopping, container, false);

        mAd1 = (ImageView) v.findViewById(R.id.imageView_shopping_ad_1);
        mAd2 = (ImageView) v.findViewById(R.id.imageView_shopping_ad_2);
        mBtn1 = (Button) v.findViewById(R.id.button_shopping_like_ad1);
        mBtn2 = (Button) v.findViewById(R.id.button_shopping_like_ad2);

        RadioGroup radioGroup = (RadioGroup) v.findViewById(R.id.radioGroup_shopping);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton_shopping_like:
                        mAd1.setImageResource(R.drawable.img_ad_like_0);
                        mAd2.setImageResource(R.drawable.img_ad_like_1);
                        mBtn1.setBackgroundResource(R.drawable.button_go);
                        mBtn2.setBackgroundResource(R.drawable.button_go);

                        break;
                    case R.id.radioButton_shopping_need:
                        mAd1.setImageResource(R.drawable.img_ad_need_0);
                        mAd2.setImageResource(R.drawable.img_ad_need_1);
                        mBtn1.setBackgroundResource(R.drawable.button_buy);
                        mBtn2.setBackgroundResource(R.drawable.button_buy);

                        break;
                }

            }
        });
        return v;
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
