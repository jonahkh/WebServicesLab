package jonahkh.tacoma.uw.edu.webserviceslab.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jonah on 4/20/2016.
 */
public class Course implements Serializable {
    public static final String ID = "id", SHORT_DESC = "shortDesc"
            , LONG_DESC = "longDesc", PRE_REQS = "prereqs";

    private  String mCourseId;
    private  String mShortDescription;
    private  String mLongDescription;
    private  String mPrereqs;


    public Course(String courseId, String shortDescription, String longDescription,
                  String prereqs) {
        mCourseId = courseId;
        mShortDescription = shortDescription;
        mLongDescription = longDescription;
        mPrereqs = prereqs;
    }

    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param courseJSON
     * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        Log.i("TAG", courseJSON);
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);

                for (int i = 0; i < arr.length(); i++) {
                    Log.e("JSONN", arr.getJSONObject(i).toString());
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID), obj.getString(Course.SHORT_DESC)
                            , obj.getString(Course.LONG_DESC), obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }

        }
        return reason;
    }


    public String getCourseId() {
        return mCourseId;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public String getLongDescription() {
        return mLongDescription;
    }

    public String getPrereqs() {
        return mPrereqs;
    }

    public void setShortDescription(String desc) {
        mShortDescription = desc;
    }

    public void setLongDescription(String desc) {
        mLongDescription = desc;
    }

    public void setPrereqs(String desc) {

        mPrereqs = desc;
    }

    public void setCourseId(String desc) {
        mCourseId = desc;
    }
}
