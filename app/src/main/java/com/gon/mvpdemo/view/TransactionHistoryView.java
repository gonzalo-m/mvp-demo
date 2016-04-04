package com.gon.mvpdemo.view;

import java.io.File;
import java.util.List;

/**
 * Created by G on 4/2/16.
 */
public interface TransactionHistoryView {

    void showPdf(File pdf);

    void showPdfError(String errMsg);

    void showPaymentHistory(List<String> payments);

    void showBillHistory(List<String> bills);

    void showTransactionHistoryError(String errMsg);

}
