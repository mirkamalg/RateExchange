package com.mirkamalg.presentation.common;

/**
 * Created by Mirkamal Gasimov on 17.10.2021.
 */

public interface IView {

    void showError(Throwable throwable);

    void showLoading(boolean isLoading);

}
