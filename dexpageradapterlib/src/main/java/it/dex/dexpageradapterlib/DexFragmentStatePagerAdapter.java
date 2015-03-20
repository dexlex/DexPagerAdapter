package it.dex.dexpageradapterlib;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

/**
 * Created by Diego on 29/11/2014.
 */
public abstract class DexFragmentStatePagerAdapter<T extends Fragment> extends FragmentStatePagerAdapter implements DexFragmentGrabber<T> {
    private SparseArray<T> fragmentSparseArray = new SparseArray<>();

    public DexFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public abstract T getFragment(int position);

    @Override
    public T getItem(int position) {
        T fragment = getFragment(position);
        getFragmentSparseArray().put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        getFragmentSparseArray().remove(position);
        super.destroyItem(container, position, object);
    }

    public void updateAddedItems() {
        for (int i = 0; i < getFragmentSparseArray().size(); i++) {
            int key = getFragmentSparseArray().keyAt(i);
            updateAddedItems(getFragmentSparseArray().get(key), i);
        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateAddedItems();
    }

    public SparseArray<T> getFragmentSparseArray() {
        return fragmentSparseArray;
    }

    public void setFragmentSparseArray(SparseArray<T> fragmentSparseArray) {
        this.fragmentSparseArray = fragmentSparseArray;
    }
}
