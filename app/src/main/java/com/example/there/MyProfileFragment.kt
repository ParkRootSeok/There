package com.example.there

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.there.databinding.FragmentMyprofileBinding


class MyProfileFragment : Fragment(){
    lateinit var binding: FragmentMyprofileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyprofileBinding.inflate(inflater, container, false)
        binding.btnMyprofileRecord.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm, MyRecordFragment()).commitAllowingStateLoss()
        }
        return binding.root
    }

    }
