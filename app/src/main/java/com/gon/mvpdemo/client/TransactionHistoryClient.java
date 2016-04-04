package com.gon.mvpdemo.client;

/**
 * Created by G on 4/2/16.
 */
public interface TransactionHistoryClient {

    interface Listener {

        void onGetPaymentHistoryResponse();

        void onGetBillHistoryResponse();

        void onGetTransactionHistoryError();
    }

    void doGetPaymentHistoryRequest();

    void doGetBillHistoryRequest();
}
