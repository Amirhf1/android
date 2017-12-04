package org.descartae.android.view.fragments.intro;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.descartae.android.R;
import org.descartae.android.interfaces.RequestPermissionView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroFragment extends Fragment {

    private static final String ARG_PAGE = "page";

    private int page;

    @BindView(R.id.intro_image)
    ImageView mImage;

    @BindView(R.id.intro_title)
    TextView mTitle;

    @BindView(R.id.intro_subtitle)
    TextView mSubTitle;

    @BindView(R.id.action_start)
    Button mStart;

    private RequestPermissionView mListener;

    public IntroFragment() {
    }

    public static IntroFragment newInstance(int page) {
        IntroFragment fragment = new IntroFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            page = getArguments().getInt(ARG_PAGE, 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro, container, false);

        ButterKnife.bind(this, view);

        switch (page) {
            case 1:

                mTitle.setText(R.string.onboard_title_1);
                mSubTitle.setText(R.string.onboard_subtitle_1);
                mStart.setVisibility(View.GONE);

                return view;
            case 2:

                mTitle.setText(R.string.onboard_title_2);
                mSubTitle.setText(R.string.onboard_subtitle_2);
                mStart.setVisibility(View.GONE);

                return view;
            case 3:

                mTitle.setText(R.string.onboard_title_3);
                mSubTitle.setText(R.string.onboard_subtitle_3);
                mStart.setVisibility(View.GONE);

                return view;
            case 4:

                mTitle.setText(R.string.onboard_title_4);
                mSubTitle.setText(R.string.onboard_subtitle_4);
                mStart.setVisibility(View.VISIBLE);

                return view;

            default: return view;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RequestPermissionView) {
            mListener = (RequestPermissionView) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement RequestPermissionView");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
