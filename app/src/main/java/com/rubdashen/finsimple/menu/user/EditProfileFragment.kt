package com.rubdashen.finsimple.menu.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.rubdashen.finsimple.R

class EditProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_profile, container, false)

        // Botón Guardar
        val saveButton: Button = view.findViewById(R.id.btnSave)
        saveButton.setOnClickListener {
            parentFragmentManager.popBackStack() // Volver al fragmento anterior
        }

        // Botón Retroceder
        val backButton: Button = view.findViewById(R.id.btnBack)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack() // Volver al fragmento anterior
        }

        return view
    }
}
