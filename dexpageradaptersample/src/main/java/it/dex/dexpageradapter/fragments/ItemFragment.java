package it.dex.dexpageradapter.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import it.dex.dexpageradapter.R;

/**
 * DexPagerAdapter created by Diego on 08/02/2015.
 */
public class ItemFragment extends Fragment {
    public static final String PAGE_ARG = "pageArg";
    public static final String TENS_ARG = "tensArg";
    private TextView textView;
    private int tens;
    private int page;

    public static ItemFragment newInstance(int page, int tens) {
        Bundle bundle = new Bundle();
        bundle.putInt(PAGE_ARG, page);
        bundle.putInt(TENS_ARG, tens);
        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.text_view);
        page = getArguments().getInt(PAGE_ARG);
        tens = getArguments().getInt(TENS_ARG);
        setText(tens);
    }

    public void setTens(int tens) {
        this.tens = tens;
        setText(tens);
    }

    public void setText(int tens) {
        textView.setText(tens * 10 + page + "");
    }
}
