package it.dex.dexpageradapter.adapter;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import it.dex.dexpageradapter.R;
import it.dex.dexpageradapterlib.DexPagerAdapter;

/**
 * Created by Diego on 29/11/2014.
 */
public class ItemDexPagerAdapter extends DexPagerAdapter implements TensManager{
    private int tens;

    @Override
    public View getView(int position, ViewPager viewPager) {
        View view = LayoutInflater.from(viewPager.getContext()).inflate(R.layout.fragment_item, null);
        TextView text = (TextView) view.findViewById(R.id.text_view);
        text.setText(tens * 10 + position + "");
        return view;
    }

    @Override
    public void updateAddedItems(View view, int position) {
        TextView text = (TextView) view.findViewById(R.id.text_view);
        text.setText(tens * 10 + position + "");
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

    @Override
    public int getCount() {
        return 10;
    }

    public void addTen() {
        tens++;
        notifyDataSetChanged();
    }

    public void removeTen() {
        tens--;
        notifyDataSetChanged();
    }
}
