package com.android.mercariinterview.home.mvp;

import com.android.mercariinterview.base.BaseView;

/**
 * Created by AbhishekKejriwal on 7/11/2017.
 */

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private HomeInteractor homeInteractor;

    public HomePresenter(HomeInteractor homeInteractor) {
        this.homeInteractor = homeInteractor;
    }

    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void setRecyclerViewData() {
        view.showRecyclerViewData(homeInteractor.getItemList());
    }
}
