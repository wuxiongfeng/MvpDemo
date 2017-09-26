package org.feng.mvpdemo.login;

import org.feng.mvpdemo.BasePresenter;
import org.feng.mvpdemo.BaseView;

/**
 * Created by feng on 2017/9/26.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void showProgress();

        void hideProgress();

        void setUsernameError();

        void setPasswordError();

        void navigateToHome();
    }

    interface Presenter extends BasePresenter {
        void validateCredentials(String username, String password);

        void onDestroy();
    }

    interface Model {
        interface OnLoginFinishedListener {
            void onUsernameError();

            void onPasswordError();

            void onSuccess();
        }

        void login(String username, String password, OnLoginFinishedListener listener);
    }
}
