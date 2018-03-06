package org.descartae.android.view.fragments.intro

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_intro.*
import org.descartae.android.R

const val ARG_PAGE = "page"

class IntroFragment : Fragment() {

    private var page: Int = 0

    private var mListener: IntroListener? = null

    interface IntroListener {
        fun onStartApp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            page = arguments!!.getInt(ARG_PAGE, 0)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_intro, container, false)

        button_start.setOnClickListener { mListener?.onStartApp() }

        when (page) {
            0 -> {

                textView_title.setText(R.string.onboard_title_1)
                textView_subtitle.setText(R.string.onboard_subtitle_1)
                Picasso.with(activity).load(R.drawable.onboarding_1).into(imageView_intro)
                button_start.visibility = View.GONE

                return view
            }
            1 -> {

                textView_title.setText(R.string.onboard_title_2)
                textView_subtitle.setText(R.string.onboard_subtitle_2)
                Picasso.with(activity).load(R.drawable.onboarding_2).into(imageView_intro)
                button_start.visibility = View.GONE

                return view
            }
            2 -> {

                textView_title.setText(R.string.onboard_title_3)
                textView_subtitle.setText(R.string.onboard_subtitle_3)
                Picasso.with(activity).load(R.drawable.onboarding_3).into(imageView_intro)
                button_start.visibility = View.GONE

                return view
            }
            3 -> {

                textView_title.setText(R.string.onboard_title_4)
                textView_subtitle.setText(R.string.onboard_subtitle_4)
                Picasso.with(activity).load(R.drawable.onboarding_4).into(imageView_intro)
                button_start.visibility = View.VISIBLE

                return view
            }

            else -> return view
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is IntroListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement IntroListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    companion object {

        fun newInstance(page: Int): IntroFragment {
            val fragment = IntroFragment()
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            fragment.arguments = args
            return fragment
        }
    }
}