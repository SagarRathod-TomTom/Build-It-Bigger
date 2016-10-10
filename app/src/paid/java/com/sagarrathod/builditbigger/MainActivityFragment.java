package com.sagarrathod.builditbigger;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author Sagar Rathod
 * @version 1.0
 *
 * Fragment for paid version.
 *
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener{

    private FragmentCallback mFragmentCallback;
    @BindView(R.id.tell_joke_button) Button mTellJokeButton;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    public MainActivityFragment() {
        // Required empty public constructor
    }

    /**
     * Inflates fragment layout and bind the views.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    /**
     * Registers the tell joke button click listener.
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTellJokeButton.setOnClickListener(this);
    }

    /**
     * Setter method for mFragmentCallback.
     *
     * @param mFragmentCallback
     */
    public void setFragmentCallback(FragmentCallback mFragmentCallback) {
        this.mFragmentCallback = mFragmentCallback;
    }

    /**
     * On click event handler for tell joke button.
     * @param view
     */
    @Override
    public void onClick(View v) {
        if(mFragmentCallback != null){
            mFragmentCallback.fragmentCallback();
        }
    }
}
