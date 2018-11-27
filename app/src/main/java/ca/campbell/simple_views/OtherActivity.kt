package ca.campbell.simple_views

import android.app.Activity
import android.os.Bundle
/*
 *  Sample code topic 2
 *  This app is invoked by main activty  demostrates app stack.
 *
 *  Converted to Kotlin
 *
 *  @author pmcampbell
 *  @version 2018-11
 */
class OtherActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
    }
}
