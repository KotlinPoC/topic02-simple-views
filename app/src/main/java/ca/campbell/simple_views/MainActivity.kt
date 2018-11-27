package ca.campbell.simple_views

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

/*
 *  Sample code topic 2
 *  Demonstrates programmatic manipulation of Views defined in xml.
 *  Demonstrates simple use of an intent to invoke other activities.
 *
 *  Converted to Kotlin
 *
 *  @author pmcampbell
 *  @version 2018-11
 */

class MainActivity : Activity() {

    // one may use string here, EditText.getText() returns CharSequence
    // android uses CharSequence so that other objs like StringBuffers may be
    // specified
    // a String is-a CharSequence, CharSequence operates more generally
    private var str: CharSequence? = null
    // private String str;

    // variables for references to the View widgets
    private var msgHeader: TextView? = null
    private var msg: TextView? = null
    private var et: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // showData() is the method called by the View.OnClickListener()
    // defined in the xml in this case
    fun showData(view: View) {
        // get the references to the view widgets
        // no reference to the header TextView, I don't manipulate it
        et = findViewById(R.id.input) as EditText
        // get the data input
        str = et!!.text.toString()

        msgHeader = findViewById(R.id.resultheader) as TextView
        msgHeader!!.visibility = TextView.VISIBLE

        msg = findViewById(R.id.result) as TextView
        msg!!.visibility = TextView.VISIBLE
        msg!!.text = str

        // need minimum api 9 for str.isEmpty() :(
        if ((str as String).isEmpty()) {
            msgHeader!!.setText(R.string.emptymsg)
            Log.w(TAG, "showData(): no data")
        } else {
            if (str == SECRET) {
                msgHeader!!.setText(R.string.successmsg)
                Log.w(TAG, "showData(): guessed correctly")
            } else {
                msgHeader!!.setText(R.string.tryagainmsg)
                Log.w(TAG, "showData(): bad guess")
            }
        }
    } // showData()

    // another click listener, defined in xml
    fun clearData(view: View) {
        if (msgHeader != null) {
            msgHeader!!.visibility = TextView.INVISIBLE
            msg!!.visibility = TextView.INVISIBLE
            et!!.setText("")
            Log.w(TAG, "clearData(): reset fields")
        }
        Log.w(TAG, "clearData(): fields not set yet")
    } // clearData()

    // another click listener, defined in xml
    fun showActivity(view: View) {
        Log.d(TAG, "showActivity(): fire intent")
        val launchOtherScreen = Intent(applicationContext,
                OtherActivity::class.java)
        startActivity(launchOtherScreen)
    } // showActivity()

    // another click listener, defined in xml
    fun showActivityLL(view: View) {
        Log.d(TAG, "showActivityLL(): fire intent")
        val launchOtherActivity = Intent(applicationContext,
                WeightLinearLayout::class.java)
        startActivity(launchOtherActivity)
    } // showActivity()

    companion object {

        private val TAG = "RW-VIEWS"
        private val SECRET = "guacamole"
    }
}
