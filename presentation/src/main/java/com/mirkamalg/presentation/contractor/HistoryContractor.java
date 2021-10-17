package com.mirkamalg.presentation.contractor;

import com.mirkamalg.domain.model.ConversionHistoryItem;
import com.mirkamalg.domain.model.ConversionResult;
import com.mirkamalg.presentation.common.IPresenter;
import com.mirkamalg.presentation.common.IView;

import java.util.List;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public interface HistoryContractor {

    interface View extends IView {

        void onShowSavedResults(List<ConversionHistoryItem> results);

    }

    interface Presenter extends IPresenter {

        void fetchSavedResults();

    }

}
