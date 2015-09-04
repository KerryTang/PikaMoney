package com.pikamoney.app.fragment;

import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.pikamoney.app.FragmentId;
import com.pikamoney.app.R;

public class RecordFragment extends Fragment {

    private RadioGroup radioGroup;
    private ImageView  mResult;
    private Button     mVoiceButton;
    private ProgressBar progressBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_record, container, false);

        mResult = (ImageView) v.findViewById(R.id.imageView_record_result);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);

        mVoiceButton = (Button) v.findViewById(R.id.button_record_voice);
        mVoiceButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        progressBar.setVisibility(View.VISIBLE);
                        mVoiceButton.setVisibility(View.GONE);
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.GONE);
                                mResult.setImageResource(R.drawable.img_voice_result);
                                mResult.setVisibility(View.VISIBLE);
                            }
                        }, 2000);
                        break;
                }

                return false;
            }
        });

        radioGroup = (RadioGroup) v.findViewById(R.id.radioGroup_record);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton_record_photo:
                        mVoiceButton.setVisibility(View.GONE);
                        mResult.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        // create Intent to take a picture and return control to the calling application
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, 0);
                        break;
                    case R.id.radioButton_record_voice:
                        mVoiceButton.setVisibility(View.VISIBLE);
                        mResult.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        break;
                    default:
                        mVoiceButton.setVisibility(View.GONE);
                        mResult.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        break;
                }
            }
        });

        /* Create Camera and load image */

        /* Create Voice image */


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void notifyCameraFinish(){
        progressBar.setVisibility(View.VISIBLE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                mResult.setImageResource(R.drawable.img_photo_result);
                mResult.setVisibility(View.VISIBLE);
            }
        }, 2000);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("KerryTang", "1111111");
        if (resultCode == getActivity().RESULT_OK) {
            notifyCameraFinish();

        }
    }
}
