package com.bwie.lifengzhuang20170717;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * 类描述：
 * 创建人：李冯壮
 * 创建时间：2017/7/17 9:02
 */
public class CustomView extends LinearLayout implements View.OnClickListener{

    private View mView;
    private Button add,minus;
    private EditText count;
    private int page = 0;

    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        mView = View.inflate(context, R.layout.customview,this);
        add = (Button) mView.findViewById(R.id.add);
        minus = (Button) mView.findViewById(R.id.minus);
        count = (EditText) mView.findViewById(R.id.count);
        if(count.getText().toString().trim()!=null){
            page = Integer.parseInt(count.getText().toString());
        }
        add.setOnClickListener(this);
        minus.setOnClickListener(this);
//        addView(mView);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add :
                page++;
                break;
            case R.id.minus :
                page--;
                break;
        }
    }
}
