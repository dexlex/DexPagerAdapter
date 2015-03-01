package it.dex.dexpageradapter.adapter;

import android.support.v4.app.FragmentManager;

import it.dex.dexpageradapter.fragments.ItemFragment;
import it.dex.dexpageradapterlib.DexFragmentStatePagerAdapter;

/**
 * Created by Diego on 29/11/2014.
 */
public class ItemDexFragmentPagerAdapter extends DexFragmentStatePagerAdapter<ItemFragment> implements TensManager{
    private int tens;

    public ItemDexFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public ItemFragment getFragment(int position) {
        return ItemFragment.newInstance(position, tens);
    }

    @Override
    public void updateAddedItems(ItemFragment itemFragment, int position) {
        itemFragment.setTens(tens);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
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
