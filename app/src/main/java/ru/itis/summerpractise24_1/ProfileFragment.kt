package ru.itis.summerpractise24_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractise24_1.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var binding: FragmentProfileBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)


        binding?.run {
            sendButton.setOnClickListener {
                val text = etEmail.text.toString()
                if (text.isEmpty()) {
                    Snackbar.make(view, "email is empty", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.bottomNavigation).show()
                } else {
                    findNavController().navigate(
                        R.id.action_profileFragment_to_pageFragment,
                        PageFragment.bundle(text)
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}