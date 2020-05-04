package com.example.airaccident.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.airaccident.Other.History.HistoryActivity;
import com.example.airaccident.Other.PicInfo.AirGrid.AirGridActivity;
import com.example.airaccident.Other.PicInfo.AirList.InfoListActivity;
import com.example.airaccident.Other.Information.InfoFiveActivity;
import com.example.airaccident.Other.Information.InfoFourActivity;
import com.example.airaccident.Other.Information.InfoOneActivity;
import com.example.airaccident.Other.Information.InfoThreeActivity;
import com.example.airaccident.Other.Information.InfoTwoActivity;
import com.example.airaccident.R;
import com.example.airaccident.Other.Weather.WeatherActivity;
import com.example.airaccident.Other.Writeagain.FocusTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    Button button1,button2,button3,button4;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    FocusTextView textView;

    public MainFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_main,container, false);
        button1=(Button) inflate.findViewById(R.id.fra_main_btn1);
        button2=(Button) inflate.findViewById(R.id.fra_main_btn2);
        button3=(Button) inflate.findViewById(R.id.fra_main_btn3);
        button4=(Button) inflate.findViewById(R.id.fra_main_btn4);
        imageView1=(ImageView)inflate.findViewById(R.id.imageView1);
        imageView2=(ImageView)inflate.findViewById(R.id.imageView2);
        imageView3=(ImageView)inflate.findViewById(R.id.imageView3);
        imageView4=(ImageView)inflate.findViewById(R.id.imageView4);
        textView=(FocusTextView)inflate.findViewById(R.id.focus_tv);
        button1.setOnClickListener(new mClick());
        button2.setOnClickListener(new mClick());
        button3.setOnClickListener(new mClick());
        button4.setOnClickListener(new mClick());
        imageView1.setOnClickListener(new mClick());
        imageView2.setOnClickListener(new mClick());
        imageView3.setOnClickListener(new mClick());
        imageView4.setOnClickListener(new mClick());
        textView.setOnClickListener(new mClick());
        return inflate;
    }
    private class mClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imageView1:
                    Intent intent1=new Intent(getActivity(), InfoOneActivity.class);
                    getActivity().startActivity(intent1);
                    break;
                case R.id.imageView2:
                    Intent intent2=new Intent(getActivity(), InfoTwoActivity.class);
                    getActivity().startActivity(intent2);
                    break;
                case R.id.imageView3:
                    Intent intent3=new Intent(getActivity(), InfoThreeActivity.class);
                    getActivity().startActivity(intent3);
                    break;
                case R.id.imageView4:
                    Intent intent4=new Intent(getActivity(), InfoFourActivity.class);
                    getActivity().startActivity(intent4);
                    break;
                case R.id.focus_tv:
                    Intent intent5=new Intent(getActivity(), InfoFiveActivity.class);
                    getActivity().startActivity(intent5);
                    break;
                case R.id.fra_main_btn1:
                    Intent intent6=new Intent(getActivity(), InfoListActivity.class);
                    getActivity().startActivity(intent6);
                    break;
                case R.id.fra_main_btn2:
                    Intent intent7=new Intent(getActivity(), AirGridActivity.class);
                    getActivity().startActivity(intent7);
                    break;
                case R.id.fra_main_btn3:
                    Intent intent8=new Intent(getActivity(), WeatherActivity.class);
                    getActivity().startActivity(intent8);
                    break;
                case R.id.fra_main_btn4:
                    Intent intent9=new Intent(getActivity(), HistoryActivity.class);
                    getActivity().startActivity(intent9);
                    break;
            }
        }
    }

}
