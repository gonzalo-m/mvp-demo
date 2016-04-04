package com.gon.mvpdemo.presenter;

/**
 * Created by G on 4/2/16.
 */
public interface TransactionHistoryPresenter<E> {

    void register(E view);

    void unregister();

    void onCreate();

    void onPause();

    void onResume();

    void onDestroy();

    void downloadPdf();

    void getPaymentTransactions();

    void getBillTransactions();
}
