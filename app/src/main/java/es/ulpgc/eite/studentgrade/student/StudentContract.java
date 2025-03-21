package es.ulpgc.eite.studentgrade.student;

import java.lang.ref.WeakReference;

/**
 * Created by Luis on marzo, 2022
 */
public interface StudentContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(StudentViewModel viewModel);

    void navigateToNextScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void onResumeCalled();

    void onCreateCalled();

    void onRecreateCalled();

    void onBackPressedCalled();

    void onPauseCalled();

    void onDestroyCalled();

    void onOutstandingGradeBtnClicked();

    void onMentionGradeBtnClicked();

    void onPassGradeBtnClicked();
  }

  interface Model {
    String getStoredData();

    void onDataFromNextScreen(String data);

    void onRestartScreen(String data);
  }

}
