package org.feng.mvpdemo.main;

import org.feng.mvpdemo.BasePresenter;
import org.feng.mvpdemo.BaseView;

import java.util.List;

/**
 * Created by feng on 2017/9/26.
 */

public interface MainContract {
    interface View extends BaseView<Presenter> {
        void showProgress();

        void hideProgress();

        void setItems(List<String> items);

        void showMessage(String message);

    }

    interface Presenter extends BasePresenter {
        void onItemClicked(int position);

        void onDestroy();
    }

    interface Model {
        interface OnFinishedListener {
            void onFinished(List<String> items);
        }

        void findItems(OnFinishedListener listener);
    }
}
