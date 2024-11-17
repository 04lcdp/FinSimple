package com.rubdashen.finsimple.menu.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.rubdashen.finsimple.R
import com.rubdashen.finsimple.shared.api.ApiWorker
import com.rubdashen.finsimple.shared.api.user.response.UserInformationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewProfileFragment : Fragment(R.layout.fragment_view_profile) {

    // TextViews para mostrar los datos del perfil
    private lateinit var tvCompany: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvRUC: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflamos el layout del fragmento
        return inflater.inflate(R.layout.fragment_view_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicialización de los elementos del layout
        tvCompany = view.findViewById(R.id.tvCompanyName)
        tvEmail = view.findViewById(R.id.tvEmail)
        tvRUC = view.findViewById(R.id.tvRUC)
        val editProfileOption: ImageView = view.findViewById(R.id.edit_profile_option)

        // Cargar información del perfil
        fetchUserInfo()

        // Manejar el clic en el icono de editar perfil
        editProfileOption.setOnClickListener {
            replaceFragment(EditProfileFragment())
        }
    }

    // Función para reemplazar el fragmento actual con el de edición de perfil
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = parentFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main, fragment)
        fragmentTransaction.addToBackStack(null) // Permitir regresar al fragmento anterior
        fragmentTransaction.commit()
    }

    // Función para obtener la información del usuario desde la API
    private fun fetchUserInfo() {
        ApiWorker.userInformation().enqueue(object : Callback<UserInformationResponse> {
            override fun onResponse(
                call: Call<UserInformationResponse>,
                response: Response<UserInformationResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { userInfo ->
                        tvCompany.text = userInfo.companyName
                        tvEmail.text = userInfo.email
                        tvRUC.text = userInfo.ruc
                    }
                } else {
                    Toast.makeText(context, "Error al obtener la información", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserInformationResponse>, t: Throwable) {
                Toast.makeText(context, "Error de red", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
