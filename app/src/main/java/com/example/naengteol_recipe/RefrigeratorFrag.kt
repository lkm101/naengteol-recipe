package com.example.naengteol_recipe

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.naengteol_recipe.databinding.FragRefrigeratorBinding


class RefrigeratorFrag: Fragment() {
    private var mBinding : FragRefrigeratorBinding? = null
    private val binding get() = mBinding!!

    private var foodFlag = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragRefrigeratorBinding.inflate(inflater, container,false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.edtFood.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                if(binding.edtFood.text.isNotEmpty()) {
                    binding.btnCirclePlus.setImageResource(R.drawable.ic_plus_white)
                    binding.btnCirclePlus.setBackgroundResource(R.drawable.button_linear_enable)
                    foodFlag = true
                } else {
                    binding.btnCirclePlus.setImageResource(R.drawable.ic_plus_gray)
                    binding.btnCirclePlus.setBackgroundResource(R.drawable.button_linear_disable)
                    foodFlag = false
                }
            }
        })
    }
}