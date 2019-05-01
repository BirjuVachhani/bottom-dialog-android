package com.birjuvachhani.bottomdialog

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

/*
 * Created by Birju Vachhani on 01 May 2019
 * Copyright © 2019 bottom-dialog-android. All rights reserved.
 */

internal class BottomDialogPopup(context: Context, private val rootView: View) :
    PopupWindow(rootView, FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, true) {

    private val tvTitle = rootView.findViewById<AppCompatTextView>(R.id.tvTitle)
    private val tvMessage = rootView.findViewById<AppCompatTextView>(R.id.tvMessage)
    private val btnPositive = rootView.findViewById<AppCompatButton>(R.id.btnPositive)
    private val btnNegative = rootView.findViewById<AppCompatButton>(R.id.btnNegative)
    private val dialogContainer = rootView.findViewById<LinearLayout>(R.id.llDialogContainer)

    private var enterAnimation: Animation =
        AnimationUtils.loadAnimation(context, R.anim.anim_slide_in_from_bottom)
    private var exitAnimation: Animation =
        AnimationUtils.loadAnimation(context, R.anim.anim_slide_out_to_bottom)

    private val exitAnimationListener = object : Animation.AnimationListener {
        override fun onAnimationRepeat(animation: Animation?) {}

        override fun onAnimationEnd(animation: Animation?) {
            dismissPopup()
        }

        override fun onAnimationStart(animation: Animation?) {}

    }

    override fun dismiss() {
        exitAnimation.setAnimationListener(exitAnimationListener)
        dialogContainer.startAnimation(exitAnimation)
    }

    private fun dismissPopup() {
        super.dismiss()
    }

    private fun applyEnterAnimation() {
        dialogContainer.startAnimation(enterAnimation)
    }

    internal fun setTitle(title: String) {
        tvTitle.text = title
    }

    internal fun setMessage(message: String) {
        tvMessage.text = message
    }

    internal fun setPositiveButton(text: String, func: () -> Unit) {
        btnPositive?.text = text
        btnPositive?.setOnClickListener {
            func()
            dismiss()
        }
    }

    internal fun setNegativeButton(text: String, func: () -> Unit) {
        btnNegative?.text = text
        btnNegative?.setOnClickListener {
            func()
            dismiss()
        }
    }

    internal fun show() {
        showAtLocation(rootView, Gravity.BOTTOM, 0, 0)
        applyEnterAnimation()
    }
}