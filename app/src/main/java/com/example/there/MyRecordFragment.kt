package com.example.there

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.there.databinding.FragmentMyrecordBinding
import com.google.android.material.tabs.TabLayoutMediator

class MyRecordFragment :Fragment() {
    lateinit var binding : FragmentMyrecordBinding

    private val information = arrayListOf(R.drawable.btn_myrecord_folder, R.drawable.btn_myrecord_chatting);


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyrecordBinding.inflate(inflater, container, false)

        //하단 창 전환
        val myRecordAdapter = MyRecordVPAdapter(this)
        binding.myrecordContentVp.adapter = myRecordAdapter
        TabLayoutMediator(binding.tabMyrecordTl, binding.myrecordContentVp){
            tab, position ->
            tab.setIcon(information[position])
        }.attach()

        //이전 페이지 이동
        binding.btnMyrecordBackarrowIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm, MyProfileFragment()).commitAllowingStateLoss()
        }

        return binding.root
    }
}