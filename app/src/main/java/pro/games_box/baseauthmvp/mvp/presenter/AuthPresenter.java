package pro.games_box.baseauthmvp.mvp.presenter;

import android.support.annotation.Nullable;

import pro.games_box.baseauthmvp.mvp.model.AuthModel;
import pro.games_box.baseauthmvp.mvp.view.IAuthView;
import pro.games_box.baseauthmvp.ui.custom_views.AuthPanel;

/**
 * Created by Tesla on 22.06.2017.
 */

public class AuthPresenter implements IAuthPresenter {

    private static AuthPresenter instance = new AuthPresenter();
    private AuthModel mAuthModel;
    private IAuthView mAuthView;

    private AuthPresenter() {
        mAuthModel = new AuthModel();
    }

    public static AuthPresenter getInstance() {
        return instance;
    }

    @Override
    public void takeView(IAuthView authView) {
        mAuthView = authView;
    }

    @Override
    public void dropView() {
        mAuthView = null;
    }

    @Override
    public void initView() {
        if(getView() != null) {
            if (checkUserAuth()) {
                getView().hideLoginBtn();
            } else {
                getView().showLoginBtn();
            }
        }
    }

    @Nullable
    @Override
    public IAuthView getView() {
        return mAuthView;
    }

    @Override
    public void clickOnLogin() {
        //TODO show and hide login panel
        if(getView() != null && getView().getAuthPanel() != null) {
            if(getView().getAuthPanel().isIdle()) {
                getView().getAuthPanel().setCustomState(AuthPanel.LOGIN_STATE);
            } else {
                mAuthModel.loginUser(getView().getAuthPanel().getUserEmail(),
                        getView().getAuthPanel().getUserPswrd());
            }
        }
    }

    @Override
    public void clickOnFb() {
        if(getView() != null)
            getView().showMessage("Login fb");
    }

    @Override
    public void clickOnVk() {
        if(getView() != null)
            getView().showMessage("Login vk");
    }

    @Override
    public void clickOnTwitter() {
        if(getView() != null)
            getView().showMessage("Login twitter");
    }

    @Override
    public void clickShowGames() {
        if(getView() != null)
            getView().showMessage("Show Games");
    }

    @Override
    public boolean checkUserAuth() {
        return mAuthModel.isAuthUser();
    }
}
