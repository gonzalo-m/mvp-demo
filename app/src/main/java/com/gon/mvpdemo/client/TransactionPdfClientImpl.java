package com.gon.mvpdemo.client;

import android.os.Handler;

import com.gon.mvpdemo.RequestProcessor;

/**
 * Created by G on 4/2/16.
 */
public class TransactionPdfClientImpl implements TransactionPdfClient {



    @Override
    public void download(String file, final OnPdfDownloadedListener listener) {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                listener.onPdfDownloaded();
//            }
//        }, 2000);
        new RequestProcessor() {
            @Override
            public void onUpdateResponse(String update) {
                listener.onPdfDownloaded();
            }
        };
    }
}
