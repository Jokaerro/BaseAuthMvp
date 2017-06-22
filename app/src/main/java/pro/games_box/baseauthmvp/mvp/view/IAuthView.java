package pro.games_box.baseauthmvp.mvp.view;

import android.support.annotation.Nullable;

import pro.games_box.baseauthmvp.mvp.presenter.IAuthPresenter;
import pro.games_box.baseauthmvp.ui.custom_views.AuthPanel;

/**
 * Created by Tesla on 22.06.2017.
 */

public interface IAuthView {

    void showMessage(String message);
    void showError(Throwable e);

    void showLoad();
    void hideLoad();

    IAuthPresenter getPresenter();

    void showLoginBtn();
    void hideLoginBtn();
//    void testShowLoginCard();

    @Nullable
    AuthPanel getAuthPanel();
}
