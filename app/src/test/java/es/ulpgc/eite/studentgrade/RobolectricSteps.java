package es.ulpgc.eite.studentgrade;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;

import es.ulpgc.eite.studentgrade.grade.GradeActivity;
import es.ulpgc.eite.studentgrade.student.StudentActivity;

/**
 * Created by Luis on marzo, 2022
 */
public class RobolectricSteps {


  private ActivityController<StudentActivity> studentTestCtrl;
  private ActivityController<GradeActivity> gradeTestCtrl;


  public void iAmOnScreen(String screen) {

    if(screen.equals("student")) {
      studentTestCtrl = Robolectric.buildActivity(StudentActivity.class);
      studentTestCtrl.create().resume().visible();

    } else {
      studentTestCtrl.pause();

      gradeTestCtrl = Robolectric.buildActivity(GradeActivity.class);
      gradeTestCtrl.create().resume().visible();
    }

  }


  public void iBackOnScreen(String screen) {

    if(screen.equals("student")) {
      studentTestCtrl.resume();

    } else {
      gradeTestCtrl.resume();
    }

  }

  public void iAmOnScreenAndSeeValueOnView(
      String screen, String value, String view
  ) {

    int viewId = (view.equals("lower")) ? R.id.btnLowerGrade :
        ((view.equals("higher")) ? R.id.btnHigherGrade : R.id.tvStudentGrade);


    if(screen.equals("student")) {
      StudentActivity activity = studentTestCtrl.get();

      TextView tv = (TextView) activity.findViewById(viewId);
      assertThat(tv.getText().toString(), equalTo(value));

    } else {
      GradeActivity activity = gradeTestCtrl.get();

      Button btn = (Button) activity.findViewById(viewId);
      assertThat(btn.getText().toString(), equalTo(value));
    }
  }

  public void iAmOnScreenAndPressButton(String screen, String button) {

    if(screen.equals("student")) {
      StudentActivity activity = studentTestCtrl.get();

      if(button.equals("back")) {
        activity.onBackPressed();

      } else {
        int viewId = (button.equals("outstanding")) ? R.id.btnOutstandingGrade :
            ((button.equals("mention")) ? R.id.btnMentionGrade : R.id.btnPassGrade);

        Button btn = activity.findViewById(viewId);
        btn.performClick();
      }

    } else {
      GradeActivity activity = gradeTestCtrl.get();

      if(button.equals("back")) {
        activity.onBackPressed();

      } else {
        int viewId =
            (button.equals("lower")) ? R.id.btnLowerGrade : R.id.btnHigherGrade;

        Button btn = activity.findViewById(viewId);
        btn.performClick();
      }
    }
  }


  public void iRotateScreen(String screen) {


    Bundle bundle = new Bundle();

    if(screen.equals("student")) {
      studentTestCtrl
          .saveInstanceState(bundle)
          .pause()
          .stop()
          .destroy();

      studentTestCtrl = Robolectric.buildActivity(StudentActivity.class)
          .create(bundle)
          .restoreInstanceState(bundle)
          .resume()
          .visible();

    } else {
      gradeTestCtrl
          .saveInstanceState(bundle)
          .pause()
          .stop()
          .destroy();

      gradeTestCtrl = Robolectric.buildActivity(GradeActivity.class)
          .create(bundle)
          .restoreInstanceState(bundle)
          .resume()
          .visible();
    }

  }

}
