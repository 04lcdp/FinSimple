package com.rubdashen.finsimple.menu.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.rubdashen.finsimple.R
import com.rubdashen.finsimple.menu.user.ViewProfileFragment
import com.rubdashen.finsimple.menu.wallet.bills.models.BillView
import com.rubdashen.finsimple.menu.wallet.information.BillInformationFragment

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.changeToViewProfile()
        val userOption: Button = view.findViewById(R.id.user_option)
        userOption.setOnClickListener {
            replaceFragment(ViewProfileFragment())
        }
    }

    private fun changeToViewProfile(): Unit {
        val createViewProfileFragment: Button = view?.findViewById(R.id.user_option)!!
        createViewProfileFragment.setOnClickListener {
            this.replaceFragment(ViewProfileFragment())
        }
    }


    private fun replaceFragment(fragment: Fragment): Unit {
        val fragmentManager: FragmentManager = this.parentFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main, fragment)
        fragmentTransaction.commit()
    }

}
