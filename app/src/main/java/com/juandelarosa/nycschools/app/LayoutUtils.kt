package com.juandelarosa.nycschools.app

import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import com.juandelarosa.nycschools.R

//Class dedicated to the interaction with the view
class LayoutUtils {
    companion object {

        //Show information box on the main screen
        fun showSnack(view: View, message: String) {
            val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            snackbar.setTextColor(ResourcesCompat.getColor(view.context.resources, R.color.design_default_color_error,null))
            snackbar.show()
        }
    }
}