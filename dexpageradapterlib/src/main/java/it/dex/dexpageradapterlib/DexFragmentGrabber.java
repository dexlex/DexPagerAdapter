package it.dex.dexpageradapterlib;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Diego on 29/11/2014.
 */
public interface DexFragmentGrabber<T extends Fragment> {
    public void updateAddedItems(T fragment, int position);
}
