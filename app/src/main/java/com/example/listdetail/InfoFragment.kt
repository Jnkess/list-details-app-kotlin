package com.example.listdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES

class InfoFragment : Fragment(R.layout.fragment_info) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val sharedTime = requireActivity().getSharedPreferences("com.example.listdetail.shared",0)
        val darkMode = sharedTime.getBoolean("dark_mode", false)

        if (darkMode)
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)

        val edit = sharedTime.edit()

    }
}