package com.example.airaccident.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.airaccident.R;
import com.example.airaccident.Search.sactivity.MultipleActivity;
import com.example.airaccident.Search.sactivity.NewsReasonActivity;
import com.example.airaccident.Search.sactivity.SingleActivity;
import com.example.airaccident.Search.sactivity.TypeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    Button dan,duo,leixing,yuanyin;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_search, container, false);
        dan=view.findViewById(R.id.dantiaojian);
        duo=view.findViewById(R.id.duotiaojian);
        leixing=view.findViewById(R.id.shijianleixing);
        yuanyin=view.findViewById(R.id.shijianyuanyin);
        dan.setOnClickListener(new mClick());
        duo.setOnClickListener(new mClick());
        leixing.setOnClickListener(new mClick());
        yuanyin.setOnClickListener(new mClick());
        return view;
    }
    private class mClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.dantiaojian:
                    Intent intent1=new Intent(getActivity(), SingleActivity.class);
                    getActivity().startActivity(intent1);
                    break;
                case R.id.duotiaojian:
                    Intent intent2=new Intent(getActivity(), MultipleActivity.class);
                    getActivity().startActivity(intent2);
                    break;
                case R.id.shijianleixing:
                    Intent intent3=new Intent(getActivity(), TypeActivity.class);
                    getActivity().startActivity(intent3);
                    break;
                case R.id.shijianyuanyin:
                    Intent intent4=new Intent(getActivity(), NewsReasonActivity.class);
                    getActivity().startActivity(intent4);
                    break;
            }
        }
    }
}
