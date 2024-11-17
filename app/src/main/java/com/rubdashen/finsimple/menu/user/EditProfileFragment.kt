package com.rubdashen.finsimple.menu.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rubdashen.finsimple.R
import com.rubdashen.finsimple.shared.api.ApiWorker
import com.rubdashen.finsimple.shared.api.user.request.EditProfileRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileFragment : Fragment(R.layout.fragment_edit_profile) {

    private lateinit var etCompanyName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etRUC: EditText
    private lateinit var btnSave: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etCompanyName = view.findViewById(R.id.etCompanyName)
        etEmail = view.findViewById(R.id.etEmail)
        etRUC = view.findViewById(R.id.etRUC)
        btnSave = view.findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            val companyName = etCompanyName.text.toString()
            val email = etEmail.text.toString()
            val ruc = etRUC.text.toString()

            val request = EditProfileRequest(companyName, email, ruc)
            ApiWorker.updateUserProfile(request).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        Toast.makeText(context, "Perfil actualizado", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Error al actualizar el perfil", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(context, "Error de red", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
