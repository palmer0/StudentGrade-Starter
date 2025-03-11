package es.ulpgc.eite.studentgrade.student;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.studentgrade.app.AppMediator;
import es.ulpgc.eite.studentgrade.app.GradeToStudentState;
import es.ulpgc.eite.studentgrade.app.StudentToGradeState;

/**
 * Created by Luis on marzo, 2022
 */
public class StudentPresenter implements StudentContract.Presenter {

  public static String TAG = "StudentGrade.StudentPresenter";

  private WeakReference<StudentContract.View> view;
  private StudentState state;
  private StudentContract.Model model;
  private AppMediator mediator;

  public StudentPresenter(AppMediator mediator) {
    this.mediator = mediator;
    //state = mediator.getStudentState();
  }

  @Override
  public void onCreateCalled() {
    Log.e(TAG, "onCreateCalled()");

    // initialize the state 
    state = new StudentState();
    // TODO: insert code if necessary

    // call the model and update the state
    // TODO: insert code if necessary

  }

  @Override
  public void onRecreateCalled() {
    Log.e(TAG, "onRecreateCalled()");

    // get the saved state
    state = mediator.getStudentState();

    // update the model if is necessary
    // TODO: insert code if necessary

  }

  @Override
  public void onResumeCalled() {
    Log.e(TAG, "onResumeCalled()");

    // use passed state if is necessary
    GradeToStudentState savedState = getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      // TODO: insert code if necessary

      // update the state if is necessary
      // TODO: insert code if necessary
    }

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
    mediator.setStudentState(state);
  }

  @Override
  public void onDestroyCalled() {
    Log.e(TAG, "onDestroyCalled()");
  }

  private void onGradeBtnClicked(String data) {
    Log.e(TAG, "onGradeBtnClicked()");

    // TODO: insert code if necessary
  }

  @Override
  public void onOutstandingGradeBtnClicked() {
    Log.e(TAG, "onOutstandingGradeBtnClicked()");

    // TODO: insert code if necessary

  }

  @Override
  public void onMentionGradeBtnClicked() {
    Log.e(TAG, "onMentionGradeBtnClicked()");

    // TODO: insert code if necessary

  }

  @Override
  public void onPassGradeBtnClicked() {
    Log.e(TAG, "onPassGradeBtnClicked()");

    // TODO: insert code if necessary

  }

  private GradeToStudentState getStateFromNextScreen() {
    return mediator.getNextStudentScreenState();
  }

  private void passStateToNextScreen(StudentToGradeState state) {
    mediator.setNextStudentScreenState(state);
  }


  @Override
  public void injectView(WeakReference<StudentContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(StudentContract.Model model) {
    this.model = model;
  }

}
