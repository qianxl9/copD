package com.example.jh.douban;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jh on 2016/8/16.
 */
public class ListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mRefre;
    private ListView mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listpager_layout,container,false);
        mRefre = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        mList = (ListView) view.findViewById(R.id.m_list);
        mRefre.setOnRefreshListener(this);
        mRefre.setColorSchemeResources(
                android.R.color.holo_blue_dark,
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_dark,
                android.R.color.holo_purple
        );
        mList.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getList()));

        return view;
    }

    private List<String> getList() {
        List<String> list = new ArrayList<String>();

        for (int i = 0 ; i<13 ; i++){
            list.add(new String(""+i));
        }
        return list;
    }

    @Override
    public void onRefresh() {
        mRefre.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefre.setRefreshing(false);
            }
        },3000);
    }
}
