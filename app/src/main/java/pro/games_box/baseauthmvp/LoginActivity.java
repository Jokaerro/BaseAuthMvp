package pro.games_box.baseauthmvp;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.games_box.baseauthmvp.mvp.presenter.AuthPresenter;
import pro.games_box.baseauthmvp.mvp.presenter.IAuthPresenter;
import pro.games_box.baseauthmvp.mvp.view.IAuthView;
import pro.games_box.baseauthmvp.ui.custom_views.AuthPanel;

public class LoginActivity extends AppCompatActivity implements IAuthView, View.OnClickListener {
    AuthPresenter mPresenter = AuthPresenter.getInstance();

    @BindView(R.id.coordinator_container)
    CoordinatorLayout mCoordinatorLayout;

    @BindView(R.id.login_card)
    CardView mLoginCard;

    @BindView(R.id.enter_btn)
    Button mLoginBtn;

    @BindView(R.id.show_games_btn)
    Button mShowGamesBtn;

    @BindView(R.id.login_wrap)
    AuthPanel mAuthPanel;

    // region ======================= life cycle ===========================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPresenter.takeView(this);
        mPresenter.initView();

        mLoginBtn.setOnClickListener(this);
        mShowGamesBtn.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.dropView();
        super.onDestroy();
    }

    //endregion

    // region ======================= IAuthRegion ==========================
    @Override
    public void showMessage(String message) {
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showError(Throwable e) {
        if (BuildConfig.DEBUG) {
            showMessage(e.getMessage());
            e.printStackTrace();
        } else {
            showMessage("Sorry, something wrong");
            //TODO send error to crashalitics
        }
    }

    @Override
    public void showLoad() {

    }

    @Override
    public void hideLoad() {

    }

    @Override
    public IAuthPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void showLoginBtn() {
        mLoginBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginBtn() {
        mLoginBtn.setVisibility(View.GONE);
    }

//    @Override
//    public void testShowLoginCard() {
//        mLoginCard.setVisibility(View.VISIBLE);
//    }

    @Override
    public AuthPanel getAuthPanel() {
        return mAuthPanel;
    }

    //endregion==


    @Override
    public void onBackPressed() {
        if (!mAuthPanel.isIdle()) {
            mAuthPanel.setCustomState(AuthPanel.IDLE_STATE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.show_games_btn:
                mPresenter.clickShowGames();
                break;
            case R.id.enter_btn:
                mPresenter.clickOnLogin();
                break;
        }
    }
}
