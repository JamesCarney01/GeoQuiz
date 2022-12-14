package com.example.geoquiz

import android.widget.Toast
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.math.log

private const val TAG = "QuizViewModel" // saved for log cat (debug)
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"


class QuizViewModel (private val savedStateHandle: SavedStateHandle): ViewModel() {


    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
    set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
    fun moveToPrevious() {
        currentIndex = (currentIndex - 1) % questionBank.size
//        val messageResId = if (currentIndex == 0) {
//            R.string.error_toast
//        } else {
//            currentIndex = (currentIndex - 1) % questionBank.size
//        }
//        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
//            .show()
    }
}