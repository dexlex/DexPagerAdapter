package it.dex.dexpageradapter.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import it.dex.dexpageradapter.R;
import it.dex.dexpageradapter.adapter.ItemDexFragmentPagerAdapter;
import it.dex.dexpageradapter.adapter.ItemDexPagerAdapter;
import it.dex.dexpageradapter.adapter.TensManager;
import it.dex.dexpageradapter.data.Section;

/**
 * DexPagerAdapter created by Diego on 08/02/2015.
 */
public class ViewPagerFragment extends Fragment {
    private TensManager itemDexPagerAdapter;
    private Section.SECTIONS sections;

    public static ViewPagerFragment newInstance(Section.SECTIONS sections) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.sections = sections;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        switch (sections) {
            case FRAGMENT_STATE_PAGER_ADAPTER:
                itemDexPagerAdapter = new ItemDexFragmentPagerAdapter(getFragmentManager());
                break;
            case PAGER_ADAPTER:
                itemDexPagerAdapter = new ItemDexPagerAdapter();
                break;
        }
        viewPager.setAdapter((PagerAdapter) itemDexPagerAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            itemDexPagerAdapter.addTen();
            return true;
        } else if (id == R.id.action_remove) {
            itemDexPagerAdapter.removeTen();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
