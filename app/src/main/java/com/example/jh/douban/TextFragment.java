package com.example.jh.douban;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by jh on 2016/8/17.
 */
public class TextFragment extends Fragment {

    private TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TextFragment","碎片已被创建完毕");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.textpager_layout,container,false);
        textView = (TextView) view.findViewById(R.id.text_c);
        textView.setText(""+getArguments().getInt("position_value"));
        Log.d("TextFragment","碎片视图已被创建完毕");
        return view;
    }
}
