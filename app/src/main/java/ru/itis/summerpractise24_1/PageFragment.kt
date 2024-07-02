package ru.itis.summerpractise24_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import ru.itis.summerpractise24_1.databinding.FragmentPageBinding

class PageFragment : Fragment(R.layout.fragment_page) {

    private var binding : FragmentPageBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPageBinding.bind(view)
        val email = arguments?.getString(EMAIL)?:"Айсылу - самый лучший наставник"

        binding?.successTextView?.text = getString(R.string.your_email_is, email)
    }

    companion object {
        private val EMAIL = "email"

        fun bundle(email : String) = bundleOf(EMAIL to email)

    }
}