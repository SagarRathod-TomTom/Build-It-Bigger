package com.sagarrathod.builditbigger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.tell_joke_button) Button mTellJokeButton;
    @BindView(R.id.adView)  AdView mAdView;
    @BindString(R.string.interstitial_ad_unit_id) String mInterstitialAdUnitId;

    private InterstitialAd mInterstitialAd;
    private FragmentCallback mFragmentCallback;

    public MainActivityFragment() {
    }

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

        mInterstitialAd.setAdListener(new AdListener() {

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTellJokeButton.setOnClickListener(this);
    }

    public void setFragmentCallback(FragmentCallback mFragmentCallback) {
        this.mFragmentCallback = mFragmentCallback;
    }

    @Override
    public void onClick(View v) {

        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        } else {
            if(mFragmentCallback != null){
                mFragmentCallback.fragmentCallback();
            }
        }
    }

    private void loadInterstitialAdRequest(){
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(adRequest);
    }
}
