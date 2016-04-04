package com.gon.mvpdemo;

import android.content.pm.ActivityInfo;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by G on 4/2/16.
 */
public class MainActivityFragmentTests extends ActivityInstrumentationTestCase2<MainActivity> {


    private MainActivity mActivity;
    private MainActivityFragment mFragment;

    private TextView mStatusText;
    private Button mDownloadButton;

    public MainActivityFragmentTests() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        mFragment = (MainActivityFragment) mActivity.getFragmentManager()
                .findFragmentById(R.id.fragment);
    }

    /**
     * Prepares references to the buttons "DownloadPdf".
     */
    private void setUpButtons() {
        View view = mFragment.getView();
        assertNotNull(view);
        mDownloadButton = (Button) view.findViewById(R.id.download_pdf_button);
        assertNotNull(mDownloadButton);
        mStatusText = (TextView) view.findViewById(R.id.status_text);
        assertNotNull(mStatusText);
    }

    @LargeTest
    public void testStatusText() throws InterruptedException {
        setUpButtons();
        // The status  should be "Hello World!" at first
        String expectedStatusText = "PDF";
        TouchUtils.clickView(this, mDownloadButton);
        Thread.sleep(2500);
        assertEquals(expectedStatusText, mStatusText.getText());
    }

    @LargeTest
    public void testOrientationChangePreserveState() throws InterruptedException {
        mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setUpButtons();
        assertEquals("Hello world!", mStatusText.getText());
        Thread.sleep(2000);
        mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Thread.sleep(2000);
        // Check that the title is the same after orientation change
        assertEquals("Hello world!", mStatusText.getText());
    }
}
