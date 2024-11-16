package com.rubdashen.finsimple.menu.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.rubdashen.finsimple.R

class ViewProfileFragment : Fragment(R.layout.fragment_view_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Referencia al ImageView con el icono de edición
        val editImageView = view.findViewById<ImageView>(R.id.myImageView)

        // Establecer el listener para navegar al EditProfileFragment
        editImageView.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, EditProfileFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}

