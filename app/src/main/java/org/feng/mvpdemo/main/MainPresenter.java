package org.feng.mvpdemo.main;

import java.util.List;

/**
 * Created by feng on 2017/9/26.
 */

public class MainPresenter implements MainContract.Presenter, MainContract.Model.OnFinishedListener {
    private MainContract.View view;
    private MainInteractor mainInteractor;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        view.setPresenter(this);
        mainInteractor = new MainInteractor();
    }


    @Override
    public void onItemClicked(int position) {
        if (view != null) {
            view.showMessage(String.format("Position %d clicked", position + 1));
        }

    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void start() {
        if (view != null) {
            view.showProgress();
        }
        mainInteractor.findItems(this);

    }

    @Override
    public void onFinished(List<String> items) {
        if (view != null) {
            view.setItems(items);
            view.hideProgress();
        }
    }
}
