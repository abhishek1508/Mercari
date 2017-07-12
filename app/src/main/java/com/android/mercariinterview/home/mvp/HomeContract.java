package com.android.mercariinterview.home.mvp;

import com.android.mercariinterview.base.BasePresenter;
import com.android.mercariinterview.base.BaseView;
import com.android.mercariinterview.data.Item;

import java.util.List;

/**
 * Created by AbhishekKejriwal on 7/11/2017.
 */

public interface HomeContract {

    interface View extends BaseView {
        void showRecyclerViewData(List<Item> itemList);
    }

    interface Presenter extends BasePresenter<View> {
        void setRecyclerViewData();
    }
}
