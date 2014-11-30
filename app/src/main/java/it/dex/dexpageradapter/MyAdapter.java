package it.dex.dexpageradapter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import it.dex.dexpageradapterlib.DexFragmentPagerAdapter;

/**
 * Created by Diego on 29/11/2014.
 */
public class MyAdapter extends DexFragmentPagerAdapter {
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getFragment(int position) {
        return MyFragment.newInstance(position);
    }

    @Override
    public void updateAddedItems(Fragment fragment, int position) {
        MyFragment myFragment = (MyFragment) fragment;
        myFragment.setBackgroundColor(Color.RED);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "" + position;
    }

    public static class MyFragment extends Fragment {
        public static final String PAGE_ARG = "pageArg";
        private TextView textView;

        public static MyFragment newInstance(int page) {
            Bundle bundle = new Bundle();
            bundle.putInt(PAGE_ARG, page);
            MyFragment fragment = new MyFragment();
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_my, null);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            textView = (TextView) view.findViewById(R.id.text_view);
            textView.setText("" + getArguments().getInt(PAGE_ARG));
        }

        public void setBackgroundColor(int color) {
            textView.setBackgroundColor(color);
        }
    }
}
