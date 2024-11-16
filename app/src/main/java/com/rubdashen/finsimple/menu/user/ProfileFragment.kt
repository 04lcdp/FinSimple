package com.rubdashen.finsimple.menu.user

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.rubdashen.finsimple.R

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Referencia al TextView con el icono de usuario
        val perfilTextView = view.findViewById<TextView>(R.id.textViewPerfil)

        // Establecer el listener para navegar al ViewProfileFragment
        perfilTextView.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ViewProfileFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
