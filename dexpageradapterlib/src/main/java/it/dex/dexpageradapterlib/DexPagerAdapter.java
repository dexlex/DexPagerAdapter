package it.dex.dexpageradapterlib;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Diego on 29/11/2014.
 */
public abstract class DexPagerAdapter extends PagerAdapter implements  DexPageGrabber{
    private SparseArray<View> viewSparseArray = new SparseArray<View>();

    public abstract View getView(int position, ViewPager viewPager);

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewPager pager = (ViewPager) container;
        View view = getView(position, pager);
        pager.addView(view);
        getViewSparseArray().put(position, view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
        getViewSparseArray().remove(position);
    }

    public void updateAddedItems() {
        for (int i = 0; i < getViewSparseArray().size(); i++) {
            int key = getViewSparseArray().keyAt(i);
            updateAddedItems(getViewSparseArray().get(key), key);
        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateAddedItems();
    }

    public SparseArray<View> getViewSparseArray() {
        return viewSparseArray;
    }

    public void setViewSparseArray(SparseArray<View> viewSparseArray) {
        this.viewSparseArray = viewSparseArray;
    }
}