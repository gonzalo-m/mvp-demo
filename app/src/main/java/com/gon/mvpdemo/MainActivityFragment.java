package com.gon.mvpdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gon.mvpdemo.presenter.TransactionHistoryPresenter;
import com.gon.mvpdemo.presenter.TransactionHistoryPresenterImpl;
import com.gon.mvpdemo.view.TransactionHistoryView;

import java.io.File;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements TransactionHistoryView {

    private TransactionHistoryPresenter mPresenter;

    private TextView mText;

    public MainActivityFragment() {
        mPresenter = new TransactionHistoryPresenterImpl();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.onCreate();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mText = (TextView) root.findViewById(R.id.status_text);
        Button downloadPdfButton = (Button) root.findViewById(R.id.download_pdf_button);
        downloadPdfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.downloadPdf();
            }
        });
        Button getPaymentsButton = (Button) root.findViewById(R.id.get_payments_button);
        getPaymentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getPaymentTransactions();
            }
        });
        Button getBillsButton = (Button) root.findViewById(R.id.get_bills_button);
        getBillsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getBillTransactions();
            }
        });

        return root;
    }

    @Override
    public void showPdf(File pdf) {
        mText.setText("PDF");
    }

    @Override
    public void showPdfError(String errMsg) {

    }

    @Override
    public void showPaymentHistory(List<String> payments) {
        mText.setText(payments.toString());
    }

    @Override
    public void showBillHistory(List<String> bills) {
        mText.setText(bills.toString());
    }

    @Override
    public void showTransactionHistoryError(String errMsg) {

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unregister();
    }
}
