package me.varsha.badroadtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by abhishek on 06/10/17.
 */

public class PreferenceManager {
  private static final String TAG = PreferenceManager.class.getSimpleName();

  // Sharedpref file name
  private static final String PREF_NAME = "app_data";
  // All Shared Preferences Keys
  private static final String KEY_NOTIFICATIONS = "notifications";
  private static final String IS_FIRST_RUN = "is_first_run";
  private static final String KEY_IS_LOGGED_IN = "is_logged_in";
  // Shared Preferences
  SharedPreferences mPrefs;
  // Editor for Shared preferences
  SharedPreferences.Editor editor;
  // Context
  Context _context;
  // Shared pref mode
  int PRIVATE_MODE = 0;

  // Constructor
  public PreferenceManager(Context context) {
    this._context = context;
    mPrefs = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    editor = mPrefs.edit();
  }

  /**
   * Check if the user is running the app for the first time. Used to check if Intro Activities
   * should be showed.
   *
   * @return boolean value, true or false
   */
  public boolean getIsFirstRun() {
    return mPrefs.getBoolean(IS_FIRST_RUN, true);
  }

  public void setIsFirstRun(boolean firstRun) {
    editor.putBoolean(IS_FIRST_RUN, firstRun).apply();
  }

  /**
   * Check if the user is running the app for the first time. Used to check if Intro Activities
   * should be showed.
   *
   * @return boolean value, true or false
   */
  public boolean isLoggedIn() {
    return mPrefs.getBoolean(KEY_IS_LOGGED_IN, false);
  }

  public void setLogin(boolean isLoggedIn) {
    editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
    // commit changes
    editor.commit();

    Log.d(TAG, "User login session modified!");
  }

  /**
   * Clear shared preferences data (reset)
   */
  public void clear() {
    editor.clear();
    editor.commit();
  }
}
