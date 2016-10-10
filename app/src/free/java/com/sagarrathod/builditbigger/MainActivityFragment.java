package com.sagarrathod.builditbigger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author Sagar Rathod
 * @version 1.0
 *
 * Displays the Admob ads on free version.
 *
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.tell_joke_button) Button mTellJokeButton;
    @BindView(R.id.adView)  AdView mAdView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindString(R.string.interstitial_ad_unit_id) String mInterstitialAdUnitId;

    private InterstitialAd mInterstitialAd;
    private FragmentCallback mFragmentCallback;

    public MainActivityFragment() {
    }

    /**
     * Inflates the layout and creates the instance of Admob
     * interstitial ad and banner ads.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(mInterstitialAdUnitId);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        loadInterstitialAdRequest();

        // interstitial ad event handler
        mInterstitialAd.setAdListener(new AdListener() {

            /**
             * Calls the parent activity callback method.
             * and initializes the new interstitial ad request.
             */
            @Override
            public void onAdClosed() {
                super.onAdClosed();

                if(mFragmentCallback != null){
                    mFragmentCallback.fragmentCallback();
                }
                loadInterstitialAdRequest();
            }
        });
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
     * Shows the interstitial ad if it is loaded otherwise
     * delegates the control to parent activity.
     *
     * @param view
     */
    @Override
    public void onClick(View view) {

        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        } else {
            if(mFragmentCallback != null){
                mFragmentCallback.fragmentCallback();
            }
        }
    }

    /**
     * Constructs new interstitial ad request.
     */
    private void loadInterstitialAdRequest(){
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(adRequest);
    }
}
