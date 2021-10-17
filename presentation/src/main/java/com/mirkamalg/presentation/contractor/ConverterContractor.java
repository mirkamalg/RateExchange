package com.mirkamalg.presentation.contractor;

import com.mirkamalg.domain.model.ConversionHistoryItem;
import com.mirkamalg.presentation.common.IPresenter;
import com.mirkamalg.presentation.common.IView;

import java.util.List;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public interface ConverterContractor {

    interface View extends IView {

        void onCurrenciesFetched(List<String> result);

        void onShowResult(String result);

    }

    interface Presenter extends IPresenter {

        void fetchAllCurrencies();

        void fetchConversionResults(String from, double fromAmount, String to);

        void insertConversionResultsToDatabase(String from, String fromAmount, String to, String result);

    }

}
