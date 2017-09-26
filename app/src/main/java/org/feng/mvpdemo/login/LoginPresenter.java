package org.feng.mvpdemo.login;

/**
 * Created by feng on 2017/9/26.
 */

public class LoginPresenter implements LoginContract.Presenter, LoginContract.Model.OnLoginFinishedListener {
    private LoginContract.View view;
    private LoginContract.Model model;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (view != null) {
            view.showProgress();
        }

        model.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void start() {
        model = new LoginInteractor();
    }

    @Override
    public void onUsernameError() {
        if (view != null) {
            view.setUsernameError();
            view.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (view != null) {
            view.setPasswordError();
            view.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (view != null) {
            view.hideProgress();
            view.navigateToHome();
        }
    }
}
