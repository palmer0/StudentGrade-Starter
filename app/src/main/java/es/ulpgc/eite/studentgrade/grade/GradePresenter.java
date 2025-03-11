package es.ulpgc.eite.studentgrade.grade;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.studentgrade.app.AppMediator;
import es.ulpgc.eite.studentgrade.app.GradeToStudentState;
import es.ulpgc.eite.studentgrade.app.StudentToGradeState;

/**
 * Created by Luis on marzo, 2022
 */
public class GradePresenter implements GradeContract.Presenter {

  public static String TAG = "StudentGrade.GradePresenter";

  private WeakReference<GradeContract.View> view;
  private GradeState state;
  private GradeContract.Model model;
  private AppMediator mediator;

  public GradePresenter(AppMediator mediator) {
    this.mediator = mediator;
    //state = mediator.getGradeState();
  }

  @Override
  public void onCreateCalled() {
    Log.e(TAG, "onCreateCalled()");

    // initialize the state 
    state = new GradeState();
    // TODO: insert code if necessary

    // call the model and update the state
    // TODO: insert code if necessary

    // use passed state if is necessary
    StudentToGradeState savedState = getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      // TODO: insert code if necessary

      // update the state if is necessary
      // TODO: insert code if necessary

    }
  }

  @Override
  public void onRecreateCalled() {
    Log.e(TAG, "onRecreateCalled()");

    // get the saved state
    state = mediator.getGradeState();

    // update the model if is necessary
    // TODO: insert code if necessary
  }

  @Override
  public void onResumeCalled() {
    Log.e(TAG, "onResumeCalled()");

    // call the model and update the state
    // TODO: insert code if necessary

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressedCalled() {
    Log.e(TAG, "onBackPressedCalled()");

    // TODO: insert code if necessary
  }

  @Override
  public void onPauseCalled() {
    Log.e(TAG, "onPauseCalled()");

    // save the current state
    mediator.setGradeState(state);
  }

  @Override
  public void onDestroyCalled() {
    Log.e(TAG, "onDestroyCalled()");
  }

  public void onGradeBtnClicked(String data) {
    Log.e(TAG, "onGradeBtnClicked()");

    // TODO: insert code if necessary
  }

  @Override
  public void onHigherGradeBtnClicked() {
    Log.e(TAG, "onHigherGradeBtnClicked()");

    // TODO: insert code if necessary

  }

  @Override
  public void onLowerGradeBtnClicked() {
    Log.e(TAG, "onLowerGradeBtnClicked()");

    // TODO: insert code if necessary

  }

  private void passStateToPreviousScreen(GradeToStudentState state) {
    mediator.setPreviousGradeScreenState(state);
  }

  private StudentToGradeState getStateFromPreviousScreen() {
    return mediator.getPreviousGradeScreenState();
  }

  @Override
  public void injectView(WeakReference<GradeContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(GradeContract.Model model) {
    this.model = model;
  }

}
