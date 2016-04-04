package com.gon.mvpdemo.client;

/**
 * Created by G on 4/2/16.
 */
public interface TransactionPdfClient {

    interface OnPdfDownloadedListener {

        void onPdfDownloaded();

        void onPdfDownloadError();
    }

    void download(String filename, OnPdfDownloadedListener listener);
}
