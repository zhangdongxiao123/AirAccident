package com.example.airaccident.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.airaccident.My.LoginActivity;
import com.example.airaccident.R;
import com.example.airaccident.Search.sactivity.ManLoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {
    View view;
    TextView mine_text;
    Button mine_button,mine_manager;

    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_mine, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化
        mine_text=(TextView)view.findViewById(R.id.mine_text);
        mine_button=(Button)view.findViewById(R.id.mine_button);
        mine_manager=(Button)view.findViewById(R.id.mine_manager);
        //设置登录按钮监听事件
        mine_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ManLoginActivity.class);
                getActivity().startActivity(intent);
            }
        });
        mine_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=mine_button.getText().toString().trim();
                if(string.equals("退出登录")){
                    mine_text.setText("您好，请登录");
                    mine_button.setText("登录");
                }else {
                    startActivityForResult(new Intent(getActivity(), LoginActivity.class), 1);
                }
            }
        });
    }
    /**
     * 此方法用来跳转的activity要传回的数据，以及接受到传回数据的要做的业务
     * 这里因为只有一个activity返回数据，所以这里就只有一个resultCode，就直接接收返回值处理
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
            Bundle bundle = data.getExtras();
            String namString = bundle.getString("name");
            mine_text.setText("恭喜您，"+namString+",登录成功!");
            mine_button.setText("退出登录");
        }

    }
}
