package com.example.ejemplologin.Fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ejemplologin.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SlideShowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SlideShowFragment extends Fragment {

    View view;
    Context context;

    Button btnAxisX;
    Button btnAxisY;
    Button btnAlpha;
    Button btnRotation;
    Button btnAll;
    Button btnLoop;
    Button btnScale;

    ImageView ivAxisX;
    ImageView ivAxisY;
    ImageView ivAlpha;
    ImageView ivRotation;
    ImageView ivAll;
    ImageView ivLoop;
    ImageView ivScale;

    ObjectAnimator oaAxisX;
    ObjectAnimator oaAxisY;
    ObjectAnimator oaAlpha;
    ObjectAnimator oaRotation;
    ObjectAnimator oaAll;
    ObjectAnimator oaLoop;
    ObjectAnimator oaScaleX;
    ObjectAnimator oaScaleY;

    public SlideShowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SlideShowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SlideShowFragment newInstance(String param1, String param2) {
        SlideShowFragment fragment = new SlideShowFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_slide_show, container, false);
        context = view.getContext();

        lounchWidgwets();
        lounchAnimations();
        lounchEvents();


        return view;
    }

    public void lounchWidgwets() {

        btnAxisX = view.findViewById(R.id.btn_anim_x);
        btnAxisY = view.findViewById(R.id.btn_anim_y);
        btnAlpha = view.findViewById(R.id.btn_anim_a);
        btnRotation = view.findViewById(R.id.btn_anim_r);
        btnAll = view.findViewById(R.id.btn_anim_all);
        btnLoop = view.findViewById(R.id.btn_anim_c);
        btnScale = view.findViewById(R.id.btn_anim_s);

        ivAxisX = view.findViewById(R.id.iv_anim_x);
        ivAxisY = view.findViewById(R.id.iv_anim_y);
        ivAlpha = view.findViewById(R.id.iv_anim_a);
        ivRotation = view.findViewById(R.id.iv_anim_r);
        ivAll = view.findViewById(R.id.iv_anim_all);
        ivLoop = view.findViewById(R.id.iv_anim_c);
        ivScale = view.findViewById(R.id.iv_anim_s);
    }

    public void lounchAnimations() {

    }

    public void lounchEvents() {
        btnAxisX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Animation animX = AnimationUtils.loadAnimation(context, R.anim.translate_x);
                //ivAxisX.startAnimation(animX);
                oaAxisX = ObjectAnimator.ofFloat(ivAxisX, "x", 500);
                oaAxisX.setDuration(5000);
                AnimatorSet animatorSetX = new AnimatorSet();
                animatorSetX.playTogether(oaAxisX);
                animatorSetX.start();


            }
        });

        btnAxisY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Animation animY = AnimationUtils.loadAnimation(context, R.anim.translate_y);
                //ivAxisY.startAnimation(animY);

                oaAxisY = ObjectAnimator.ofFloat(ivAxisY, "y", 420f);
                oaAxisY.setDuration(5000);
                AnimatorSet animatorSetY = new AnimatorSet();
                animatorSetY.playTogether(oaAxisY);
                animatorSetY.start();

            }
        });

        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Animation animAlpha = AnimationUtils.loadAnimation(context, R.anim.alpha);
                //ivAlpha.startAnimation(animAlpha);

                oaAlpha =ObjectAnimator.ofFloat(ivAlpha, View.ALPHA, 1.0f, 0.0f);
                oaAlpha.setDuration(5000);
                AnimatorSet animatorSetAlpha = new AnimatorSet();
                animatorSetAlpha.playTogether(oaAlpha);
                animatorSetAlpha.start();

            }
        });

        btnRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Animation animRotation = AnimationUtils.loadAnimation(context, R.anim.rotation);
                //ivRotation.startAnimation(animRotation);

                oaRotation = ObjectAnimator.ofFloat(ivRotation, "rotation", 0f, 360f);
                oaRotation.setDuration(5000);
                AnimatorSet animatorSetRotation = new AnimatorSet();
                animatorSetRotation.playTogether(oaRotation);
                animatorSetRotation.start();

            }
        });

        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animScale = AnimationUtils.loadAnimation(context, R.anim.scale);
                ivScale.startAnimation(animScale);

                oaScaleX = ObjectAnimator.ofFloat(ivScale, "scaleX", 0.5f);
                oaScaleY = ObjectAnimator.ofFloat(ivScale, "scaleY", 0.5f);
                oaScaleX.setDuration(5000);
                oaScaleY.setDuration(5000);
                AnimatorSet animatorSetScale = new AnimatorSet();
                animatorSetScale.play(oaScaleX).with(oaAxisY);
                animatorSetScale.start();

            }
        });

        btnLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Animation animLoop = AnimationUtils.loadAnimation(context, R.anim.loop);
                //ivLoop.startAnimation(animLoop);

                oaLoop = ObjectAnimator.ofFloat(ivLoop, "x", 500);
                oaLoop.setRepeatCount(ObjectAnimator.INFINITE);
                oaLoop.setDuration(5000);
                AnimatorSet animatorSetLoop = new AnimatorSet();
                animatorSetLoop.playTogether(oaLoop);
                animatorSetLoop.start();

            }
        });
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Animation animAll = AnimationUtils.loadAnimation(context, R.anim.all);
                //ivAll.startAnimation(animAll);
                oaAxisX = ObjectAnimator.ofFloat(ivAll, "x", 500);
                oaAxisY = ObjectAnimator.ofFloat(ivAll, "y", 420f);
                oaAlpha =ObjectAnimator.ofFloat(ivAll, View.ALPHA, 1.0f, 0.0f);

                oaAlpha.setDuration(5000);
                oaAxisY.setDuration(5000);
                oaAxisX.setDuration(5000);

                AnimatorSet animatorSetAll = new AnimatorSet();
                animatorSetAll.playTogether(oaAxisY, oaAxisY, oaAlpha);
                animatorSetAll.start();
            }
        });
    }


}