package com.gon.mvpdemo.presenter;

import com.gon.mvpdemo.client.TransactionHistoryClient;
import com.gon.mvpdemo.client.TransactionHistoryClientImpl;
import com.gon.mvpdemo.client.TransactionPdfClient;
import com.gon.mvpdemo.client.TransactionPdfClientImpl;
import com.gon.mvpdemo.view.TransactionHistoryView;

import java.lang.ref.WeakReference;

/**
 * Created by G on 4/2/16.
 */
public class TransactionHistoryPresenterImpl implements TransactionHistoryPresenter<TransactionHistoryView>,
                                                        TransactionHistoryClient.Listener, TransactionPdfClient.OnPdfDownloadedListener {

    private WeakReference<TransactionHistoryView> mView;

    private TransactionPdfClient mPdfClient;
    private TransactionHistoryClient mTransactionClient;

    public TransactionHistoryPresenterImpl() {
        mPdfClient = new TransactionPdfClientImpl();
        mTransactionClient = new TransactionHistoryClientImpl();
    }

    @Override
    public void register(TransactionHistoryView view) {
        mView = new WeakReference<>(view);
    }

    @Override
    public void unregister() {
        mView.clear();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void downloadPdf() {
        mPdfClient.download("filename", this);
    }

    @Override
    public void getPaymentTransactions() {

    }

    @Override
    public void getBillTransactions() {

    }

    @Override
    public void onGetPaymentHistoryResponse() {

    }

    @Override
    public void onGetBillHistoryResponse() {

    }

    @Override
    public void onGetTransactionHistoryError() {

    }

    @Override
    public void onPdfDownloaded() {
        if (mView.get() != null) {
            mView.get().showPdf(null);
        }
    }

    @Override
    public void onPdfDownloadError() {

    }
}
