package ua.org.shutl.buoyviewer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.org.shutl.buoyviewer.R;
import ua.org.shutl.buoyviewer.fragment.sub.LocationItemSubFragmentCreator;
import ua.org.shutl.buoyviewer.model.LocationItem;

/**
 * Created by shutl on 19.01.16.
 */
public class LocationItemFragment extends NamedFragment{

    public static String TAG = LocationItemFragment.class.getSimpleName();

    public static Fragment newInstance(LocationItem locationItem) {
        Fragment fragment = new LocationItemFragment();
        Bundle args = new Bundle();
        args.putSerializable("locationItem", locationItem);
        fragment.setArguments(args);
        return fragment;
    }

    LocationItem locationItem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        locationItem = (LocationItem) getArguments().getSerializable("locationItem");
        setName(locationItem.getName());
        View rootView = inflater.inflate(R.layout.layout_location_info, container, false);
        LocationItemSubFragmentCreator.getInstance(getChildFragmentManager()).attach(locationItem);
        return rootView;
    }

}
