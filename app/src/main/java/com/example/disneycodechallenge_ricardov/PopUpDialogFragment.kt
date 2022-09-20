package com.example.disneycodechallenge_ricardov

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment


class PopUpDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Reservation Needed")
            .setMessage("Select at least one guest that has a reservation to continue.")
            .setPositiveButton("OK") { _, _ -> }
            .create()

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // must be called before set content

        dialog.setCanceledOnTouchOutside(true)

        // Set the width to the screen width, close to the bottom of the screen.
        val window: Window? = dialog.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.BOTTOM
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT
        window.attributes = wlp

        return dialog
    }

    companion object {
        const val TAG = "PopUpDialog"
    }
}