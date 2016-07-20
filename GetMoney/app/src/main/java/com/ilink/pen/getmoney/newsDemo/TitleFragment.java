package com.ilink.pen.getmoney.newsDemo;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ilink.pen.getmoney.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragment extends Fragment implements AdapterView.OnItemClickListener {

    private String[] newsTitle = {"title1", "title2", "title3"};
    private String[] newsDetail = {"detail1", "detail2", "detail3"};
   private ListView lvNewsTitle;
    private ArrayAdapter<String> adapter;
    public TitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_title, container, false);
        lvNewsTitle = (ListView) view.findViewById(R.id.lvNewsTitle);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,newsTitle);
        lvNewsTitle.setOnItemClickListener(this);
        lvNewsTitle.setAdapter(adapter);
        return view;



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tvDetail = (TextView) getActivity().findViewById(R.id.tvNewsDetail);
        if(tvDetail==null){
            //当前为手机
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("detail",newsDetail[position]);
            startActivity(intent);
        }else{
            //当前为平板
            tvDetail.setText(newsDetail[position]);
        }
    }
}
