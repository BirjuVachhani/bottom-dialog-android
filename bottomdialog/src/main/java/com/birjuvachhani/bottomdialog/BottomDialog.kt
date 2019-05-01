package com.birjuvachhani.bottomdialog

import android.content.Context
import android.view.LayoutInflater


/*
 * Created by Birju Vachhani on 30 April 2019
 * Copyright © 2019 bottom-dialog-android. All rights reserved.
 */

class BottomDialog internal constructor(context: Context) {

    private val popup = BottomDialogPopup(
        context,
        LayoutInflater.from(context).inflate(R.layout.bottom_dialog_default, null)
    )

    fun setTitle(title: String) {
        popup.setTitle(title)
    }

    fun setMessage(message: String) {
        popup.setMessage(message)
    }

    fun setPositiveButton(text: String, func: () -> Unit) {
        popup.setPositiveButton(text, func)
    }

    fun setNegativeButton(text: String, func: () -> Unit) {
        popup.setNegativeButton(text, func)
    }

    fun show() {
        popup.show()
    }

    class Builder(context: Context) {
        private val dialog = BottomDialog(context)

        fun setTitle(title: String) = this.apply {
            dialog.setTitle(title)
        }

        fun setMessage(message: String) = this.apply {
            dialog.setMessage(message)
        }

        fun setPositiveButton(text: String, func: () -> Unit) = this.apply {
            dialog.setPositiveButton(text, func)
        }

        fun setNegativeButton(text: String, func: () -> Unit) = this.apply {
            dialog.setNegativeButton(text, func)
        }

        fun build() = dialog
    }
}