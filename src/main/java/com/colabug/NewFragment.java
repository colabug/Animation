package com.colabug;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NewFragment extends Fragment
{
    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState )
    {

        View layout = inflater.inflate( R.layout.new_view,
                                        container,
                                        false );

        return layout;
    }
}
