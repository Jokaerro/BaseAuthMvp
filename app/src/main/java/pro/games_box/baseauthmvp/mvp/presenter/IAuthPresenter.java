package pro.games_box.baseauthmvp.mvp.presenter;

import android.support.annotation.Nullable;

import pro.games_box.baseauthmvp.mvp.view.IAuthView;

/**
 * Created by Tesla on 22.06.2017.
 */

public interface IAuthPresenter {

    void takeView(IAuthView authView);
    void dropView();
    void initView();

    @Nullable
    IAuthView getView();

    void clickOnLogin();
    void clickOnFb();
    void clickOnVk();
    void clickOnTwitter();
    void clickShowGames();

    boolean checkUserAuth();
}
