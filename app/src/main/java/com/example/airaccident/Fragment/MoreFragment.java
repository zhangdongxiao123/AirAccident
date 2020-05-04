package com.example.airaccident.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.airaccident.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment  {
    View view;
    private SliderLayout mSliderLayout;
    private PagerIndicator indicator;
    LinearLayout pointLayout;
    TextView shareTv;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_more, container, false);
        mSliderLayout = (SliderLayout) view.findViewById(R.id.slider);
        indicator=(PagerIndicator) view.findViewById(R.id.custom_indicator);
        pointLayout=(LinearLayout) view.findViewById(R.id.about_layout_point);
        shareTv=(TextView) view.findViewById(R.id.about_tv_share);
        shareTv.setOnClickListener(new fclick());
        initSlider();

        return view;


    }
    private void  initSlider(){
        TextSliderView textSliderView1 = new TextSliderView(this.getActivity());
        textSliderView1.description("APP图标");
        textSliderView1.image(R.mipmap.ab1);
        TextSliderView textSliderView2 = new TextSliderView(this.getActivity());
        textSliderView2.description("航空安全事故1");
        textSliderView2.image(R.mipmap.ab2);
        TextSliderView textSliderView3 = new TextSliderView(this.getActivity());
        textSliderView3.description("航空安全事故2");
        textSliderView3.image(R.mipmap.ab3);
        TextSliderView textSliderView4 = new TextSliderView(this.getActivity());
        textSliderView4.description("航空安全事故3");
        textSliderView4.image(R.mipmap.ab4);
        TextSliderView textSliderView5 = new TextSliderView(this.getActivity());
        textSliderView5.description("航空安全事故4");
        textSliderView5.image(R.mipmap.ab5);

        mSliderLayout.addSlider(textSliderView1);
        mSliderLayout.addSlider(textSliderView2);
        mSliderLayout.addSlider(textSliderView3);
        mSliderLayout.addSlider(textSliderView4);
        mSliderLayout.addSlider(textSliderView5);

        //mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSliderLayout.setCustomIndicator(indicator);
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        mSliderLayout.setDuration(2000);


    }

    private class fclick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //调用系统自带的分享功能，这几行代码是写死的
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String msg = "航空安全事故查询APP，了解一下吧";
            intent.putExtra(Intent.EXTRA_TEXT,msg);
            startActivity(Intent.createChooser(intent,"航空安全事故查询"));
        }
    }
}












