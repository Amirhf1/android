package org.descartae.android.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import org.descartae.android.FacilityQuery;
import org.descartae.android.R;
import org.descartae.android.view.facility.FacilityFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements FacilityFragment.OnListFacilitiesListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.content, FacilityFragment.newInstance()).commit();
    }

    @Override
    public void onListFacilityInteraction(FacilityQuery.Center center) {

    }
}
